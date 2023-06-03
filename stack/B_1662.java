import java.util.*;
import java.lang.*;
import java.io.*;

class B_1662 {
    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        Stack<Integer> len = new Stack<>();
        Stack<Integer> mul = new Stack<>();

        int cnt=0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='('){
                cnt-=1;
                int mulNum = str.charAt(i-1)-'0';
                len.add(cnt);
                mul.add(mulNum);
                cnt=0;
            }
            else if(c==')'){
                int val = mul.peek();
                mul.pop();
                val*=cnt;
                int plus = len.peek();
                len.pop();
                cnt = plus + val;
            }
            else  cnt++;
        }
        System.out.print(cnt);
    }
}