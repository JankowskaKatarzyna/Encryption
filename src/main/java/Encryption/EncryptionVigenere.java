package Encryption;

public class EncryptionVigenere implements IEncryptionVigenere {

    @Override
    public String code(String textToCode, String key) {
        StringBuilder codedText = new StringBuilder();
        textToCode = textToCode.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < textToCode.length(); i++) {
            if (textToCode.charAt(i) != ' ') {
                char letterCode = textToCode.charAt(i);
                if (letterCode < 'A' || letterCode > 'Z')
                    continue;
                codedText.append((char) ((letterCode + key.charAt(j) - 2 * 'A') % 26 + 'A'));
                j = ++j % key.length();
            } else {
                codedText.append(" ");
                j = ++j % key.length();
            }

        }
        return codedText.toString();
    }

    @Override
    public String decode(String text, String key) {
        StringBuilder decodedText = new StringBuilder();
        text = text.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                char letterCode = text.charAt(i);
                if (letterCode < 'A' || letterCode > 'Z')
                    continue;
                decodedText.append((char) ((letterCode - key.charAt(j) + 26) % 26 + 'A'));
                j = ++j % key.length();
            } else {
                decodedText.append(" ");
                j = ++j % key.length();
            }
        }
        return decodedText.toString();
    }
}
