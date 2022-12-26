package encryption;

public class Unicode extends Encrypt {

    public Unicode(int key, String message) {
        super(key, message);
    }

    @Override
    public String encrypt() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            char newChar = (char) (c + key);
            sb.append(newChar);
        }
        return sb.toString();
    }
}
