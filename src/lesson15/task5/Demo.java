package lesson15.task5;

import lesson14.task5.Item;

import java.util.Iterator;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Category hdd = new Category("HDD");
        fillCategory(hdd);
        System.out.println("Отсортировано в прямом порядке по имени:");
        printItems(hdd.sortByName());
        System.out.println("Отсортировано в обратном порядке по имени:");
        printItems(hdd.reverseSortByName());
        System.out.println("Отсортировано в прямом порядке по цене:");
        printItems(hdd.sortByPrice());
        System.out.println("Отсортировано в обратном порядке по цене:");
        printItems(hdd.reverseSortByPrice());
        System.out.println("Отсортировано в прямом порядке по рейтингу:");
        printItems(hdd.sortByRating());
        System.out.println("Отсортировано в обратном порядке по рейтингу:");
        printItems(hdd.reverseSortByRating());
    }

    public static void fillCategory(Category category) {
        category.addItem(new Item("Transcend StoreJet 25M3 1 TB (TS1TSJ25M3)", 1858, 5));
        category.addItem(new Item("Western Digital Caviar Black 1 TB (WD1002FAEX)", 997, 1));
        category.addItem(new Item("Kingston SSDNow V300 120 GB (SV300S37A/120G)", 1703, 4));
        category.addItem(new Item("Seagate Pipeline HD 160 GB (ST3160310CS)", 245, 3));
        category.addItem(new Item("Samsung 960 Evo M.2 250 GB (MZV6E250BW)", 4050, 2));
    }

    public static void printItems(List<Item> itemList) {
        Iterator<Item> iterator = itemList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }
}
