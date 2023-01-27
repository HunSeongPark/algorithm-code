import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1700 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] S = new int[K];
        int[] count = new int[K + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        int n_idx = 0;
        int k_idx = 0;
        while (n_idx < N) {
            if (k_idx == K) {
                System.out.println(0);
                return;
            }
            if (count[S[k_idx]] == 0) {
                count[S[k_idx]]++;
                n_idx++;
            }
            k_idx++;
        }
        int result = 0;
        for (int i = k_idx; i < K; i++) {
            if (count[S[i]] == 0) {
                int last = 0;
                int last_num = 0;
                for (int in = 0; in < i; in++) {
                    int cur = -1;
                    if (count[S[in]] == 1) {
                        int num = S[in];
                        for (int out = i + 1; out < K; out++) {
                            if (S[out] == num) {
                                cur = out;
                                break;
                            }
                        }
                        // 안 쓰임
                        if (cur == -1) {
                            last_num = num;
                            break;
                        } else {
                            if (last < cur) {
                                last = cur;
                                last_num = num;
                            }
                        }
                    }
                }
                count[S[i]]++;
                count[last_num]--;
                result++;
            }
        }
        System.out.println(result);
    }
}