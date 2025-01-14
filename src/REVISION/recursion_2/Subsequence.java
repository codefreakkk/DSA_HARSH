package REVISION.recursion_2;

public class Subsequence {

    public void subsequence(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p);
            System.out.print(" ");
            return;
        }

        subsequence(p + up.charAt(0), up.substring(1));
        subsequence(p, up.substring(1));
    }

    public static void main(String[] args) {
        Subsequence s = new Subsequence();
        s.subsequence("", "abc");
    }

}
