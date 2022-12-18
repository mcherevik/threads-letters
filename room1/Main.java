package threads1712.room1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CommonResource res = new CommonResource();
        res.generateArray();
        System.out.println("Initial array");
        res.printArray();
        System.out.println();
        System.out.println("New array");

        ArrayList<Thread> editors = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            editors.add(new Thread(new ThreadEditor(res)));
        }

        Thread watcher = new Thread(new ThreadWatcher(res));
        watcher.start();

        for (Thread t : editors) {
            t.start();
        }
//        for (Thread t : editors) {
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            watcher.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        for (Thread t : editors) {
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}
