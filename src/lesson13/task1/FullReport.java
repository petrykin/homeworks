package lesson13.task1;

import lesson12.task6.Employee;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class FullReport {
    public static void generateFullReport(Locale locale, Employee[] employees) throws UnsupportedEncodingException {
        ResourceBundle rb = ResourceBundle.getBundle("text", locale);
        String headerFIO = new String(rb.getString("headerFIO").getBytes("ISO-8859-1"), "UTF-8");
        String headerSalary = new String(rb.getString("headerSalary").getBytes("ISO-8859-1"), "UTF-8");
        String headerSalaryDate = new String(rb.getString("headerSalaryDate").getBytes("ISO-8859-1"), "UTF-8");

        printHeader(headerFIO, headerSalary, headerSalaryDate);
        printEmployeeInfo(getNumberFormat(locale), getDateFormat(locale), employees);
        System.out.println();
    }

    private static void printHeader(String col1Head, String col2Head, String col3Head) {
        System.out.printf("|  %-18s|%23s |%23s |%n", col1Head, col2Head, col3Head);
        printBorder();
    }

    private static void printEmployeeInfo(NumberFormat nf, DateFormat df, Employee[] employees) {
        for (Employee employee : employees) {
            String[] fio = employee.getFullName().split("\\s+");
            System.out.printf(Locale.ROOT, "|  %s.%s. %-13s|%23s |%23s |%n",
                    fio[1].substring(0, 1), fio[2].substring(0, 1), fio[0], nf.format(employee.getSalary()),
                    df.format(employee.getSalaryDate()));
            printBorder();
        }
    }

    private static void printBorder() {
        System.out.printf("|--------------------+------------------------+------------------------|%n");
    }

    private static NumberFormat getNumberFormat(Locale locale) {
        NumberFormat nf = NumberFormat.getInstance(locale);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf;
    }

    private static DateFormat getDateFormat(Locale locale) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        return df;
    }
}
