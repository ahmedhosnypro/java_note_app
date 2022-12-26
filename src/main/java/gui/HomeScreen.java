/*
 * Created by JFormDesigner on Mon Dec 26 14:29:57 EET 2022
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import com.intellij.uiDesigner.core.*;
import note.ApplicationRunner;

/**
 * @author AHMEDHOSNY
 */
public class HomeScreen extends JPanel {
    public HomeScreen() {
        initComponents();
    }

    private void login(ActionEvent e) {
        ApplicationRunner.getMainFrame().setMainContainer(new LoginScreen());
    }

    private void signupScreen(ActionEvent e) {
        ApplicationRunner.getMainFrame().setMainContainer(new RegisterScreen());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("values.mainFrameStrings");
        titleLabel = new JLabel();
        loginScreenButton = new JButton();
        signupScreenButton = new JButton();

        //======== this ========
        setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));

        //---- titleLabel ----
        titleLabel.setText(bundle.getString("LoginScreen.titleLabel.text"));
        titleLabel.setIconTextGap(10);
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setForeground(new Color(0xff3333));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Roboto Black", Font.BOLD, 100));
        add(titleLabel, new GridConstraints(0, 0, 1, 2,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- loginScreenButton ----
        loginScreenButton.setText(bundle.getString("LoginScreen.loginScreenButton.text"));
        loginScreenButton.addActionListener(e -> login(e));
        add(loginScreenButton, new GridConstraints(1, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- signupScreenButton ----
        signupScreenButton.setText(bundle.getString("LoginScreen.signupScreenButton.text"));
        signupScreenButton.addActionListener(e -> signupScreen(e));
        add(signupScreenButton, new GridConstraints(1, 1, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel titleLabel;
    private JButton loginScreenButton;
    private JButton signupScreenButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
