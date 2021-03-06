//package codejam.working;
//For Large Dataset
//Working excellent for every dataset
//Qualification Round 2017
//https://code.google.com/codejam/contest/dashboard?c=3264486#s=p1
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
public class TidyNumbers_final {

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
        long num;
        for (int i = 0; i < t; i++) {
            num = in.nextLong();
            String input = Long.toString(num);//Input number in string
            String output;
            if (check(input)) {
                output = input;

            } else {
                int first = Integer.parseInt(input.substring(0, 1));
                String prev = "";
                String curr = "";
                for (int j = 0; j < input.length(); j++) {
                    prev = prev + Integer.toString(first);
                }
                //out.println("first:");
                //out.println(first);
                //out.println("prev:");
                //out.println(prev);
                //out.println(prev.compareTo(input));
                
                if (prev.compareTo(input) > 0) {
                    first--;
                    if (first == 0) {
                        for (int j = 0; j < input.length() - 1; j++) {
                            curr = curr + "9";
                        }
                        output = curr;
                    } else {
                        for (int j = 0; j < input.length(); j++) {
                            curr = curr + Integer.toString(first);
                        }
                        //out.println("curr:");
                        //out.println(curr);
                        
                        for (int j = 1; j < input.length(); j++) {
                            first = Integer.parseInt(curr.substring(j, j + 1));
                            //out.println("first:");
                            //out.println(first);
                            
                            String temp = curr;
                            StringBuilder sb = new StringBuilder(temp);
                            while (temp.compareTo(input) < 0 && first <= 10) {
                                curr = temp;
                                prev = "";
                                for (int k = j; k < input.length(); k++) {
                                    prev = prev + Integer.toString(first);
                                    //out.println("prev");
                                    //out.println(prev);
                                }
                                sb.replace(j, input.length(), prev);
                                temp = sb.toString();
                                //out.println("sb:");
                                //out.println(sb);
                                //out.println("curr:");
                                //out.println(curr);
                                first++;
                                //out.println("first:");
                                //out.println(first);
                            }
                        }
                        output = curr;
                    }
                } else {
                    /*for(int j = 0;j<input.length();j++)
                        {
                            curr = curr + Integer.toString(first);
                        }*/
                    curr = prev;
                    //out.println("curr:");
                    //out.println(curr);
                    for (int j = 1; j < input.length(); j++) {
                            first = Integer.parseInt(curr.substring(j, j + 1));
                            //out.println("first:");
                            //out.println(first);
                            
                            String temp = curr;
                            StringBuilder sb = new StringBuilder(temp);
                            while (temp.compareTo(input) < 0 && first <= 10) {
                                curr = temp;
                                prev = "";
                                for (int k = j; k < input.length(); k++) {
                                    prev = prev + Integer.toString(first);
                                    //out.println("prev");
                                    //out.println(prev);
                                }
                                sb.replace(j, input.length(), prev);
                                temp = sb.toString();
                                //out.println("sb:");
                                //out.println(sb);
                                //out.println("curr:");
                                //out.println(curr);
                                first++;
                                //out.println("first:");
                                //out.println(first);
                            }
                        }
                        output = curr;
                }
            }
            out.printf("\nCase #%d: %s", i + 1, output);
        }
    }

    public static boolean check(String num) {
        boolean result = true;
        for (int i = 0; i < num.length() - 1 && result; i++) {
            if (num.charAt(i) > num.charAt(i + 1)) {
                result = false;
            }
        }
        return result;
    }
}
