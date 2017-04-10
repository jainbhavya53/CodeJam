//package codejam.working;
//Working Excellent
//https://code.google.com/codejam/contest/4304486/dashboard#s=p1&a=1
//Main Logic behind this problem was every number will appear even number of times
//so if any number that appears odd number of times is part of our unknown list
import codejam.CodeJam;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BHAVYA
 */
public class RankAndFile {

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
            int num;
            Map<Integer, Integer> arr = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 2 * n-1; j++) {
                for (int c = 0; c < n; c++) {
                    num = in.nextInt();
                    if (arr.containsKey(num)) {
                        arr.put(num, arr.get(num) + 1);
                    } else {
                        arr.put(num, 1);
                        list.add(num);
                    }
                   //out.println(j);
                   //out.println(c);
                }
            }
            //out.println("HI");
            //out.println(arr.toString());
            //out.println(list.toString());
            int output[] = new int[n];
            int k = 0;
            for (int j = 0; j < list.size(); j++) {
                if (arr.get(list.get(j)) % 2 == 1) {
                    output[k] = list.get(j);
                    k++;
                }
            }
            Arrays.sort(output);
            out.printf("\nCase #%d:", i + 1);
            for (int j = 0; j < n; j++) {
                out.printf(" %d", output[j]);
            }
        }
    }

}
