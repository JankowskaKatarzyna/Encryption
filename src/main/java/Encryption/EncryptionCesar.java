package Encryption;

// alphabet from char 32 to 687 (from "space" char to "latin small letter turned H" char)
public class EncryptionCesar implements IEncryptionCesar {

    @Override
    public String code(String textToCode, int key) {
        StringBuilder codedText = new StringBuilder(textToCode);
        int len = codedText.length();
        for (int i = 0; i < len; i++) {
            int letterCode = (int) codedText.charAt(i);
            if (letterCode + key > 687) {
                letterCode = 31 + (key - (687 - letterCode));
            } else {
                letterCode += key;
            }
            codedText.setCharAt(i, (char) letterCode);
        }
        return codedText.toString();
    }

    @Override
    public String decode(String textToDecode, int key) {
        StringBuilder codedText = new StringBuilder(textToDecode);
        int len = codedText.length();
        for (int i = 0; i < len; i++) {
            int letterCode = (int) codedText.charAt(i);
            if (letterCode - key < 32) {
                letterCode = 688 - (key - (letterCode - 32));
            } else {
                letterCode -= key;
            }
            codedText.setCharAt(i, (char) letterCode);
        }
        return codedText.toString();
    }
}
