//package codejam.working;
//https://code.google.com/codejam/contest/189252/dashboard#s=p0&a=0
//Google Code Jam 2009
//Round 1C
//Working Excellent
//This Code had two problems:---
/*
    1.The code that is commented at the end worked if the input did not contain digits
    2.For small test cases this code worked fine but for large test cases it ot rejected.That was because
    the pow function works fine for integers upto 2^51(width of mantissa. Beyond that integers cannot be represented
    with perfect precision and will give you all the nastiness people have
    pointed out.
    
    Refer to this page for more queries:---
    https://groups.google.com/forum/#!searchin/google-code/all$20your$20base%7Csort:relevance/google-code/tYdMGxm6i18/IVP1J16CbxEJ
    
-----BOTH OF THE LIMITATIONS HAVE BEEN REMOVED---
---Now Working Excellent---
*/
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
public class AllYourBase {

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
        for (int i = 0; i < t; i++) {
            input = in.nextLine();
            String temp = input;
            String list = "";
            int num = 0;
            while (!temp.equals("")) {
                //out.println(temp);
                list = list + temp.substring(0, 1);
                temp = temp.replaceAll(temp.substring(0, 1), "");
                num++;
            }
            int value[] = new int[num];
            if (num == 1) {
                num = 2;
            }
            value[0] = 1;
            if (value.length > 1) {
                value[1] = 0;
                if (value.length > 2) {
                    for (int j = 2; j < value.length; j++) {
                        value[j] = j;
                    }
                }
            }
            long output = 0;
            int a = 0;
            for (int j = input.length() - 1; j >= 0; j--) {
                output = output + value[list.indexOf(input.substring(j, j + 1))] * pow(num, a);
                a++;
            }

            out.printf("\nCase #%d: %d", i + 1, output);
        }
    }
    
    public static long pow(int num,int a)
    {
        if(a == 0)
        {
            return 1;
        }
        else
        {
            long output = 1;
            for(int i = 1;i<=a;i++)
            {
                output = output * num;
            }
            return output;
        }
    }
}



/*

input = input.replaceAll(list.substring(0,1), "1");
            out.println(input);
            if(list.length() >1)
            {
                input = input.replaceAll(list.substring(1,2), "0");
                out.println(input);
                if(list.length() > 2)
                {    
                    for(int j = 2;j<list.length();j++)
                    {
                        input = input.replaceAll(list.substring(j, j+1),Integer.toString(j));
                        out.println(input);
                    }
                }
            }
            out.println(input);
            long output = 0;
            int a = 0;
            for(int j = input.length()-1;j>=0;j--)
            {
                output = output + Integer.parseInt(input.substring(j,j+1))*(int)Math.pow(num,a);
                a++;
                out.println(output);
            }*/
