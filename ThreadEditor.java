package threads1712;

public class ThreadEditor implements Runnable {
    CommonResource res;

    ThreadEditor(CommonResource res) {
        this.res = res;
    }

    int shift;
    String currentWord;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            edit();
        }
    }

    void edit () {
        synchronized (res) {
            while (true) {
                shift = (int) (Math.random() * res.alphabet.length()) + 1;
                currentWord = res.getLetters()[(int) (Math.random() * res.getLetters().length)];
                for (int j = 0; j < currentWord.length(); j++) {
                    for (int k = 0; k < res.alphabet.length(); k++) {
                        if (currentWord.charAt(j) == res.alphabet.charAt(k)) {
                            if (k + shift < res.alphabet.length()) {
                                currentWord = currentWord.replace(currentWord.charAt(j), res.alphabet.charAt(k));
                                break;
                            } else {
                                int newPosition = (k + shift) - res.alphabet.length();
                                currentWord = currentWord.replace(currentWord.charAt(j), res.alphabet.charAt(newPosition));
                                break;
                            }
                        }
                    }
                }
                System.out.print(currentWord + " ");
                res.counter++;
                if (res.counter == 10) {
                    System.out.println();
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
