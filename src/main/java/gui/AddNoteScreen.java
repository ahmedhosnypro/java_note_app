/*
 * Created by JFormDesigner on Mon Dec 26 19:37:01 EET 2022
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

import authentication.user.UsersDataBase;
import com.intellij.uiDesigner.core.*;

/**
 * @author AHMEDHOSNY
 */
public class AddNoteScreen extends JDialog {
    private String username;

    public AddNoteScreen(Window owner, String username) {
        super(owner);
        this.username = username;
        initComponents();
    }

    private void addNote(ActionEvent e) {
        String note = noteTextArea.getText();
        if (!note.isEmpty() && !note.isBlank()) {
            UsersDataBase.addNoteToUser(username, note);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("values.mainFrameStrings");
        dialogPane = new JPanel();
        buttonBar = new JPanel();
        cancelButton = new JButton();
        addNoteButton = new JButton();
        scrollPane1 = new JScrollPane();
        noteTextArea = new JTextArea();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- cancelButton ----
                cancelButton.setText(bundle.getString("AddNoteScreen.cancelButton.text"));
                buttonBar.add(cancelButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- addNoteButton ----
                addNoteButton.setText(bundle.getString("AddNoteScreen.addNoteButton.text"));
                addNoteButton.addActionListener(e -> addNote(e));
                buttonBar.add(addNoteButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(noteTextArea);
            }
            dialogPane.add(scrollPane1, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel buttonBar;
    private JButton cancelButton;
    private JButton addNoteButton;
    private JScrollPane scrollPane1;
    private JTextArea noteTextArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
