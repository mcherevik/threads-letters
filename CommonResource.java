package threads1712;

import java.util.Random;

public class CommonResource {
    int num = 3;
    int stringLength = 6;
    String[] letters = new String[num];
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random = new Random();

    void generateArray() {
        for (int i = 0; i < num; i++) {
            letters[i] = "";
            for (int j = 0; j < stringLength; j++) {
                letters[i] += alphabet.charAt(random.nextInt(0, alphabet.length() - 1));
            }
        }
    }

    void printArray() {
        for (String s : letters) {
            System.out.print(s + " ");
        }
    }
}
