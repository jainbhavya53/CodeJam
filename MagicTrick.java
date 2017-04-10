//package codejam.working;
//Working Excellent
//#MagicTrick
//QualificationRound2014
//https://code.google.com/codejam/contest/2974486/dashboard
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;
public class MagicTrick {
    
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
                    //Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
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
                //Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
            }
            return temp;
        }
    }
    
    public static PrintWriter out;
    
    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out),true);
        int t;
        t = in.nextInt();
        int n,m;
        String input1[],input2[];
        input1 = new String[4];
        input2 = new String[4];
        String []output = new String[t];
        for(int i = 0;i<t;i++)
        {
            n = in.nextInt();
            for(int j = 0;j<4;j++)
            {
                input1[j] = in.nextLine();
            }
            m = in.nextInt();
            for(int j = 0;j<4;j++)
            {
                input2[j] = in.nextLine();
            }
            int count = 0;
            String temp = "";
            temp = temp.concat(" " + input2[m-1] + " ");
            input2[m-1] = temp;
            StringTokenizer str = new StringTokenizer(input1[n-1]);
            while(str.hasMoreTokens())
            {
                temp = str.nextToken();
                if(input2[m-1].contains(" " + temp + " "))
                {
                    count++;
                    output[i] = temp;
                }
            }
            if(count == 0)     
                {
                    output[i] = "Volunteer cheated!";
                }
            else if(count>1)
                {
                    output[i] = "Bad magician!"; 
                }
        }
        for(int i = 0;i<t;i++)
        {
            out.printf("\nCase #%d: %s",i+1,output[i]);
        }
    }
    
}
