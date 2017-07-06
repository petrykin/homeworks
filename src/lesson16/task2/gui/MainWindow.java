package lesson16.task2.gui;

import lesson16.task2.controller.BucketController;
import lesson16.task2.controller.CategoryController;
import lesson16.task2.controller.ItemController;
import lesson16.task2.model.AppSession;
import lesson16.task2.model.Category;
import lesson16.task2.model.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static lesson16.task2.model.Category.ALL;
import static lesson16.task2.model.Category.VIDEOCARD;

public class MainWindow extends JFrame implements MouseListener {
    private JPanel rootPanel = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JPanel btnPanel = new JPanel(new GridLayout(1, 2));
    private JPanel westPanel = new JPanel();
    private JPanel itemPanel = new JPanel();
    private JPanel itemSortPanel = new JPanel();
    private JPanel itemTableBucketPanel = new JPanel(new BorderLayout());
    private JLabel userLabel = new JLabel(" Пользователь: гость");
    private JButton btnUp = new JButton();
    private JButton btnIn = new JButton();
    private JButton btnOut = new JButton();
    private JButton buySubmit = new JButton();
    private ButtonGroup sbg = new ButtonGroup();
    private JTable itemsTable = new JTable();
    private MyTableModel tableModel = new MyTableModel();
    private AppSession session;

    public MainWindow() {
        session = new AppSession();
        setTitle("LESSON 16(17) - MINI SHOP");
        setPreferredSize(new Dimension(1000, 500));
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(composeRootPanel());
        setVisible(true);
    }

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public AppSession getSession() {
        return session;
    }

    private JPanel composeRootPanel() {
        rootPanel.setLayout(new BorderLayout());
        rootPanel.add(composeHeaderPanel(), BorderLayout.NORTH);
        rootPanel.add(composeWestPanel(), BorderLayout.WEST);
        rootPanel.add(composeItemPanel(), BorderLayout.CENTER);
        return rootPanel;
    }

    private JPanel composeHeaderPanel() {
        headerPanel.setLayout(new GridLayout(1, 2));
        headerPanel.add(userLabel);
        createBtnPanel();
        headerPanel.add(getBtnPanel());
        return headerPanel;
    }

    public void createBtnPanel() {
        btnUp.setText("Регистрация");
        btnUp.addActionListener(e -> {
            RegLogin.instance(MainWindow.this).setVisible(true);
        });

        btnIn.setText("Войти");
        btnIn.addActionListener(e -> {
            Login.instance(MainWindow.this).setVisible(true);
        });

        buySubmit.setText("Корзина");
        buySubmit.addActionListener(e -> {
            new BucketFrame(MainWindow.this);
        });

        btnOut.setText("Выйти");
        btnOut.addActionListener(e -> {
            if (!session.getCurrentUser().getBucket().isEmpty()) {
                BucketController.serializeBucket(session.getCurrentUser());
            }
            session.newUser("", "");
            userLabel.setText("Пользователь: " + session.getCurrentUserName());
            getBtnPanel();
        });
    }

    public JPanel getBtnPanel() {
        btnPanel.removeAll();
        if (session.isGuest()) {
            btnPanel.add(btnUp);
            btnPanel.add(btnIn);
        } else {
            btnPanel.add(buySubmit);
            btnPanel.add(btnOut);
        }
        btnPanel.repaint();
        btnPanel.revalidate();
        return btnPanel;
    }

    private JPanel composeWestPanel() {
        westPanel.setLayout(new BorderLayout());
        JComboBox<String> cb = new JComboBox<>();
        cb.setMaximumRowCount(10);
        cb.addItem(ALL.getName());
        for (Category category : CategoryController.categories()) {
            cb.addItem(category.getName());
        }
        session.setCurrentCategory(Category.byName(cb.getSelectedItem().toString()));
        tableModel = new MyTableModel(ItemController.itemsByCategory(session.getCurrentCategory()));
        itemsTable.setModel(tableModel);
        itemTableBucketPanel.repaint();
        itemTableBucketPanel.revalidate();
        cb.addActionListener(e -> {
            sbg.clearSelection();
            session.setCurrentCategory(Category.byName(cb.getSelectedItem().toString()));
            tableModel = new MyTableModel(ItemController.itemsByCategory(session.getCurrentCategory()));
            itemsTable.setModel(tableModel);
            itemTableBucketPanel.repaint();
            itemTableBucketPanel.revalidate();
        });
        westPanel.add(cb, BorderLayout.NORTH);
        westPanel.add(composeSortPanel(), BorderLayout.CENTER);
        return westPanel;
    }

    private JPanel composeItemPanel() {
        itemPanel.setLayout(new BorderLayout());
        itemPanel.add(composeTablePanel(), BorderLayout.CENTER);
        return itemPanel;
    }

    private JPanel composeSortPanel() {
        itemSortPanel.setLayout(new GridLayout(6, 1));
        JLabel label = new JLabel("Сортировать");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        itemSortPanel.add(label);

        JRadioButton sortByName = new JRadioButton(" по названию (А-Я)");
        sortByName.addActionListener(e -> {
            List<Item> itemList = tableModel.getItems();
            itemList.sort(Comparator.comparing(Item::getName));
            tableModel.setItems(itemList);
            itemTableBucketPanel.repaint();
            itemTableBucketPanel.revalidate();
        });
        sbg.add(sortByName);

        JRadioButton sortReverseByName = new JRadioButton(" по названию (Я-А)");
        sortReverseByName.addActionListener(e -> {
            List<Item> itemList = tableModel.getItems();
            Collections.sort(itemList, Collections.reverseOrder(Comparator.comparing(Item::getName)));
            tableModel.setItems(itemList);
            itemTableBucketPanel.repaint();
            itemTableBucketPanel.revalidate();
        });
        sbg.add(sortReverseByName);

        JRadioButton sortByCost = new JRadioButton(" от дешевых к дорогим");
        sortByCost.addActionListener(e -> {
            List<Item> itemList = tableModel.getItems();
            itemList.sort(Comparator.comparing(Item::getPrice));
            tableModel.setItems(itemList);
            itemTableBucketPanel.repaint();
            itemTableBucketPanel.revalidate();
        });
        sbg.add(sortByCost);

        JRadioButton sortReverseByCost = new JRadioButton(" от дорогих к дешевым");
        sortReverseByCost.addActionListener(e -> {
            List<Item> itemList = tableModel.getItems();
            Collections.sort(itemList, Collections.reverseOrder(Comparator.comparing(Item::getPrice)));
            tableModel.setItems(itemList);
            itemTableBucketPanel.repaint();
            itemTableBucketPanel.revalidate();
        });
        sbg.add(sortReverseByCost);

        JRadioButton sortByRank = new JRadioButton(" по популярности");
        sortByRank.addActionListener(e -> {
            List<Item> itemList = tableModel.getItems();
            Collections.sort(itemList, Collections.reverseOrder(Comparator.comparing(Item::getRank)));
            tableModel.setItems(itemList);
            itemTableBucketPanel.repaint();
            itemTableBucketPanel.revalidate();
        });
        sbg.add(sortByRank);

        itemSortPanel.add(sortByName);
        itemSortPanel.add(sortReverseByName);
        itemSortPanel.add(sortByCost);
        itemSortPanel.add(sortReverseByCost);
        itemSortPanel.add(sortByRank);
        return itemSortPanel;
    }

    public JPanel composeTablePanel() {
        itemsTable.addMouseListener(this);
        itemTableBucketPanel.add(new JScrollPane(itemsTable), BorderLayout.CENTER);
        return itemTableBucketPanel;
    }

    public void repaintHeader() {
        String text = "Пользователь: " + session.getCurrentUserName() +
                (!session.isGuest() ? ", товаров в корзине: " +
                        session.getCurrentUser().getBucket().size() : "");
        userLabel.setText(text);
        userLabel.repaint();
        if (session.getCurrentUser().getBucket().size() == 0) {
            buySubmit.setEnabled(false);
        } else {
            buySubmit.setEnabled(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!session.isGuest()) {
            int row = itemsTable.rowAtPoint(e.getPoint());
            Item item = new Item(
                    (String) itemsTable.getValueAt(row, 0),
                    (double) itemsTable.getValueAt(row, 1),
                    (int) itemsTable.getValueAt(row, 2),
                    session.getCurrentCategory()
            );
            Object[] options = {"В корзину", "К списку товаров"};
            int isOk = JOptionPane.showOptionDialog(MainWindow.this, item, "Информация о товаре",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
            if (isOk == 0) {
                session.getCurrentUser().getBucket().addItem(item);
                repaintHeader();
                userLabel.repaint();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
