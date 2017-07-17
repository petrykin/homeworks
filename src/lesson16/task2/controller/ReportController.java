package lesson16.task2.controller;

import lesson16.task2.model.Item;
import lesson16.task2.model.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import static lesson16.task2.Launcher.splitter;

public class ReportController {
    private final static String stringLine = "+-----------+--" +
            "------------------------------------------------" +
            "-------------------------+---------------+------" +
            "---------+---------------+";
    private final static String footerLine = "+--------------" +
            "------------------------------------------------" +
            "-----------------------------------------+------" +
            "---------+---------------+";

    private static String getBucketContent(User user) {
        String bucketContent = "";
        try (StringWriter sw = new StringWriter();
             PrintWriter pw = new PrintWriter(sw)) {
            pw.printf("%s%n", stringLine);
            pw.printf("|%-11s|%-75s|%-15s|%-15s|%-15s|%n", "№", "Товар", "Количество", "Цена, грн", "Сумма, грн");
            pw.printf("%s%n", stringLine);
            int numberOfItem = 0;
            double totalCost = 0.0;
            double totalItemCost;
            for (Map.Entry<Item, Integer> itemEntry : user.getBucket().getItems().entrySet()) {
                totalItemCost = itemEntry.getValue() * itemEntry.getKey().getPrice();
                totalCost += totalItemCost;
                pw.printf(Locale.ROOT, "|%-11d|%-75s|%-15d|%-15.2f|%-15.2f|%n",
                        ++numberOfItem,
                        itemEntry.getKey().getName(),
                        itemEntry.getValue(),
                        itemEntry.getKey().getPrice(),
                        totalItemCost
                );
                pw.printf("%s%n", stringLine);
            }
            pw.printf("|%103s|%-15s|%-15.2f|%n", "", "Итого:", totalCost);
            pw.printf("%s", footerLine);
            bucketContent = sw.toString();
        } catch (IOException e) {
            System.err.println("Report IOException: " + e);
        }
        return bucketContent;
    }

    public static void toLogFile(User user) {
        Date currentTime = new Date();
        String logFileName = user.getLogin() + '_' +
                new SimpleDateFormat("ddMMyy_HHmm").format(currentTime) + ".txt";
        try (PrintWriter pw = new PrintWriter("src" + splitter +
                "lesson16" + splitter + "task2" + splitter + "salechecks" + splitter + logFileName)) {
            pw.printf("%S %2$td %2$tB %2$tY г.%n%n", "товарный чек от", currentTime);
            pw.printf("%-15s %s%n", "поставщик:", "Petrykin's MINI-SHOP LTD");
            pw.printf("%-15s %s%n%n", "покупатель:", user.getLogin());
            pw.printf(getBucketContent(user));
        } catch (FileNotFoundException e) {
            System.err.println("Report FileNotFoundException: " + e);
        }
    }
}
