import java.util.*;

public class Test {
    public static void main(String[] args) {
        int a = 10;
        int b = 9;
        int c = 7;
        a = a>>b ^ c<<2;
        System.out.println(a);
    }
}
