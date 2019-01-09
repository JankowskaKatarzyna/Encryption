package Encryption;

import java.util.Scanner;

public class EncryptionDemo {
    static Scanner scanner = new Scanner(System.in);

    public static String readText() {
        System.out.println("Podaj tekst:");
        String text = scanner.nextLine();
        return text;
    }

    public static int getKeyCesar() {
        System.out.println("Podaj wartość liczbową, która posłuży jako klucz kodowania:");
        int key = Integer.parseInt(scanner.nextLine());
        return key;
    }

    public static String getKeyVigenere() {
        System.out.println("Podaj wartość tekstową, która posłuży jako klucz kodowania:");
        String key = scanner.nextLine();
        return key;
    }

    public static int chooseEncryptionMethod() {
        System.out.println("Której metody chcesz użyć?\n" + "1 - szyfr Cesare'a\n" + "2 - szyfr Vigenère’a.");
        int codeValue = Integer.parseInt(scanner.nextLine());
        return codeValue;
    }

    public static void printResults(String text) {
        System.out.println("Tekst po zastosowaniu kodowania/dekodowania: " + text + ".\n");
    }

    public static void main(String[] args) {
        System.out.println("Witaj w programie do kodowania tekstu!\n");
        int value = 99;
        while (value != 0) {
            System.out.println("Co chcesz zrobić:\n" + "1 - zakodować tekst\n" + "2 - odkodować tekst\n0 - zakonczyc program");
            value = Integer.parseInt(scanner.nextLine());
            switch (value) {
                case 1:
                    switch (chooseEncryptionMethod()) {
                        case 1:
                            String textToCodeCesar = readText();
                            int keyCesarCode = getKeyCesar();
                            EncryptionCesar cesarCode = new EncryptionCesar();
                            printResults(cesarCode.code(textToCodeCesar, keyCesarCode));
                            break;
                        case 2:
                            String textToCodeVigenere = readText();
                            String keyVinegreCode = getKeyVigenere();
                            EncryptionVigenere vigenereCode = new EncryptionVigenere();
                            printResults(vigenereCode.code(textToCodeVigenere, keyVinegreCode));
                            break;
                    }
                    break;
                case 2:
                    switch (chooseEncryptionMethod()) {
                        case 1:
                            String textToDecodeCesar = readText();
                            int keyCesarDecode = getKeyCesar();
                            EncryptionCesar cesarDecode = new EncryptionCesar();
                            printResults(cesarDecode.decode(textToDecodeCesar, keyCesarDecode));
                            break;
                        case 2:
                            String textToDecodeVigenere = readText();
                            String keyVinegreDecode = getKeyVigenere();
                            EncryptionVigenere vigenereDecode = new EncryptionVigenere();
                            printResults(vigenereDecode.decode(textToDecodeVigenere, keyVinegreDecode));
                            break;
                    }
                    break;

            }


        }

    }
}
