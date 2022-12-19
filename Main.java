package threads1712;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CommonResource res = new CommonResource();
        res.generateArray();
        System.out.println("Initial array");
        res.printArray();
        System.out.println();
        System.out.println("New array");

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            threads.add(new Thread(new ThreadEditor(res)));
        }
        Thread watcher = new Thread(new ThreadWatcher(res));
        threads.add(watcher);

        for (Thread t : threads) {
            t.start();
        }

//        for (Thread t : threads) {
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}
