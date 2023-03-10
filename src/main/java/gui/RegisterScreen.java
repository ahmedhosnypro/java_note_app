/*
 * Created by JFormDesigner on Mon Dec 26 14:35:42 EET 2022
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import authentication.user.UsersDataBase;
import com.intellij.uiDesigner.core.*;
import note.ApplicationRunner;

import static authentication.user.UsernameChecker.isValidUserName;
import static authentication.user.UsersDataBase.isUserExist;
import static java.lang.Thread.sleep;

/**
 * @author AHMEDHOSNY
 */
public class RegisterScreen extends JPanel {
    public RegisterScreen() {
        initComponents();
    }

    private void loginScreen(ActionEvent e) {
        ApplicationRunner.getMainFrame().setMainContainer(new LoginScreen());
    }

    private void singup(ActionEvent e) {
        String username = userNameTextField.getText();
        String password = Arrays.toString(passwordField.getPassword());
        String password2 = Arrays.toString(repasswordField.getPassword());
        if (username.isEmpty() || username.isBlank() || password.isEmpty() || password.isBlank() || password2.isEmpty() || password2.isBlank()) {
            errorLabel.setText("Please fill all fields");
        } else if (!password.equals(password2)) {
            passwordErrorLabel.setText("Passwords don't match");
        } else if (!isValidUserName(username)) {
            userNameErrorLabel.setText("Invalid username");
        } else if (isUserExist(username)) {
            userNameErrorLabel.setText("Username already exist");
        } else {
            UsersDataBase.addUser(username, password);
            JOptionPane.showMessageDialog(null, "Account created successfully");
            ApplicationRunner.getMainFrame().setMainContainer(new LoginScreen());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("values.mainFrameStrings");
        signupPanel = new JPanel();
        label2 = new JLabel();
        userNameTextField = new JTextField();
        userNameErrorLabel = new JLabel();
        passwordlabel = new JLabel();
        passwordField = new JPasswordField();
        rePasswordLabel = new JLabel();
        repasswordField = new JPasswordField();
        passwordErrorLabel = new JLabel();
        errorLabel = new JLabel();
        singupButton = new JButton();
        separator1 = new JSeparator();
        loginScreenButton = new JButton();

        //======== this ========
        setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));

        //======== signupPanel ========
        {
            signupPanel.setLayout(new GridLayoutManager(5, 3, new Insets(0, 0, 0, 0), -1, -1, false, true));

            //---- label2 ----
            label2.setText(bundle.getString("SingupScreen.label2.text"));
            label2.setHorizontalAlignment(SwingConstants.RIGHT);
            signupPanel.add(label2, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_NORTHEAST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            signupPanel.add(userNameTextField, new GridConstraints(0, 1, 1, 1,
                GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                new Dimension(200, 36), null, null));

            //---- userNameErrorLabel ----
            userNameErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
            userNameErrorLabel.setForeground(new Color(0xff0033));
            signupPanel.add(userNameErrorLabel, new GridConstraints(0, 2, 1, 1,
                GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //---- passwordlabel ----
            passwordlabel.setText(bundle.getString("SingupScreen.passwordlabel.text"));
            passwordlabel.setHorizontalAlignment(SwingConstants.RIGHT);
            signupPanel.add(passwordlabel, new GridConstraints(1, 0, 1, 1,
                GridConstraints.ANCHOR_NORTHEAST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            signupPanel.add(passwordField, new GridConstraints(1, 1, 1, 1,
                GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                new Dimension(200, 36), new Dimension(200, 36), null));

            //---- rePasswordLabel ----
            rePasswordLabel.setText(bundle.getString("SingupScreen.rePasswordLabel.text"));
            rePasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            signupPanel.add(rePasswordLabel, new GridConstraints(2, 0, 1, 1,
                GridConstraints.ANCHOR_NORTHEAST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            signupPanel.add(repasswordField, new GridConstraints(2, 1, 1, 1,
                GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                new Dimension(200, 36), new Dimension(200, 36), null));

            //---- passwordErrorLabel ----
            passwordErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            passwordErrorLabel.setForeground(new Color(0xff0033));
            signupPanel.add(passwordErrorLabel, new GridConstraints(2, 2, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                new Dimension(120, 50), new Dimension(120, 50), null, 0, true));

            //---- errorLabel ----
            errorLabel.setForeground(new Color(0xff0033));
            signupPanel.add(errorLabel, new GridConstraints(3, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_FIXED,
                null, null, null));

            //---- singupButton ----
            singupButton.setText(bundle.getString("SingupScreen.singupButton.text"));
            singupButton.addActionListener(e -> singup(e));
            signupPanel.add(singupButton, new GridConstraints(4, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        add(signupPanel, new GridConstraints(0, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));
        add(separator1, new GridConstraints(2, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED,
            null, null, null));

        //---- loginScreenButton ----
        loginScreenButton.setText(bundle.getString("SingupScreen.loginScreenButton.text"));
        loginScreenButton.addActionListener(e -> loginScreen(e));
        add(loginScreenButton, new GridConstraints(3, 0, 1, 1,
            GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel signupPanel;
    private JLabel label2;
    private JTextField userNameTextField;
    private JLabel userNameErrorLabel;
    private JLabel passwordlabel;
    private JPasswordField passwordField;
    private JLabel rePasswordLabel;
    private JPasswordField repasswordField;
    private JLabel passwordErrorLabel;
    private JLabel errorLabel;
    private JButton singupButton;
    private JSeparator separator1;
    private JButton loginScreenButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
