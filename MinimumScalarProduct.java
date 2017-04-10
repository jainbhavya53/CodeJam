//Google CodeJam Round 1A 2008
//https://code.google.com/codejam/contest/32016/dashboard

//Working!!!!!!!
//package codejam.working;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumScalarProduct {
    public static void main(String[] args)
    {
        int t,n;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        long u[],v[],output[];
        output = new long[t];
        for(int i =0;i<t;i++)
        {
            output[i] = 0;
            n = in.nextInt();
            u = new long[n];
            v = new long[n];
            for(int j=0;j<n;j++)
            {
                u[j] = in.nextLong();
            }
            for(int j=0;j<n;j++)
            {
                v[j] = in.nextLong();
            }
            Arrays.sort(u);
            Arrays.sort(v);
            for(int j=0;j<n;j++)
            {
                output[i] = output[i] + u[j]*v[n-1-j];
            }
                                 
        }
        
        for(int i=0;i<t;i++)
        {
            System.out.printf("\nCase #%d: %d",i+1,output[i]);
        }
    }
    
}
