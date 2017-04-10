//Counting Sheeps
//Working!!!!!!!
//Google Code Jam Qualification Round 2016
//https://code.google.com/codejam/contest/6254486/dashboard
//package codejam.working;
import java.util.Scanner;
public class CountingSheeps {
    
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int a[];
        a = new int[10];
        int t,i;
        t = in.nextInt();
        long num[];
        num = new long[t];
        for(i =0;i<t;i++)
        {
            num[i] = in.nextLong();
        }
        for(i=0;i<t;i++)
        {
            for(int k=0;k<10;k++)
            {
                a[k] = 0;
            }
            if(num[i] != 0)
            {
                int j = 1;
                boolean result = false;
                
                int rem = 0;
                int b;
                while(!result)
                {
                    long temp=1;
                    int c =0;
                    while(temp!=0)
                    {
                        temp = ((num[i]*j)/(long)(Math.pow(10,c)));
                        if(temp !=0)
                        {
                            rem = (int)temp%10;
                        }
                        a[rem]++;
                        c++;
                    }
                    b = 0;
                    for(int k =0;k<10;k++)
                    {
                        if(a[k] != 0)
                        {
                            b++;
                        }
                    }
                    //System.out.println("hello");
                    if(b==10)
                    {
                        result = true;
                        System.out.printf("\nCase #%d: %d",i+1,(num[i]*j));
                    }
                    j++;
                }
            }
            else
            {
                System.out.printf("\nCase #%d: "+"INSOMNIA",i+1);
            }
        }
  
    }
}
