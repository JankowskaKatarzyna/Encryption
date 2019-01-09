package Encryption;

public interface IEncryptionCesar {
    String code(String textToCode, int key);

    String decode(String textToDecode, int key);

}
