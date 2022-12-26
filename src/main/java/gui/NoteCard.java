package gui;

import note.Note;

import javax.swing.*;
import java.awt.*;

public class NoteCard extends JButton {
    private final NoteScreen noteScreen;
    private final Note note;

    public NoteCard(NoteScreen noteScreen, Note note) {
        super();
        this.noteScreen = noteScreen;
        this.note = note;
        setHorizontalTextPosition(SwingConstants.LEFT);
        setVerticalTextPosition(SwingConstants.TOP);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setText(note.getContent());
        setBorderPainted(false);

        addActionListener(e -> {
            new NoteDetailsDialog(null, noteScreen, this).setVisible(true);
        });
    }

    public Note getNote() {
        return note;
    }
}
