//package codejam.working;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
//WorkingExcellent
//#CookieClicker
//GoogleCodeJam
//QualificationRound
//https://code.google.com/codejam/contest/2974486/dashboard
public class CookieClicker {
    public static class MyScanner{
        BufferedReader br;
        StringTokenizer st;

        public MyScanner()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

         String next()
         {
             while(st == null || !st.hasMoreTokens())
             {
                 try {
                     st = new StringTokenizer(br.readLine());
                 } catch (IOException ex) {
                     Logger.getLogger(CookieClicker.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             return st.nextToken();
         }

         int nextInt()
         {
             return Integer.parseInt(next());
         }

         long nextLong()
         {
             return Long.parseLong(next());
         }

         double nextDouble()
         {
             return Double.parseDouble(next());
         }

         String nextLine()
         {
             String temp = "";
            try {
                temp = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(CookieClicker.class.getName()).log(Level.SEVERE, null, ex);
            }
             return temp;
         }
    }

    public static PrintWriter out;

    public static void main(String args[])
    {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out),true);
        int t;
        t = in.nextInt();
        double []output = new double[t];
        double c,f,x;
        for(int i = 0;i<t;i++)
        {
            c = in.nextDouble();
            f = in.nextDouble();
            x = in.nextDouble();
            double current = 2;
            boolean result = false;
            double time_temp1,time_temp2;
            output[i] = 0;
            while(!result)
            {
                time_temp1 = (x)/current;
                time_temp2 = (c/current) + (x/(current + f));
                if(time_temp2-time_temp1 > 10e-15)
                {
                    output[i] = output[i] + time_temp1;
                    result = true;
                }
                else
                {
                    output[i] = output[i] + c/current;
                    current = current + f;
                }
                //out.println("time_time1:");
                //out.println(time_temp1);
                //out.println("time_time2:");
                //out.println(time_temp2);
                //out.println("output[i]:");
                //out.println(output[i]);
            }
        }
        for(int i = 0;i<t;i++)
        {
            out.printf("\nCase #%d: %.7f",i+1,output[i]);
        }
    }
}
