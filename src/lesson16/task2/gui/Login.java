package lesson16.task2.gui;

import lesson16.task2.controller.BucketController;
import lesson16.task2.controller.UserController;
import lesson16.task2.exception.WrongLoginException;
import lesson16.task2.exception.WrongPasswordException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JDialog implements ActionListener {
    private static Login loginDlg;
    private JButton submit;
    private JPanel rootPanel;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private static JTextField login;
    private static JTextField password;

    private MainWindow parent;

    private Login() {
    }

    private Login(MainWindow parent) {
        this.parent = parent;
        createLabels();
        createTextFields();
        createButton();
        add(createPanel(), BorderLayout.CENTER);
        add(submit, BorderLayout.SOUTH);
        submit.addActionListener(this);
        createFrame();
    }

    public static Login instance(MainWindow parent) {
        if (loginDlg == null) {
            loginDlg = new Login(parent);
        }
        login.setText("");
        password.setText("");
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
    }

    private void createTextFields() {
        login = new JTextField(15);
        password = new JPasswordField(15);
        textFieldsAlignment(CENTER_ALIGNMENT, login, password);
    }

    private void textFieldsAlignment(final float alignment, JTextField... fields) {
        for (JTextField field : fields) {
            field.setHorizontalAlignment((int) alignment);
        }
    }

    private void createButton() {
        submit = new JButton("submit");
    }

    private JPanel createPanel() {
        rootPanel = new JPanel(new GridLayout(2, 1));
        rootPanel.add(loginLabel);
        rootPanel.add(login);
        rootPanel.add(passwordLabel);
        rootPanel.add(password);
        return rootPanel;
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            checkLogInInfo(login.getText(), password.getText(), "[\\w]{1,20}");
            if (UserController.check(login.getText(), password.getText())) {
                parent.getSession().newUser(login.getText(), password.getText());
                BucketController.deserializeBucket(parent.getSession().getCurrentUser());
                parent.repaintHeader();
                parent.getBtnPanel();
                parent.getHeaderPanel().repaint();
                parent.getHeaderPanel().revalidate();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Неверный логин или пароль!",
                        "Ошибка авторизации", JOptionPane.ERROR_MESSAGE);
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "UserException", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean checkLogInInfo(String login, String password, String regex)
            throws WrongLoginException, WrongPasswordException {
        if (!login.matches(regex)) {
            throw new WrongLoginException("Неверный логин!\nЛогин может содержать только латинские символы,\n" +
                    "цифры, знаки подчеркивания и быть не длиннее\n20 символов");
        } else if (!password.matches(regex)) {
            throw new WrongPasswordException("Неверный пароль!\nПароль может содержать только латинские символы,\n" +
                    "цифры, знаки подчеркивания и быть не длиннее\n20 символов");
        }
        return true;
    }
}