package lesson12.task4;

public class Demo {
    public static void main(String[] args) {
        String text = "Object oriented programming is a programming paradigm \n" +
                "based on the concept of \"objects\". " +
                "Object oriented programming languages typically share low-level \n" +
                "features with high-level procedural programming languages \n" +
                "(which were invented first). Languages that support object oriented \n" +
                "programming typically use inheritance for code reuse and extensibility \n" +
                "in the form of either classes or prototypes. Encapsulation is \n" +
                "an Object Oriented Programming concept that binds together the data and \n" +
                "functions that manipulate the data, and that keeps both safe from \n" +
                "outside interference and misuse.";

        String regexp = "(?i)object\\s*oriented\\s*programming";
        text = text.replaceAll(regexp, "OOP");
        System.out.println(text);
    }
}
