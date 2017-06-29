package lesson16.task2.gui;

import lesson16.task2.controller.UserController;
import lesson16.task2.exception.WrongLoginException;
import lesson16.task2.exception.WrongPasswordException;
import lesson16.task2.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegLogin extends JDialog implements ActionListener {
    private static RegLogin loginDlg;
    private JButton submit;
    private JPanel rootPanel;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JLabel confirmLabel;
    private static JTextField login;
    private static JTextField password;
    private static JTextField confirm;

    private MainWindow parent;

    private RegLogin() {
    }

    private RegLogin(MainWindow parent) {
        this.parent = parent;
        createLabels();
        createTextFields();
        createButton();
        createPanel();
        add(rootPanel, BorderLayout.CENTER);
        add(submit, BorderLayout.SOUTH);
        submit.addActionListener(this);
        createFrame();
    }

    public static RegLogin instance(MainWindow parent) {
        if (loginDlg == null) {
            loginDlg = new RegLogin(parent);
        }
        login.setText("");
        password.setText("");
        confirm.setText("");
        return loginDlg;
    }

    private void createFrame() {
        setTitle("Авторизация");
        setSize(300, 120);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }

    private void createLabels() {
        loginLabel = new JLabel("  Логин:");
        passwordLabel = new JLabel("  Пароль:");
        confirmLabel = new JLabel("  Подтвердите пароль:");
    }

    private void createTextFields() {
        login = new JTextField(15);
        password = new JPasswordField(15);
        confirm = new JPasswordField(15);
        textFieldsAlignment(CENTER_ALIGNMENT, login, password, confirm);
    }

    private void textFieldsAlignment(final float alignment, JTextField... fields) {
        for (JTextField field : fields) {
            field.setHorizontalAlignment((int) alignment);
        }
    }

    private void createButton() {
        submit = new JButton("submit");
    }

    private void createPanel() {
        rootPanel = new JPanel(new GridLayout(3, 1));
        rootPanel.add(loginLabel);
        rootPanel.add(login);
        rootPanel.add(passwordLabel);
        rootPanel.add(password);
        rootPanel.add(confirmLabel);
        rootPanel.add(confirm);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            checkLogInInfo(login.getText(), password.getText(), confirm.getText(), "[\\w]{1,20}");
            if (UserController.create(new User(login.getText(), password.getText()))) {
                parent.getSession().newUser(login.getText(), password.getText());
                parent.repaintHeader();
                parent.getBtnPanel();
                parent.getHeaderPanel().repaint();
                parent.getHeaderPanel().revalidate();
                login.setText("");
                password.setText("");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Пользователь с таким именем уже существует!",
                        "Ошибка регистрации", JOptionPane.ERROR_MESSAGE);
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "UserException", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean checkLogInInfo(String login, String password, String confirm, String regex)
            throws WrongLoginException, WrongPasswordException {
        if (!login.matches(regex)) {
            throw new WrongLoginException("Неверный логин!\nЛогин может содержать только латинские символы,\n" +
                    "цифры, знаки подчеркивания и быть не длиннее\n20 символов");
        } else if (!password.matches(regex) || !confirm.matches(regex) || !password.equals(confirm)) {
            throw new WrongPasswordException("Неверный пароль!\nПароль может содержать только латинские символы,\n" +
                    "цифры, знаки подчеркивания и быть не длиннее\n20 символов");
        }
        return true;
    }
}