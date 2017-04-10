//package codejam.working;
//Working Excellent
//Google CodeJam Round 1B 2016
//https://code.google.com/codejam/contest/11254486/dashboard
import java.util.Arrays;
import java.util.Scanner;

public class GettingTheDigits {
    public static void main(String[] args) {
        int t;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        String input;
        String output[];
        output = new String[t];
        for(int i =0;i<t;i++)
        {
            input = in.next();
            output[i] = "";
            while(input.contains("Z") || input.contains("W") || input.contains("U") || input.contains("X") || input.contains("G"))
            {
                if(input.contains("Z"))
                {
                    //Zero
                    input = input.replaceFirst("Z","");
                    input = input.replaceFirst("E","");
                    input = input.replaceFirst("R","");
                    input = input.replaceFirst("O","");
                    output[i] = output[i].concat("0");
                }
                else if(input.contains("W"))
                {
                    //Two
                    input = input.replaceFirst("T","");
                    input = input.replaceFirst("W","");
                    input = input.replaceFirst("O","");
                    output[i] = output[i].concat("2");
                }
                else if(input.contains("U"))
                {
                    //Four
                    input = input.replaceFirst("F","");
                    input = input.replaceFirst("O","");
                    input = input.replaceFirst("U","");
                    input = input.replaceFirst("R","");
                    output[i] = output[i].concat("4");
                }
                else if(input.contains("X"))
                {
                    //Six
                    input = input.replaceFirst("S","");
                    input = input.replaceFirst("I","");
                    input = input.replaceFirst("X","");
                    output[i] = output[i].concat("6");
                }
                else if(input.contains("G"))
                {
                    //Eight
                    input = input.replaceFirst("E","");
                    input = input.replaceFirst("I","");
                    input = input.replaceFirst("G","");
                    input = input.replaceFirst("H","");
                    input = input.replaceFirst("T","");
                    output[i] = output[i].concat("8");
                }
                
            }
            
            while(input.contains("O") || input.contains("R") || input.contains("F") || input.contains("S"))
            {
                if(input.contains("O"))
                {
                    input = input.replaceFirst("O","");
                    input = input.replaceFirst("N","");
                    input = input.replaceFirst("E","");
                    output[i] = output[i].concat("1");
                }
                else if(input.contains("R"))
                {
                    input = input.replaceFirst("T","");
                    input = input.replaceFirst("H","");
                    input = input.replaceFirst("R","");
                    input = input.replaceFirst("E","");
                    input = input.replaceFirst("E","");
                    output[i] = output[i].concat("3");
                }
                else if(input.contains("F"))
                {
                    input = input.replaceFirst("F","");
                    input = input.replaceFirst("I","");
                    input = input.replaceFirst("V","");
                    input = input.replaceFirst("E","");
                    output[i] = output[i].concat("5");
                }
                else if(input.contains("S"))
                {
                    input = input.replaceFirst("S","");
                    input = input.replaceFirst("E","");
                    input = input.replaceFirst("V","");
                    input = input.replaceFirst("E","");
                    input = input.replaceFirst("N","");
                    output[i] = output[i].concat("7");
                }

            }
            while(input.contains("N"))
            {
                input = input.replaceFirst("N","");
                input = input.replaceFirst("I","");
                input = input.replaceFirst("N","");
                input = input.replaceFirst("E","");
                output[i] = output[i].concat("9");
            }
            char seq[];
            seq = output[i].toCharArray();
            Arrays.sort(seq);
            output[i] = "";
            for(int j =0;j<seq.length;j++)
            {
                output[i] = output[i].concat(Character.toString(seq[j]));
            }
        }
        for(int i =0;i<t;i++)
        {
            System.out.printf("\nCase #%d: %s",i+1,output[i]);
        }
    }
    
}
