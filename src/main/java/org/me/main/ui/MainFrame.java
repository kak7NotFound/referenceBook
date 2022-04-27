/*
 * Created by JFormDesigner on Tue Apr 26 14:23:18 MSK 2022
 */

package org.me.main.ui;

import org.me.main.util.FileUtility;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * @author Allan
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
        setData();
    }

    public void setData() {
        textPane1.setContentType("text/html");
        textPane1.setText(new FileUtility().readFile("articles/Глава 1. Введение в Java/1. Первая программа на Java/Java.html"));

        DefaultMutableTreeNode style = new DefaultMutableTreeNode("Style");
        DefaultMutableTreeNode color1 = new DefaultMutableTreeNode("color1");
        DefaultMutableTreeNode red = new DefaultMutableTreeNode("red");

        style.add(color1);
        color1.add(red);

        try {
            ClassLoader classLoader = getClass().getClassLoader();
//            classLoader.getResources();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DefaultMutableTreeNode getTreeModel() {
        DefaultMutableTreeNode style = new DefaultMutableTreeNode("Style");
        DefaultMutableTreeNode color = new DefaultMutableTreeNode("color");
        DefaultMutableTreeNode font = new DefaultMutableTreeNode("font");
        style.add(color);
        style.add(font);
        DefaultMutableTreeNode green = new DefaultMutableTreeNode("green");
        color.add(green);
        return style;
    }

    private void tree1ValueChanged(TreeSelectionEvent e) {
        new JTree();
        System.out.println(tree1.getLastSelectedPathComponent().toString());
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Allan
        scrollPane1 = new JScrollPane();
        tree1 = new JTree(MainFrame.getTreeModel());
        scrollPane3 = new JScrollPane();
        textPane1 = new JTextPane();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- tree1 ----
            tree1.addTreeSelectionListener(e -> tree1ValueChanged(e));
            scrollPane1.setViewportView(tree1);
        }

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(textPane1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                        .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
                    .addContainerGap(3, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Allan
    private JScrollPane scrollPane1;
    private JTree tree1;
    private JScrollPane scrollPane3;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
