import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toLowerCase();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int max = 0;
        char answer = '?';
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                answer = (char)(i + 'A');
                max = count[i];
            } else if (count[i] == max) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
