import java.util.*;

public class Test {

    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addLast(2);
        System.out.println(dq.poll());
    }
}
