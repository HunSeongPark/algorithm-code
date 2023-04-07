import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int L = 0;
            int R = s.length() - 1;
            boolean isRemove = false;
            boolean isFind = true;
            while (L < R) {
                if (s.charAt(L) == s.charAt(R)) {
                    L++;
                    R--;
                } else {
                    if (isRemove) {
                        isFind = false;
                        break;
                    } else {
                        if (s.charAt(L + 1) == s.charAt(R) && s.charAt(R - 1) == s.charAt(L)) {
                            isRemove = true;
                            boolean innerFind = true;
                            int S = L + 1;
                            int E = R;
                            while (S < E) {
                                if (s.charAt(S) != s.charAt(E)) {
                                    innerFind = false;
                                    break;
                                }
                                S++;
                                E--;
                            }
                            if (!innerFind) {
                                S = L;
                                E = R - 1;
                                while (S < E) {
                                    if (s.charAt(S) != s.charAt(E)) {
                                        isFind = false;
                                        break;
                                    }
                                    S++;
                                    E--;
                                }
                            }
                            break;
                        } else if (s.charAt(L + 1) == s.charAt(R)) {
                            isRemove = true;
                            L++;
                        } else if (s.charAt(R - 1) == s.charAt(L)) {
                            isRemove = true;
                            R--;
                        } else {
                            isFind = false;
                            break;
                        }
                    }
                }
            }
            if (!isFind) {
                answer.append(2).append("\n");
            } else {
                answer.append(isRemove ? 1 : 0).append("\n");
            }
        }
        System.out.println(answer);
    }
}