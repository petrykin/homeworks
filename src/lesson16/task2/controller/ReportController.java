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

public class ReportController {
    public static String getBucketContent(User user) {
        String bucketContent = "";
        try (StringWriter sw = new StringWriter();
             PrintWriter pw = new PrintWriter(sw)) {
            pw.printf("+-----------+---------------------------------------------------------------------------+---------------+---------------+---------------+\n");
            pw.printf("|%-10s|%-75s|%-15s|%-15s|%-15s|\n", "№", "Товар", "Количество", "Цена, грн", "Сумма, грн");
            pw.printf("+-----------+---------------------------------------------------------------------------+---------------+---------------+---------------+\n");
            int numberOfItem = 0;
            double totalItemCost = 0.0;
            double totalCost = 0.0;
            for (Map.Entry<Item, Integer> itemEntry : user.getBucket().getItems().entrySet()) {
                totalItemCost = itemEntry.getValue() * itemEntry.getKey().getPrice();
                totalCost += totalItemCost;
                pw.printf(Locale.ROOT, "|%-11d|%-75s|%-15d|%-15.2f|%-15.2f|\n",
                        ++numberOfItem,
                        itemEntry.getKey().getName(),
                        itemEntry.getValue(),
                        itemEntry.getKey().getPrice(),
                        totalItemCost
                );
                pw.printf("+-----------+---------------------------------------------------------------------------+---------------+---------------+---------------+\n");
            }
            pw.printf("|%103s|%-15s|%-15.2f|\n", "", "Итого:", totalCost);
            pw.printf("+-------------------------------------------------------------------------------------------------------+---------------+---------------+");
            bucketContent = sw.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bucketContent;
    }

    public static void toLogFile(User user) {
        Date currentTime = new Date();
        String s = user.getLogin() + '_' + new SimpleDateFormat("ddMMyy_HHmm").format(currentTime) + ".txt";
        try (PrintWriter pw = new PrintWriter("src\\lesson16\\task2\\salechecks\\" + s)) {
            pw.printf("%S %2$td %2$tB %2$tY г.\n\n", "товарный чек от", currentTime);
            pw.printf("%-15s %s\n", "поставщик:", "Petrykin's MINI-SHOP LTD");
            pw.printf("%-15s %s\n\n", "покупатель:", user.getLogin());
            pw.printf(getBucketContent(user));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
