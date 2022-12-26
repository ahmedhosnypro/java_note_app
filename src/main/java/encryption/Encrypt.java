package encryption;

import java.util.Scanner;

public abstract class Encrypt {
    protected int key;
    protected String data;

    public Encrypt(int key, String message) {
        this.key = key;
        this.data = message;
    }

    abstract String encrypt();
}

class Shift extends Encrypt {

    public Shift(int key, String message) {
        super(key, message);
    }

    @Override
    String encrypt() {
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

class Unicode extends Encrypt {

    public Unicode(int key, String message) {
        super(key, message);
    }

    @Override
    String encrypt() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            char newChar = (char) (c + key);
            sb.append(newChar);
        }
        return sb.toString();
    }
}

class simpleEncrypt extends Encrypt {
    static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public simpleEncrypt(int key, String message) {
        super(key, message);
    }

    @Override
    String encrypt() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            char newChar = c;
            if (c >= 65 && c <= 90) {
                int n = 90 - c;
                if (n < 13) {
                    newChar = (char) (90 + n);
                } else newChar = (char) (65 - (25 - n));
            } else if (c >= 97 && c <= 122) {
                int n = 122 - c;
                if (n < 13) {
                    newChar = (char) (97 + n);
                } else newChar = (char) (122 - (25 - n));
            }
            sb.append(newChar);
        }
        return sb.toString();
    }
}
