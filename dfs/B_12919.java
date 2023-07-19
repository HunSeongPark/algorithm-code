import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_12919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        System.out.println(dfs(S, T) ? 1 : 0);
    }

    public static boolean dfs(String S, String T) {
        if (S.length() == T.length()) {
            return S.equals(T);
        }
        if (T.charAt(0) == 'B') {
            if (dfs(S, new StringBuilder(T.substring(1)).reverse().toString())) {
                return true;
            }
        }
        if (T.charAt(T.length() - 1) == 'A') {
            return dfs(S, T.substring(0, T.length() - 1));
        }
        return false;
    }
}
