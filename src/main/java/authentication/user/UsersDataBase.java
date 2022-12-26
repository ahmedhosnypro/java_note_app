package authentication.user;

import encryption.DeShiftUnicode;
import encryption.Decrypt;
import encryption.Encrypt;
import encryption.Unicode;
import note.Note;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDataBase {
    private static final String JDBC_URL_PREFIX = "jdbc:sqlite:";
    private static final SQLiteDataSource usersDataSource = new SQLiteDataSource();
    public static final Connection usersConnection;

    private static final int ENCRIPTION_KEY = 55;

    static {
        usersDataSource.setUrl(JDBC_URL_PREFIX + "src\\main\\resources\\data\\database\\notes.db");
        try {
            usersConnection = usersDataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isUserExist(String username) {
        String selectQuery = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = usersConnection.prepareStatement(selectQuery)) {
            statement.setString(1, username);
            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void addUser(String username, String password) {
        Encrypt encrypt = new Unicode(ENCRIPTION_KEY, password);
        String encryptedPassword = encrypt.encrypt();

        String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement statement = usersConnection.prepareStatement(insertQuery)) {
            statement.setString(1, username);
            statement.setString(2, encryptedPassword);
            statement.executeUpdate();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isPasswordCorrect(String username, String password) {
        String selectQuery = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = usersConnection.prepareStatement(selectQuery)) {
            statement.setString(1, username);
            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String encryptedPassword = resultSet.getString("password");
                Decrypt encrypt = new DeShiftUnicode(ENCRIPTION_KEY, encryptedPassword);
                String decryptedPassword = encrypt.decrypt();
                return password.equals(decryptedPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void addNoteToUser(int userId, String note) {
        String insertQuery = "INSERT INTO notes (userId, content) VALUES (?, ?)";
        try (PreparedStatement statement = usersConnection.prepareStatement(insertQuery)) {
            Encrypt encrypt = new Unicode(ENCRIPTION_KEY, note);
            String encryptedNote = encrypt.encrypt();
            statement.setInt(1, userId);
            statement.setString(2, encryptedNote);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Note> getNotes(int userId) {
        List<Note> notes = new ArrayList<>();
        String selectQuery = "SELECT * FROM notes WHERE userId = ?";
        try (PreparedStatement statement = usersConnection.prepareStatement(selectQuery)) {
            statement.setInt(1, userId);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String encryptedNote = resultSet.getString("content");
                Decrypt decrypt = new DeShiftUnicode(ENCRIPTION_KEY, encryptedNote);
                notes.add(new Note(
                        resultSet.getInt("id"),
                        decrypt.decrypt()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

    public static int getUserId(String username) {
        String selectQuery = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = usersConnection.prepareStatement(selectQuery)) {
            statement.setString(1, username);
            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void updateNote(int id, String text) {
        String updateQuery = "UPDATE notes SET content = ? WHERE id = ?";
        try (PreparedStatement statement = usersConnection.prepareStatement(updateQuery)) {
            Encrypt encrypt = new Unicode(ENCRIPTION_KEY, text);
            String encryptedNote = encrypt.encrypt();
            statement.setString(1, encryptedNote);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteNoteById(int id) {
        String deleteQuery = "DELETE FROM notes WHERE id = ?";
        try (PreparedStatement statement = usersConnection.prepareStatement(deleteQuery)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}