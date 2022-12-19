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
        Element str = null;
        int shift = 0;
        while (true) {
            str = this.res.getString();
            shift = (int)(Math.random() * res.alphabet.length()) + 1;
            changeString(str, shift);
            res.increaseCounter();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void changeString(Element str, int shift) {
        String res = "";                                    // changing a particular String
        for (int i = 0; i < str.data.length(); i++) {
            int pos = str.data.charAt(i);
            if (pos + shift > 90) {
                res += (char) (pos + shift - 65);
            }
            else {
                res += (char) (pos + shift);
            }
        }
        str.data = res;                                     // assigning the changes to the target String
    }

//    void edit () {
//        while (true) {
//            shift = (int) (Math.random() * res.alphabet.length()) + 1;
//            //currentWord = res.getStringsArray()[(int) (Math.random() * res.getStringsArray().length)].data;
//            currentWord = res.getString().data;
//            for (int j = 0; j < currentWord.length(); j++) {
//                for (int k = 0; k < res.alphabet.length(); k++) {
//                    if (currentWord.charAt(j) == res.alphabet.charAt(k)) {
//                        if (k + shift < res.alphabet.length()) {
//                            currentWord = currentWord.replace(currentWord.charAt(j), res.alphabet.charAt(k));
//                        } else {
//                            int newPosition = (k + shift) - res.alphabet.length();
//                            currentWord = currentWord.replace(currentWord.charAt(j), res.alphabet.charAt(newPosition));
//                        }
//                        break;
//                    }
//                }
//            }
//            System.out.print(currentWord + " ");
//            res.increaseCounter();
//            if (res.counter == 10) {
//                System.out.println();
//            }
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
}
