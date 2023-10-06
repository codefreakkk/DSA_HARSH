package CODES;

public class ReverseString {


    private String solve(int index, String s) {
        if (index == s.length() - 1) {
            return s.charAt(index) + "";
        }

        String result = solve(index + 1, s) + s.charAt(index);
        return result;
    }

    public String reverse(String s) {
        return solve(0, s);
    }

    public static void main(String[] args) {
        ReverseString o = new ReverseString();
        System.out.println(o.reverse("harsh"));
    }
}
