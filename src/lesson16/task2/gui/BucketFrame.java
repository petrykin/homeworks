package lesson16.task2.gui;

import lesson16.task2.controller.ReportController;
import lesson16.task2.model.Bucket;
import lesson16.task2.model.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class BucketFrame extends JFrame implements ActionListener {
    private MainWindow parent;
    private JPanel rootPanel = new JPanel(new BorderLayout());
    private JPanel bottomPanel = new JPanel();
    private JTable bucketTable = new JTable();
    private JButton btnClear = new JButton("Очистить корзину");
    private JButton btnBuy = new JButton("Оформить покупку");
    private JButton btnCancel = new JButton("К списку товаров");

    public BucketFrame(MainWindow parent) {
        super("Корзина");
        this.parent = parent;
        setPreferredSize(new Dimension(800, 300));
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(rootPanel(), BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel rootPanel() {
        btnBuy.addActionListener(this);
        btnClear.addActionListener(this);
        btnCancel.addActionListener(this);
        bottomPanel.add(btnBuy);
        bottomPanel.add(btnClear);
        bottomPanel.add(btnCancel);
        createTable(bucketTable);
        rootPanel.add(new JScrollPane(bucketTable), BorderLayout.CENTER);
        rootPanel.add(bottomPanel, BorderLayout.SOUTH);
        return rootPanel;
    }

    private void createTable(JTable table) {
        String[] columns = {"№", "Наименование товара", "Количество, шт", "Цена, грн", "Стоимость, грн"};
        Bucket bucket = parent.getSession().getCurrentUser().getBucket();
        Object[][] data = new Object[bucket.getItems().size() + 1][];
        int count = 0;
        double itemTotalCost = 0.0;
        double allTotalCost = 0.0;
        for (Map.Entry<Item, Integer> entry : bucket.getItems().entrySet()) {
            itemTotalCost = entry.getValue() * entry.getKey().getPrice();
            allTotalCost += itemTotalCost;
            data[count] = new Object[]{
                    ++count,
                    entry.getKey().getName(),
                    entry.getValue(),
                    entry.getKey().getPrice(),
                    itemTotalCost
            };
        }
        data[count] = new Object[]{"", "", "", "Итого:", allTotalCost};
        bucketTable.setModel(new DefaultTableModel(data, columns));
        bucketTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        bucketTable.getColumnModel().getColumn(1).setPreferredWidth(460);
        bucketTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        bucketTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        bucketTable.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBuy)) {
            ReportController.toLogFile(parent.getSession().getCurrentUser());
        } else if (e.getSource().equals(btnClear)) {
            parent.getSession().getCurrentUser().getBucket().clearBucket();
            parent.repaintHeader();
        }
        BucketFrame.this.dispose();
    }
}
