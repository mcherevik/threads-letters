package threads1712;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CommonResource res = new CommonResource();
        res.generateArray();
        res.printArray();
        System.out.println();

        ArrayList<Thread> editors = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            editors.add(new Thread(new ThreadEditor(res)));
        }

        for (Thread t : editors) {
            t.start();
        }
    }
}
