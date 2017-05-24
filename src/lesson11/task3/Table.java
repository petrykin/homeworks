package lesson11.task3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class Table {
    private List<Class<?>> classes;
    private List<CheckingMethod> methods;

    public Table() {
        classes = new ArrayList<>();
        classes.add(Boolean.class);
        classes.add(Byte.class);
        classes.add(Short.class);
        classes.add(Character.class);
        classes.add(Integer.class);
        classes.add(Long.class);
        classes.add(Float.class);
        classes.add(Double.class);

        methods = new ArrayList<>();
        methods.add(new CheckingMethod("byteValue"));
        methods.add(new CheckingMethod("doubleValue"));
        methods.add(new CheckingMethod("floatValue"));
        methods.add(new CheckingMethod("intValue"));
        methods.add(new CheckingMethod("longValue"));
        methods.add(new CheckingMethod("shortValue"));
        methods.add(new CheckingClassMethod("parse", 1));
        methods.add(new CheckingClassMethod("parse", 2));
        methods.add(new CheckingMethod("valueOf", 2));
        methods.add(new CheckingMethod("toString"));
        methods.add(new CheckingMethod("toString", 1));
        methods.add(new CheckingMethod("toString", 2));
    }

    public void toFile(String fileName) {
        try (FileWriter fw = new FileWriter(fileName)){
            fw.write(getHeader());
            for (CheckingMethod method : methods) {
                fw.write(getRow(method));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printTable() {
        printHeader();
        printBody();
    }

    private void printHeader() {
        System.out.print(getHeader());
    }

    private String getHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append("|                          |");
        for (Class<?> aClass : classes) {
            sb.append(new Formatter().format("%-10s|", aClass.getSimpleName()));
        }
        sb.append("isStatic? |\n");
        sb.append(getBottomBorderLine());
        return sb.toString();
    }

    private void printBody() {
        for (CheckingMethod method : methods) {
            printRow(method);
        }
    }

    private void printRow(CheckingMethod method) {
        System.out.print(getRow(method));
    }

    private String getRow(CheckingMethod method) {
        StringBuilder sb = new StringBuilder();
        sb.append("| ");
        sb.append(new Formatter().format("%-25s", getTableMethodName(method)).toString());
        sb.append("|");
        for (Class<?> aClass : classes) {
            sb.append("    ");
            sb.append(method.isContainedIn(aClass) ? 'x' : ' ');
            sb.append("     |");
        }
        sb.append(new Formatter().format("    %-6s|\n", method.isStatic() ? '\u2713' : ' '));
        sb.append(getBottomBorderLine());
        return sb.toString();
    }

    private String getTableMethodName(CheckingMethod method) {
        switch (method.getName()) {
            case "parse":
                return method.getParameterCount() == 2 ? "parseXxx with radix" : "parseXxx";
            case "valueOf":
                return "valueOf with radix";
            case "toString":
                return (method.getParameterCount() == 0) ?
                        method.getName() : (method.getParameterCount() == 1) ?
                        method.getName() + "(primitive)" : method.getName() + "(primitive,radix)";
            default:
                return method.getName();
        }
    }

    private String getBottomBorderLine() {
        return "|--------------------------+----------+----------+----------+----------+" +
                "----------+----------+----------+----------+----------|\n";
    }
}
