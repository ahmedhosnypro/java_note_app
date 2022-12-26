package authentication.user;

public class UsernameChecker {
    public static boolean isValidUserName(String username) {
        if (username.length() < 6 || username.length() > 20) {
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (i == 0 && (c >= 48 && c <= 57)) {
                return false;
            }
            if (!((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57) || c == 95)) {
                return false;
            }
        }
        return true;
    }
}
