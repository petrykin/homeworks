package lesson15.task3;

import java.util.Map;
import java.util.Set;

public class MapIteration {
    public static <K, V> void printByKeySet(Map<K, V> map) {
        for (K key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
        System.out.println();
    }

    public static <K, V> void printByValues(Map<K, V> map) {
        for (V value : map.values()) {
            System.out.println(value);
        }
        System.out.println();
    }

    public static <K, V> void printByEntrySet(Map<K, V> map) {
        Set<Map.Entry<K, V>> entrySet = map.entrySet();
        for (Map.Entry<K, V> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
    }
}
