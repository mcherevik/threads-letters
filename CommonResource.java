package threads1712;

import java.util.Random;

public class CommonResource {
    int size = 10;
    int stringLength = 6;
    private String[] letters = new String[size];
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random = new Random();

    void generateArray() {
        for (int i = 0; i < size; i++) {
            getLetters()[i] = "";
            for (int j = 0; j < stringLength; j++) {
                getLetters()[i] += alphabet.charAt(random.nextInt(0, alphabet.length() - 1));
            }
        }
    }

    void printArray() {
        for (String s : getLetters()) {
            System.out.print(s + " ");
        }
    }

    public String[] getLetters() {
        return letters;
    }

    public void setLetters(String[] letters) {
        this.letters = letters;
    }
}
