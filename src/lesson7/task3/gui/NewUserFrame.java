package lesson7.task3.gui;

import lesson7.task3.controller.NewUserController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

public class NewUserFrame extends JFrame{
    private JPanel rootPanel;
    private JPanel labelsPanel;
    private JPanel fieldsPanel;

    private ArrayList<JLabel> labels;
    private ArrayList<JTextField> fields;

    private JButton btn;

    private NewUserController userController;

    public NewUserFrame(NewUserController userController) throws HeadlessException {
        this.userController = userController;
        setTitle("Добавить нового читателя");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createPanels();
        setVisible(true);
    }

    private void createPanels() {
        rootPanel = new JPanel(new BorderLayout());
        labelsPanel = new JPanel(new GridLayout(7, 1));
        labelsPanel.setBorder(new EmptyBorder(5, 10,5, 10));
        createLabels();
        for (JLabel label : labels) {
            labelsPanel.add(label);
        }
        fieldsPanel = new JPanel(new GridLayout(7, 1));
        createTextFields();
        for (JTextField field : fields) {
            fieldsPanel.add(field);
        }
        createButton();
        rootPanel.add(labelsPanel, BorderLayout.WEST);
        rootPanel.add(fieldsPanel, BorderLayout.CENTER);
        rootPanel.add(btn, BorderLayout.SOUTH);
        add(rootPanel);
    }

    private void createLabels() {
        labels = new ArrayList<>();
        labels.add(new JLabel("Фамилия:       "));
        labels.add(new JLabel("Имя:           "));
        labels.add(new JLabel("Отчество:      "));
        labels.add(new JLabel("Дата рождения: "));
        labels.add(new JLabel("Факультет:     "));
        labels.add(new JLabel("Телефон:       "));
        labels.add(new JLabel("Номер ч/б:     "));
        for (JLabel label : labels) {
            label.setFont(new Font("Serif", Font.BOLD, 14));
        }
    }

    private void createTextFields() {
        fields = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            JTextField textField = null;
            try {
                textField = getTextField(i);
            } catch (ParseException e) {
            }
            textField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
            textField.setFont(new Font("Serif", Font.BOLD, 20));
            fields.add(textField);
        }
    }

    private void createButton() {
        btn = new JButton("Добавить читателя в базу");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String surName = fields.get(0).getText();
                String name = fields.get(1).getText();
                String fatherName = fields.get(2).getText();
                String birthDay = fields.get(3).getText();
                String faculty = fields.get(4).getText();
                String phoneNumber = fields.get(5).getText();
                String id = fields.get(6).getText();
                userController.addUserToDB(surName, name, fatherName, birthDay);
                userController.setUserData(id, faculty, phoneNumber);
                userController.printInfo();
                setVisible(false);
            }
        });
    }

    private JTextField getTextField(int fieldNumber) throws ParseException {
        MaskFormatter formatter;
        JTextField textField = new JTextField();
        switch (fieldNumber) {
            case 3:
                formatter = new MaskFormatter("##/##/####");
                formatter.setPlaceholderCharacter('_');
                textField = new JFormattedTextField(formatter);
                break;
            case 5:
                formatter = new MaskFormatter("+38(###)###-##-##");
                formatter.setPlaceholderCharacter('_');
                textField = new JFormattedTextField(formatter);
                break;
        }
        return textField;
    }
}
