package leetcodeContest.WeeklyContest326;

public class ProblemA {
     public static int countDigits(int num) {
         int count = 0;
         int temp = num;

         while (temp > 0) {
             int rem = temp % 10;
             if (num % rem == 0)
                    count++;
             temp /= 10;
         }
         return count;
     }
    public static void main(String[] args) {
        int num = 7;
        System.out.println(countDigits(num));
    }
}
