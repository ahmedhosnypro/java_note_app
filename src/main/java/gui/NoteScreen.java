/*
 * Created by JFormDesigner on Mon Dec 26 14:37:57 EET 2022
 */

package gui;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.intellij.uiDesigner.core.*;

/**
 * @author AHMEDHOSNY
 */
public class NoteScreen extends JPanel {
    public NoteScreen() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("values.mainFrameStrings");
        mainNotesPanel = new JPanel();
        searchField = new JTextField();
        notesScrollPane = new JScrollPane();
        notesContainer = new JPanel();
        addNoteButton = new JButton();

        //======== this ========
        setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), 5, -1));

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

            //======== notesScrollPane ========
            {

                //======== notesContainer ========
                {
                    notesContainer.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
                }
                notesScrollPane.setViewportView(notesContainer);
            }
            mainNotesPanel.add(notesScrollPane, new GridConstraints(1, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                new Dimension(600, 600), new Dimension(600, 600), null));
        }
        add(mainNotesPanel, new GridConstraints(0, 0, 1, 2,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
            null, null, null));

        //---- addNoteButton ----
        addNoteButton.setIcon(new ImageIcon(getClass().getResource("/icons/add.png")));
        addNoteButton.setSelectedIcon(null);
        add(addNoteButton, new GridConstraints(1, 1, 1, 1,
            GridConstraints.ANCHOR_SOUTHEAST, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_FIXED,
            GridConstraints.SIZEPOLICY_FIXED,
            new Dimension(24, 24), new Dimension(24, 24), new Dimension(24, 24)));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel mainNotesPanel;
    private JTextField searchField;
    private JScrollPane notesScrollPane;
    private JPanel notesContainer;
    private JButton addNoteButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
