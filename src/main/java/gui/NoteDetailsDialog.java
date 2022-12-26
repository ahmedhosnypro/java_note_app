/*
 * Created by JFormDesigner on Mon Dec 26 21:55:32 EET 2022
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

import authentication.user.UsersDataBase;
import com.intellij.uiDesigner.core.*;
import note.ApplicationRunner;
import note.Note;

/**
 * @author AHMEDHOSNY
 */
public class NoteDetailsDialog extends JDialog {
    private NoteScreen noteScreen;
    private NoteCard noteCard;

    public NoteDetailsDialog(Window owner, NoteScreen noteScreen, NoteCard noteCard) {
        super(owner);
        this.noteScreen = noteScreen;
        this.noteCard = noteCard;
        initComponents();
        noteTextArea.setText(noteCard.getNote().getContent());
        pack();
    }

    private void updateNote(ActionEvent e) {
        noteCard.setText(noteTextArea.getText());
        UsersDataBase.updateNote(noteCard.getNote().getId(), noteTextArea.getText());
        noteScreen.updateNoteGrid();
        dispose();
    }

    private void deleteNote(ActionEvent e) {
        UsersDataBase.deleteNoteById(noteCard.getNote().getId());
        dispose();
        noteScreen.updateNoteGrid();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("values.mainFrameStrings");
        dialogPane = new JPanel();
        buttonBar = new JPanel();
        deleteNoteButton = new JButton();
        cancelButton = new JButton();
        updateNoteButton = new JButton();
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
                ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
                ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};

                //---- deleteNoteButton ----
                deleteNoteButton.setText(bundle.getString("NoteDetailsDialog.deleteNoteButton.text"));
                deleteNoteButton.setMaximumSize(new Dimension(50, 30));
                deleteNoteButton.setMinimumSize(new Dimension(50, 30));
                deleteNoteButton.setPreferredSize(new Dimension(50, 30));
                deleteNoteButton.addActionListener(e -> deleteNote(e));
                buttonBar.add(deleteNoteButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText(bundle.getString("NoteDetailsDialog.cancelButton.text"));
                buttonBar.add(cancelButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- updateNoteButton ----
                updateNoteButton.setText(bundle.getString("NoteDetailsDialog.updateNoteButton.text"));
                updateNoteButton.addActionListener(e -> updateNote(e));
                buttonBar.add(updateNoteButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //======== scrollPane1 ========
            {
                scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                //---- noteTextArea ----
                noteTextArea.setMinimumSize(new Dimension(300, 200));
                noteTextArea.setPreferredSize(new Dimension(300, 200));
                scrollPane1.setViewportView(noteTextArea);
            }
            dialogPane.add(scrollPane1, BorderLayout.NORTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel buttonBar;
    private JButton deleteNoteButton;
    private JButton cancelButton;
    private JButton updateNoteButton;
    private JScrollPane scrollPane1;
    private JTextArea noteTextArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
