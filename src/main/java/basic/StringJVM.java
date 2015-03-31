package basic;

/**
 * Created by wyzhangdongsheng1 on 15-3-30.
 */
public class StringJVM {
    public static void main(String[] args) {
//        String str1 = "abc";
//        String str2 = "abc";
//        System.out.println(str1 == str2);
//
//        String str3 = new String("abc");
//        System.out.println(str1 == str3);
        A a = new A();
        A b = new A();
        System.out.println(a);
        System.out.println(b);

        String str1 = "abc";
    }
}


class A {
    private String s = "abc";
}
