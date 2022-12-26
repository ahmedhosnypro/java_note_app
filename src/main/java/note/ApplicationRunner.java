package note;

import gui.MainFrame;
import gui.NoteGrid;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationRunner {
    static MainFrame mainFrame;
    static NoteGrid noteGrid = new NoteGrid();

    public static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> mainFrame = new MainFrame());
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }
}