package encryption;

public abstract class Decrypt {
    protected int key;
    protected String ciphertext;

    public Decrypt(int key, String ciphertext) {
        this.key = key;
        this.ciphertext = ciphertext;
    }

    public abstract String decrypt();
}

class DeShift extends Decrypt {

    public DeShift(int key, String ciphertext) {
        super(key, ciphertext);
    }

    @Override
    public String decrypt() {
        StringBuilder sb = new StringBuilder();
        if (key == 12)
            key += 2;
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            char newChar = c;
            if (c >= 65 && c <= 90) {
                if (c - key > 64) {
                    newChar = (char) (c - key);
                } else {
                    int tmpKey = 64 - (c - key);
                    newChar = (char) (90 - tmpKey);
                }
            } else if (c >= 97 && c <= 122) {
                if (c - key > 96) {
                    newChar = (char) (c - key);
                } else {
                    int tmpKey = 96 - (c - key);
                    newChar = (char) (122 - tmpKey);
                }
            }
            sb.append(newChar);
        }
        return sb.toString();
    }
}

