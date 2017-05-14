package lesson7.task3.gui;

import lesson7.task3.controller.NewUserController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibraryChoiceFrame extends JFrame {
    private JPanel rootPanel;
    private JPanel controlPanel;
    private JPanel infoPanel;

    private JLabel label;
    private JTextField text;
    private ArrayList<JButton> btns;

    private JTextArea textArea;

    private NewUserController userController;

    public LibraryChoiceFrame() throws HeadlessException {
        setTitle("Library form");
        setSize(650, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userController = new NewUserController(this);

        btns = new ArrayList<>();
        createLabel();
        createTextField();
        createButtons();
        rootPanel = new JPanel(new BorderLayout());
        controlPanel = new JPanel(new GridLayout(1, 4));
        controlPanel.setBorder(new EmptyBorder(5, 5,5, 5));
        controlPanel.add(label);
        controlPanel.add(text);
        for (JButton btn : btns) {
            controlPanel.add(btn);
        }
        infoPanel = new JPanel();
        createInfoArea();
        infoPanel.add(textArea);
        rootPanel.add(controlPanel, BorderLayout.NORTH);
        rootPanel.add(infoPanel, BorderLayout.CENTER);
        add(rootPanel);
        setVisible(true);
    }

    private void createInfoArea() {
        textArea = new JTextArea();
        textArea.setColumns(55);
        textArea.setRows(25);
        textArea.setEditable(false);
    }

    private void createLabel() {
        label = new JLabel("№ читательского билета:");
    }

    private void createTextField() {
        text = new JTextField(20);
    }

    private void createButtons() {
        btns.add(new JButton("Найти"));
        btns.add(new JButton("Новый читатель"));
        btns.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewUserFrame(userController);
            }
        });
    }

    public void setNewInfo(String info) {
        textArea.append(info);
    }
}
