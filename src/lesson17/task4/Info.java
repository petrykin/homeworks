package lesson17.task4;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;

public class Info extends JFrame implements ActionListener {
    private JTextField text;
    JTextArea infoArea;
    JPanel leftPanel;
    JPanel rightPanel;

    public Info() {
        super("LESSON 17 - TASK 4");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel(" Directory path: ");

        text = new JTextField();
        text.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        text.setText("src");

        JButton btn = new JButton("Directory info");
        btn.addActionListener(this);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(label, BorderLayout.WEST);
        topPanel.add(text, BorderLayout.CENTER);
        topPanel.add(btn, BorderLayout.EAST);

        leftPanel = new JPanel(new BorderLayout());
        rightPanel = new JPanel(new GridLayout(10, 1));

        infoArea = new JTextArea();
        infoArea.setSize(rightPanel.getSize());
        infoArea.setEditable(false);

        rightPanel.add(infoArea);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.add(leftPanel);
        bottomPanel.add(new JScrollPane(infoArea));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);

        add(mainPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String path = text.getText();
        File pathFile = new File(path);
        leftPanel.removeAll();
        JTree dirTree = new JTree(directoryTree(pathFile, true));
        dirTree.addTreeSelectionListener(e1 -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) dirTree.getLastSelectedPathComponent();
            if (selectedNode != null) {
                StringBuilder itemPath = new StringBuilder();
                for (TreeNode treeNode : selectedNode.getPath()) {
                    itemPath.append(treeNode.toString());
                    itemPath.append("\\");
                }
                File itemFile = new File(itemPath.toString());
                info(itemFile);
            }
        });
        leftPanel.add(new JScrollPane(dirTree), BorderLayout.CENTER);
        leftPanel.repaint();
        leftPanel.revalidate();
    }

    public DefaultMutableTreeNode directoryTree(File file, boolean isRoot) {
        if (!file.exists()) return new DefaultMutableTreeNode("directory doesn't exist");
        String path = file.getName().equals("") ? file.getPath() : file.getName();
        if (isRoot) {
            path = file.getPath();
        }
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(path);
        File[] list = file.listFiles();
        if (list != null) {
            for (File subFile : list) {
                if (subFile.isDirectory()) {
                    root.add(directoryTree(subFile, false));
                } else {
                    root.add(new DefaultMutableTreeNode(subFile.getName()));
                }
            }
        }
        return root;
    }

    public void info(File file) {
        infoArea.setText(
                (file.isDirectory() ? " Directory " : " File ") + "name:  [" + file.getName() + "]\n" +
                        " path: [" + file.getPath() + "]\n" +
                        " abs path: [" + file.getAbsolutePath() + "]\n" +
                        " parent: [" + file.getParent() + "]\n" +
                        " existence: " + (file.exists() ? "exists" : "does not exist") + "\n" +
                        " writeability: " + (file.canWrite() ? "is writeable" : "is not writeable") + "\n" +
                        " readability: " + (file.canRead() ? "is readable" : "is not readable") + "\n" +
                        " last modified:  " + new SimpleDateFormat("dd/MM/yy hh:mm").format(file.lastModified()) + "\n" +
                        " size:  " + file.length() + " Bytes"
        );
    }

    public static void main(String[] args) {
        new Info();
    }
}
