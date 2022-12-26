/*
 * Created by JFormDesigner on Mon Dec 26 14:37:57 EET 2022
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
public class NoteScreen extends JPanel {
    private String username;

    public NoteScreen(String username) {
        this.username = username;
        initComponents();
    }

    private void addNote(ActionEvent e) {
        new AddNoteScreen(null, username).setVisible(true);
    }

    private void logout(ActionEvent e) {
        username = null;
        ApplicationRunner.getMainFrame().setMainContainer(new HomeScreen());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("values.mainFrameStrings");
        mainNotesPanel = new JPanel();
        searchField = new JTextField();
        notesContainer = new NoteGrid();
        barPanel = new JPanel();
        logoutButton = new JButton();
        addNoteButton = new JButton();

        //======== this ========
        setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), 5, -1));

        //======== mainNotesPanel ========
        {
            mainNotesPanel.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), 5, -1));

            //---- searchField ----
            searchField.setText(bundle.getString("NoteScreen.searchField.text"));
            searchField.setBorder(UIManager.getBorder("Button.border"));
            mainNotesPanel.add(searchField, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_SOUTHEAST, GridConstraints.FILL_HORIZONTAL,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    new Dimension(200, 50), new Dimension(50, 50), null));
            mainNotesPanel.add(notesContainer, new GridConstraints(1, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    new Dimension(400, 400), new Dimension(400, 400), null));
        }
        add(mainNotesPanel, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                null, null, null));

        //======== barPanel ========
        {
            barPanel.setLayout(new BorderLayout());

            //---- logoutButton ----
            logoutButton.setText(bundle.getString("NoteScreen.logoutButton.text"));
            logoutButton.addActionListener(e -> logout(e));
            barPanel.add(logoutButton, BorderLayout.WEST);

            //---- addNoteButton ----
            addNoteButton.setIcon(new ImageIcon(getClass().getResource("/icons/add.png")));
            addNoteButton.setSelectedIcon(null);
            addNoteButton.setMaximumSize(new Dimension(24, 24));
            addNoteButton.setMinimumSize(new Dimension(24, 24));
            addNoteButton.setPreferredSize(new Dimension(24, 24));
            addNoteButton.addActionListener(e -> addNote(e));
            barPanel.add(addNoteButton, BorderLayout.EAST);
        }
        add(barPanel, new GridConstraints(1, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null, 0, true));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel mainNotesPanel;
    private JTextField searchField;
    private NoteGrid notesContainer;
    private JPanel barPanel;
    private JButton logoutButton;
    private JButton addNoteButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
