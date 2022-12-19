package threads1712;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadWatcher implements Runnable {

    CommonResource res;
    private String outFilePath = "C:\\Users\\1288947\\IdeaProjects\\tasks\\src\\main\\java\\threads1712\\res.txt";

    public ThreadWatcher(CommonResource res) {
        this.res = res;
    }

    public void threadPrint(Object str) {
        System.out.println(Thread.currentThread().getName() + " : " + str);
    }

    @Override
    public void run() {
        threadPrint(" started...");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadPrint(res.counter);
            if (res.counter >= 10) {
                toFile();
                res.counter -= 10;
            }
        }
    }

    String writeChanges(Element[] letters) {
        StringBuilder result = new StringBuilder();
        for (Element letter : letters) {
            result.append(letter.data).append(" ");
        }
        return result.toString();
    }

    void toFile() {
        try(FileOutputStream fos = new FileOutputStream(outFilePath, true)) {
            String toWrite = writeChanges(res.getStringsArray());
            threadPrint("string to write to file :" + toWrite);
            byte[] buffer = toWrite.getBytes();
            fos.write(buffer, 0, buffer.length);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The file has been written");
    }

}
