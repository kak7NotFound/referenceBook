/*
 * Created by JFormDesigner on Tue Apr 26 14:23:18 MSK 2022
 */

package org.me.main.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author Allan
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
        setData();
    }

    private void setData() {
        textPane1.setContentType("text/html");
        textPane1.setText("<html>This text box has <b>bold text</b> in it!</html>");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Allan
        scrollPane1 = new JScrollPane();
        tree1 = new JTree();
        scrollPane3 = new JScrollPane();
        textPane1 = new JTextPane();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
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
