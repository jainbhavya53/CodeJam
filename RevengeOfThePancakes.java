//package codejam.working;
import java.util.Scanner;
//Working Excellent
//Google Code Jam Qualification Round 2016
//https://code.google.com/codejam/contest/6254486/dashboard#s=p1
public class RevengeOfThePancakes {
    public static void main(String[] args) {
        int t;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        String input;
        int []count = new int[t];
        for(int i = 0;i<t;i++)
        {
            input = in.next();
            String output = "",minus = "";
            for(int j =0;j<input.length();j++)
            {
                output = output.concat("+");
                minus = minus.concat("-");
            }
            count[i] = 0;
            while(!input.equals(output))
            {
                boolean result = false;
                int temp1 = -1,pos = 0;
                for(int j = 0;j<input.length()-1 && !result;j++)
                {
                    if(input.charAt(j) != input.charAt(j+1))
                    {
                        result = true;
                        pos = j;
                        if(input.charAt(j) == '+')
                        {
                            temp1 = 0;//plus;
                        }
                        else
                        {
                            temp1 = 1;//minus
                        }
                    }
                }
                if(result)
                {
                    count[i]++;
                    String use;
                    if(temp1 == 0)
                    {
                        use = minus.substring(0,pos+1);
                        use = use.concat(input.substring(pos+1,input.length()));
                        input = use;
                    }
                    else
                    {
                        use = output.substring(0, pos+1);
                        use = use.concat(input.substring(pos+1,input.length()));
                        input = use;
                    }
                }
                else 
                {
                    input = output;
                    count[i]++;
                }
            }
        }
        for(int i =0;i<t;i++)
        {
            System.out.printf("\nCase #%d: %d",i+1,count[i]);
        }
    }
    
}
