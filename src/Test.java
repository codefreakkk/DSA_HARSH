import java.util.*;

public class Test {

    int a = 10;
    public void get(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        Test obj1 = new Test();
        obj1.get(10);

        Test obj2 = new Test();
        obj2.get(29);
    }
}
