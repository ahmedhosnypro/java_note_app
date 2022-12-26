package encryption;

public class DeShiftUnicode extends Decrypt {

    public DeShiftUnicode(int key, String ciphertext) {
        super(key, ciphertext);
    }

    @Override
    public String decrypt() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            char newChar = (char) (c - key);
            sb.append(newChar);
        }
        return sb.toString();
    }
}
