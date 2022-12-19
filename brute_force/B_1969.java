import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1969 {

    public static void main(String[] args) throws IOException {
        int N, M;
        String[] A;
        int[] count = new int[4];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
        int max = 0;
        int sum = 0;
        char max_ch = '0';
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[j].charAt(i) == 'A') {
                    count[0]++;
                    if (count[0] > max) {
                        max = count[0];
                        max_ch = 'A';
                    } else if (count[0] == max && max_ch > 'A') {
                        max_ch = 'A';
                    }
                } else if (A[j].charAt(i) == 'C') {
                    count[1]++;
                    if (count[1] > max) {
                        max = count[1];
                        max_ch = 'C';
                    } else if (count[1] == max && max_ch > 'C') {
                        max_ch = 'C';
                    }
                } else if (A[j].charAt(i) == 'G') {
                    count[2]++;
                    if (count[2] > max) {
                        max = count[2];
                        max_ch = 'G';
                    } else if (count[2] == max && max_ch > 'G') {
                        max_ch = 'G';
                    }
                } else {
                    count[3]++;
                    if (count[3] > max) {
                        max = count[3];
                        max_ch = 'T';
                    }
                }
            }
            sb.append(max_ch);
            sum += (N - max);
            max = 0;
            count = new int[4];
        }
        System.out.println(sb);
        System.out.println(sum);
        br.close();
    }
}