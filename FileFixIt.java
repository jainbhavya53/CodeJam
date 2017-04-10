//package codejam.working;

//Round 1B 2010
//https://code.google.com/codejam/contest/635101/dashboard

//Working Excellent

import codejam.CodeJam;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BHAVYA
 */
public class FileFixIt {

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

    public static class Node {

        String name;
        ArrayList<Node> child;

        public Node() {
            name = "";
            child = new ArrayList<>();
        }

        public Node(String input) {
            name = input;
            child = new ArrayList<>();
        }

        public void addChild(Node input) {
            child.add(input);
        }
    }

    public static void main(String args[]) {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int t = in.nextInt();
        int n, m, num;
        String input;
        for (int i = 0; i < t; i++) {
            n = in.nextInt();
            m = in.nextInt();
            Node root = new Node("root");
            num = 0;
            for (int j = 0; j < n; j++) {
                input = in.nextLine().substring(1);
                String temp[] = input.split("['/']");
                Node current = root;
                for (int k = 0; k < temp.length; k++) {
                    boolean result = false;
                    int index = -1;
                    for (int a = 0; a < current.child.size(); a++) {
                        if (current.child.get(a).name.equals(temp[k])) {
                            index = a;
                            result = true;
                        }
                    }
                    if (result) {
                        current = current.child.get(index);
                    } else {
                        current.addChild(new Node(temp[k]));
                        current = current.child.get(current.child.size() - 1);
                    }
                }
            }

            for (int j = 0; j < m; j++) {
                input = in.nextLine().substring(1);
                String temp[] = input.split("['/']");
                Node current = root;
                for (int k = 0; k < temp.length; k++) {
                    boolean result = false;
                    int index = -1;
                    for (int a = 0; a < current.child.size(); a++) {
                        if (current.child.get(a).name.equals(temp[k])) {
                            index = a;
                            result = true;
                        }
                    }
                    if (result) {
                        current = current.child.get(index);
                    } else {
                        current.addChild(new Node(temp[k]));
                        current = current.child.get(current.child.size() - 1);
                        num++;
                    }
                }
            }
            out.printf("Case #%d: %d\n",i+1,num);
        }

    }
}
