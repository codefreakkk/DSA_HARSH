
import java.util.*;
import java.io.*;

public class CP {
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
        int n = in.nextInt(), t = in.nextInt();
        String string = in.nextLine();

        StringBuilder ans = new StringBuilder(string);
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && ans.charAt(j) == 'B' && ans.charAt(j + 1) == 'G') {
                    ans.setCharAt(j, 'G');
                    ans.setCharAt(j + 1, 'B');
                    j++;
                }
            }
        }
        System.out.println(ans.toString());
    }


    public static void main(String[] args) throws IOException, Exception {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();

            // code here
//            int t=in.nextInt();
//            while(t-- > 0) {
                solve(in);
//            }

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



