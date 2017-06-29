package lesson16.task2.gui;

import lesson16.task2.model.Item;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyTableModel implements TableModel {
    private List<Item> items;

    public List<Item> getItems() {
        if (items != null) {
            return items;
        } else {
            return new ArrayList<>();
        }
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    private Set<TableModelListener> listeners = new HashSet<>();

    public MyTableModel() {
        setItems(new ArrayList<>());
    }

    public MyTableModel(List<Item> items) {
        setItems(items);
    }

    @Override
    public int getRowCount() {
        return getItems().size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Название";
            case 1:
                return "Цена, грн";
            case 2:
                return "Рейтинг";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Double.class;
            case 2:
                return Integer.class;
        }
        return Object.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = getItems().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getName();
            case 1:
                return item.getPrice();
            case 2:
                return item.getRank();
        }
        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }
}
