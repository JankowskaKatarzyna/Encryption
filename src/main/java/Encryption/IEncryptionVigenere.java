package Encryption;

public interface IEncryptionVigenere {
    String code(String textToCode, String key);

    String decode(String textToDecode, String key);

}
