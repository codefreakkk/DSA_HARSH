package CP_CODES.DIV2_1856;


import java.util.*;
import java.io.*;

public class ProblemA {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    public static void solve(FastReader in) {

        // input
        int n = in.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextLong();
        }

        int smallestIndex = n - 1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] <= nums[i]) {
                smallestIndex = i - 1;
            }
            else break;
        }
        long ans = 0;
        for (int i = 0; i < smallestIndex; i++) {
            ans = Math.max(ans, nums[i]);
        }
        System.out.println(ans);
    }


    public static void main(String[] args) throws IOException, Exception {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();

            // code here
            int t=in.nextInt();
            while(t-- > 0) {
                solve(in);
            }

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



