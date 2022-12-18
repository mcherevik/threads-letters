package threads1712;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadWatcher implements Runnable {

    CommonResource res;

    public ThreadWatcher(CommonResource res) {
        this.res = res;
    }

    @Override
    public void run() {
        while(true) {
            if (res.counter == 10) {
                toFile();
                res.counter = 0;
            }
        }
    }

    String writeChanges(String[] letters) {
        StringBuilder result = new StringBuilder();
        for (String letter : letters) {
            result.append(letter).append(" ");
        }
        return result.toString();
    }

    void toFile() {
        try(FileOutputStream fos = new FileOutputStream("C:\\Users\\1288947\\IdeaProjects\\tasks\\src\\main\\java\\threads1712\\res.txt")) {
            byte[] buffer = writeChanges(res.getLetters()).getBytes();
            fos.write(buffer, 0, buffer.length);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The file has been written");
    }
}
