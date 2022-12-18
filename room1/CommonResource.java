package threads1712.room1;

import java.util.Random;

class Element{
    public String data;

    public Element() {
        data = "";
    }
}

public class CommonResource {
    int size = 10;
    int stringLength = 6;
    private Element[] letters = new Element[size];
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random = new Random();
    int counter = 0; //changes counter
    int currentElement = 0;

    public CommonResource() {
        this.letters  = new Element[size];
        for (int i = 0; i < letters.length; i++) {
            this.letters[i] = new Element();
        }
        this.random = new Random();
    }

    public void threadPrint(String str) {
        System.out.println(Thread.currentThread().getName() + " : " + str);
    }

    public synchronized Element getString() {
//    public String getString() {
        threadPrint("getting " + currentElement + "th/st element");
        Element res = letters[currentElement];
        currentElement++;
        if (currentElement >= size) {
            currentElement = 0;
        }
        return res;
    }


    public synchronized void increaseCounter() {
        this.counter++;
    }

    void generateArray() {
        for (int i = 0; i < size; i++) {
            getLetters()[i].data = "";
            for (int j = 0; j < stringLength; j++) {
                getLetters()[i].data += alphabet.charAt(random.nextInt(0, alphabet.length() - 1));
            }
        }
    }

    void printArray() {
        for (Element s : getLetters()) {
            System.out.print(s.data + " ");
        }
    }

    public synchronized Element[] getLetters() {
        return letters;
    }
}
