/*
 * Created by JFormDesigner on Mon Dec 26 14:10:51 EET 2022
 */

package gui;

import java.awt.*;
import javax.swing.*;

import com.intellij.uiDesigner.core.*;

/**
 * @author AHMEDHOSNY
 */
public class MainFrame extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        addMainContainer(contentPane);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addMainContainer(Container contentPane) {
        contentPane.add(mainContainer, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                new Dimension(600, 600), new Dimension(600, 600), null));
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private final Container contentPane = getContentPane();
    private JPanel mainContainer = new HomeScreen();

    void setMainContainer(JPanel container) {
        contentPane.remove(mainContainer);
        mainContainer = container;
        addMainContainer(contentPane);
        pack();
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}
