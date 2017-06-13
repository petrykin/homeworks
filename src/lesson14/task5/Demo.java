package lesson14.task5;

import java.util.Comparator;
import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        Category hdd = new Category("HDD", new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        fillCategory(hdd);
        printItems(hdd);

        hdd = new Category("HDD", new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        fillCategory(hdd);
        printItems(hdd);

        hdd = new Category("HDD", new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                int ratingDiff =  Integer.compare(o1.getRating(), o2.getRating());
                return ratingDiff != 0 ? ratingDiff : 1;
            }
        });
        fillCategory(hdd);
        printItems(hdd);
    }

    public static void fillCategory(Category category) {
        category.addItem(new Item("Western Digital Caviar Blue 1 TB (WD10EZEX)", 1340, 3));
        category.addItem(new Item("Transcend StoreJet 25M3 1 TB (TS1TSJ25M3)", 1858, 5));
        category.addItem(new Item("Samsung 750 Evo 120 GB (MZ750120BW)", 1708, 2));
        category.addItem(new Item("Western Digital Caviar Black 1 TB (WD1002FAEX)", 997, 1));
        category.addItem(new Item("Kingston SSDNow V300 120 GB (SV300S37A/120G)", 1703, 4));
        category.addItem(new Item("Toshiba Canvio Basics 1 TB (HDTB310EK3AA)", 1558, 3));
        category.addItem(new Item("Kingston SSDNow UV400 120 GB (SUV400S37/120G)", 1562, 5));
        category.addItem(new Item("Seagate Pipeline HD 160 GB (ST3160310CS)", 245, 3));
        category.addItem(new Item("Kingston SSDNow V300 240 GB (SV300S37A/240G)", 2524, 1));
        category.addItem(new Item("Samsung 960 Evo M.2 250 GB (MZV6E250BW)", 4050, 2));
    }

    public static void printItems(Category category) {
        Iterator<Item> iterator = category.getItemSet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }
}
