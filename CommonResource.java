package threads1712;

import java.util.Random;

public class CommonResource {
    private int size;
    private int stringLength;
    private Element[] stringsArray;
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random;
    int counter = 0;
    int currentElement = 0;

    public CommonResource() {
        this.size = 10;
        this.stringLength = 6;
        this.stringsArray = new Element[size];
        for (int i = 0; i < stringsArray.length; i++) {  // how many Elements in array
            this.stringsArray[i] = new Element();    // filling the array with Elements
        }
        this.random = new Random();
    }

    public void threadPrint(String str) {
        System.out.println(Thread.currentThread().getName() + " : " + str);
    }

    public synchronized Element getString() {       // getting one String out of array
        threadPrint("getting " + currentElement + " th/st element"); // which thread takes which String
        Element res = stringsArray[currentElement];      // putting one string to res
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
            getStringsArray()[i].data = "";
            for (int j = 0; j < stringLength; j++) {
                getStringsArray()[i].data += alphabet.charAt(random.nextInt(0, alphabet.length() - 1));
            }
        }
    }

    void printArray() {
        for (Element e : getStringsArray()) {
            System.out.print(e.data + " ");
        }
    }

    public synchronized Element[] getStringsArray() {
        return stringsArray;
    }
}
