package encryption;

public abstract class Encrypt {
    protected int key;
    protected String data;

    protected Encrypt(int key, String message) {
        this.key = key;
        this.data = message;
    }

    public abstract String encrypt();
}

class Shift extends Encrypt {

    public Shift(int key, String message) {
        super(key, message);
    }

    @Override
    public String encrypt() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            char newChar = c;
            if (c >= 65 && c <= 90) {
                if (c + key < 90) {
                    newChar = (char) (c + key);
                } else {
                    int tmpKey = (c + (key % 26)) % 90;
                    newChar = (char) (64 + tmpKey);
                }

            } else if (c >= 97 && c <= 122) {
                if (c + key < 123) {
                    newChar = (char) (c + key);
                } else if (c + (key % 26) < 123) {
                    newChar = (char) (c + (key % 26));
                } else {
                    int tmpKey = (c + (key % 26)) % 122;
                    newChar = (char) (96 + tmpKey);
                }
            }
            sb.append(newChar);
        }
        return sb.toString();
    }
}

