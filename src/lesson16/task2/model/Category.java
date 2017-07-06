package lesson16.task2.model;

import java.io.Serializable;

public enum Category implements Serializable {
    ALL("Все товары"),
    VIDEOCARD("Видеокарты"),
    CPU("Процессоры"),
    MOTHERBOARD("Материнские платы"),
    MEMORY("Память"),
    HDD("Жесткие диски"),
    POWER("Блоки питания"),
    SOUNDCARD("Звуковые карты");

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;
}