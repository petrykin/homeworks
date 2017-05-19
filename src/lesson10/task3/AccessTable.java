package lesson10.task3;

public class AccessTable {
    public static void printAccessTable() {
        System.out.print(getTableHeader());
        System.out.print(getTableBody());
    }

    private static String getTableHeader() {
        return "|     |                       |   private   |   default   |  protected  |    public   |\n" +
                "|-----|-----------------------+-------------+-------------+-------------+-------------|\n";
    }

    private static String getTableBody() {
        return "|  1. | Один и тот же класс   |      +      |      +      |      +      |      +      |\n" +
                "|-----|-----------------------+-------------+-------------+-------------+-------------|\n" +
                "|  2. | Подкласс, производный |             |             |             |             |\n" +
                "|     | от класса из того же  |      -      |      +      |      +      |      +      |\n" +
                "|     | самого пакета         |             |             |             |             |\n" +
                "|-----|-----------------------+-------------+-------------+-------------+-------------|\n" +
                "|  3. | Класс из того же      |             |             |             |             |\n" +
                "|     | самого пакета, не     |      -      |      +      |      +      |      +      |\n" +
                "|     | являющийся подклассом |             |             |             |             |\n" +
                "|-----|-----------------------+-------------+-------------+-------------+-------------|\n" +
                "|  4. | Подкласс, производный |             |             |             |             |\n" +
                "|     | от класса из другого  |      -      |      -      |      +      |      +      |\n" +
                "|     | пакета                |             |             |             |             |\n" +
                "|-----|-----------------------+-------------+-------------+-------------+-------------|\n" +
                "|  5. | Класс из другого      |             |             |             |             |\n" +
                "|     | пакета, не являющийся |             |             |             |             |\n" +
                "|     | подклассом,           |      -      |      -      |      -      |      +      |\n" +
                "|     | производный от класса |             |             |             |             |\n" +
                "|     | из данного пакета     |             |             |             |             |\n" +
                "|-----|-----------------------+-------------+-------------+-------------+-------------|\n";
    }
}
