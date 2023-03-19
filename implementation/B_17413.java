import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean isOpen = false;
        StringBuilder temp = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '<') {
                isOpen = true;
                answer.append(temp.reverse());
                temp = new StringBuilder();
                temp.append(c);
            } else if (c == ' ') {
                if (!isOpen) {
                    answer.append(temp.reverse());
                    answer.append(' ');
                    temp = new StringBuilder();
                } else {
                    temp.append(c);
                }
            } else if (c == '>') {
                isOpen = false;
                temp.append('>');
                answer.append(temp);
                temp = new StringBuilder();
            } else {
                temp.append(c);
            }
        }
        if(!isOpen && temp.length() > 0) answer.append(temp.reverse());
        System.out.println(answer);
    }
}