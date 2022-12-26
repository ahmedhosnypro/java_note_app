package note;

import gui.MainFrame;

import javax.swing.*;

public class ApplicationRunner {
    static MainFrame mainFrame;

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