//package codejam.working;
//Working Excellent for every dataset
//Qualification Round 2017
//https://code.google.com/codejam/contest/3264486/dashboard
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
public class OversizedPancakeFlipper {

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
        int t = in.nextInt();
        String input;
        int k;
        for (int i = 0; i < t; i++) {
            input = in.next();
            StringBuilder sb = new StringBuilder(input);
            k = in.nextInt();
            int current;
            int num = 0;
            String output;
            boolean result = true;
            if (input.contains("-")) {
                current = input.indexOf("-");
                int temp;
                while (current <= input.length() - k && result) {
                    temp = current;
                    while (temp < current + k) {
                        if (sb.substring(temp, temp + 1).equals("+")) {
                            sb.replace(temp, temp + 1, "-");
                        } else {
                            sb.replace(temp, temp + 1, "+");
                        }
                        temp++;
                    }
                    num++;
                    input = sb.toString();
                    current = input.indexOf("-");
                    if (current == -1) {
                        result = false;
                    }
                }
                if(input.contains("-"))
                {
                    output = "IMPOSSIBLE";
                }
                else
                {
                    output = Integer.toString(num);
                }
            } else {
                output = "0";
            }
            out.printf("\nCase #%d: %s", i + 1, output);
        }
    }
}
