/*
 * Created by JFormDesigner on Tue Apr 26 14:23:18 MSK 2022
 */

package org.me.main.ui;

import org.me.main.util.FileUtility;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author Allan
 */
public class MainFrame extends JFrame {

    static FileUtility fu = new FileUtility();
    static HashMap filesData = new HashMap<String, String>();


    public static DefaultMutableTreeNode getTreeModel() {


        ArrayList<String> fields = new ArrayList<String>();

        DefaultMutableTreeNode mtn = new DefaultMutableTreeNode("Справочник Java");

        for (var s : fu.getResourcesFromJar()) {

            var splitString = s.split("/");
            DefaultMutableTreeNode sm = new DefaultMutableTreeNode(splitString[1]);

            filesData.put(splitString[2], s);

            for (var ss : fu.getResourcesFromJar("articles/"+splitString[1])) {
                var a = ss.split("/");
                sm.add(new DefaultMutableTreeNode(a[a.length-1]));
            }
            fields.add("");
            if (!Objects.equals(fields.get(0), splitString[1])) {
                fields.clear();
                fields.add(splitString[1]);
                mtn.add(sm);
            }
        }
        return mtn;
    }

    public MainFrame() {
        initComponents();
        setData();
    }

    public void setData() {
        textPane1.setContentType("text/html");
        textPane1.setText(fu.readFile("articles/Глава 1. Введение в Java/1. Язык программирования Java.html"));
    }

    private void tree1ValueChanged(TreeSelectionEvent e) {
        System.out.println(tree1.getLastSelectedPathComponent().toString());
        try {
            textPane1.setText(fu.readFile((String) filesData.get(tree1.getLastSelectedPathComponent().toString())));
        }catch (NullPointerException exc){}
        textPane1.select(0,2);

    }

    private void button1Event(ActionEvent e) {
        new TestingForm().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Allan
        scrollPane1 = new JScrollPane();
        tree1 = new JTree(MainFrame.getTreeModel());
        scrollPane3 = new JScrollPane();
        textPane1 = new JTextPane();
        button1 = new JButton();

        //======== this ========
        setTitle("\u0421\u043f\u0440\u0430\u0432\u043e\u0447\u043d\u0438\u043a \u043f\u043e Java | \u0414\u043e\u043b\u0438\u043d\u0441\u043a\u0438\u0439 \u0420\u043e\u0434\u0438\u043e\u043d 523\u043f\u0438-4");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- tree1 ----
            tree1.setCellRenderer(null);
            tree1.addTreeSelectionListener(e -> tree1ValueChanged(e));
            scrollPane1.setViewportView(tree1);
        }

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(textPane1);
        }

        //---- button1 ----
        button1.setText("\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u0442\u0435\u0441\u0442");
        button1.addActionListener(e -> button1Event(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                    .addGap(12, 12, 12)
                    .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(3, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Allan
    private JScrollPane scrollPane1;
    public JTree tree1;
    public JScrollPane scrollPane3;
    private JTextPane textPane1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
