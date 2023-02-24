import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1254 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            String newStr = str + new StringBuilder(str.substring(0, i)).reverse();
            if (newStr.equals(new StringBuilder(newStr).reverse().toString())) {
                System.out.println(str.length() + i);
                return;
            }
        }
    }
}