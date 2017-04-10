//package codejam.working;
//Working Excellent
//https://code.google.com/codejam/contest/6224486/dashboard
//Qualification Round 2015
import codejam.CodeJam;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BHAVYA
 */
public class StandingOvation {

    public static class MyScanner {

        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ex) {
                    Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String temp = "";
            try {
                temp = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
            }
            return temp;
        }
    }

    public static PrintWriter out;

    public static void main(String args[]) {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int t, n;
        t = in.nextInt();
        for (int i = 0; i < t; i++) {
            n = in.nextInt();
            int s[] = new int[n + 1];
            String input = in.next();
            for (int j = 0; j < n + 1; j++) {
                s[j] = Integer.parseInt(input.substring(j,j+1));
            }
            int output = 0;
            int temp = s[0];
            for (int j = 1; j < n + 1; j++) {
                //out.println("hi");
                if (j <= temp) {
                    temp = temp + s[j];
                } else {
                    output = output + j - temp;
                    temp = j + s[j];
                }
                //out.println(temp);
            }
            out.printf("\nCase #%d: %d", i + 1, output);
        }
    }
}
