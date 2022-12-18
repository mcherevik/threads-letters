package threads1712.room1;

class Element1{
    public String data;
}

public class Sandbox {

    public static void changeString(String str, int shift) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            int pos = str.charAt(i);
            if (pos + shift > 90) {
                res += (char) (pos + shift - 65);
            } else {
                res += (char) (pos + shift);
            }
        }
        str = res;
//        return res;
    }

    public static void foo(Element1 el ){
        el.data = "123";
    }

    public static void main(String[] args) {
        Element1 el = new Element1();
        el.data = " 456";
        System.out.println(el.data);
        foo(el);
        System.out.println(el.data);
    }
}
