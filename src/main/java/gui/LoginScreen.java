/*
 * Created by JFormDesigner on Mon Dec 26 14:33:43 EET 2022
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

import authentication.user.UsersDataBase;
import com.intellij.uiDesigner.core.*;
import note.ApplicationRunner;

/**
 * @author AHMEDHOSNY
 */
public class LoginScreen extends JPanel {
    public LoginScreen() {
        initComponents();
    }

    private void signupScreen(ActionEvent e) {
        ApplicationRunner.getMainFrame().setMainContainer(new RegisterScreen());
    }

    private void login(ActionEvent e) {
        String username = userNameTextField.getText();
        String password = Arrays.toString(passwordField.getPassword());
        if (username.isEmpty() || username.isBlank() || password.isEmpty() || password.isBlank()) {
            errorLabel.setText("Please fill all fields");
        } else {
            if (UsersDataBase.isUserExist(username)) {
                int userId = UsersDataBase.getUserId(username);
                if (UsersDataBase.isPasswordCorrect(username, password)) {
                    ApplicationRunner.getMainFrame().setMainContainer(new NoteScreen(userId));
                } else {
                    errorLabel.setText("Incorrect password");
                }
            } else {
                errorLabel.setText("User not found");
            }
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("values.mainFrameStrings");
        panel1 = new JPanel();
        userNameLabel = new JLabel();
        userNameTextField = new JTextField();
        passwordLabel = new JLabel();
        passwordField = new JPasswordField();
        errorLabel = new JLabel();
        loginButton = new JButton();
        separator1 = new JSeparator();
        signupScreenButton = new JButton();

        //======== this ========
        setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));

            //---- userNameLabel ----
            userNameLabel.setText(bundle.getString("LoginScreen.userNameLabel.text"));
            userNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(userNameLabel, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_NORTHEAST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //---- userNameTextField ----
            userNameTextField.setBorder(new MetalBorders.ButtonBorder());
            panel1.add(userNameTextField, new GridConstraints(0, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                new Dimension(200, 50), new Dimension(200, 50), null));

            //---- passwordLabel ----
            passwordLabel.setText(bundle.getString("LoginScreen.passwordLabel.text"));
            passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(passwordLabel, new GridConstraints(1, 0, 1, 1,
                GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(passwordField, new GridConstraints(1, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                new Dimension(200, 50), new Dimension(200, 50), null));

            //---- errorLabel ----
            errorLabel.setBackground(Color.red);
            errorLabel.setForeground(new Color(0x00cc00));
            panel1.add(errorLabel, new GridConstraints(2, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                new Dimension(200, 50), new Dimension(200, 50), null));

            //---- loginButton ----
            loginButton.setText(bundle.getString("LoginScreen.loginButton.text"));
            loginButton.addActionListener(e -> {
			login(e);
			login(e);
		});
            panel1.add(loginButton, new GridConstraints(3, 1, 1, 1,
                GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        add(panel1, new GridConstraints(0, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));
        add(separator1, new GridConstraints(1, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- signupScreenButton ----
        signupScreenButton.setText(bundle.getString("LoginScreen.signupScreenButton.text"));
        signupScreenButton.addActionListener(e -> signupScreen(e));
        add(signupScreenButton, new GridConstraints(2, 0, 1, 1,
            GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel userNameLabel;
    private JTextField userNameTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel errorLabel;
    private JButton loginButton;
    private JSeparator separator1;
    private JButton signupScreenButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
