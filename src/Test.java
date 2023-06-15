import java.util.*;

public class Test {
    public static void main(String[] args) {
        Queue<Object> q = new LinkedList<>();
        q.offer(1);
        q.offer(null);
        q.offer(null);
        q.poll();
        System.out.println(q.size());
    }
}
