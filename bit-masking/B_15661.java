import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15661 {

    static int min = Integer.MAX_VALUE;
    static int N;
    static int[][] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*
         * 경우의 수 (이진수) = 1 ~ (2^N - 2) / 2
         * ex) N = 4일 때 1 ~ 7
         * 0001 (1)
         * 0010 (2)
         * 0011 (3)
         * 0100 (4)
         * 0101 (5)
         * 0110 (6)
         * 0111 (7)
         * ----
         * 1000 (8) -> 0001과 같은 결과
         */
        int loop = (int)(Math.pow(2, N) - 2) / 2;
        for (int n = 1; n <= loop; n++) {
            String s = Integer.toBinaryString(n); // n에 대해 이진수 변환
            StringBuilder sb = new StringBuilder();
            sb.append("0".repeat(N - s.length())); // N - s.length만큼 앞에 0 붙임
            sb.append(s); // s 뒤에 붙여 N자리 이진수로 변환
            char[] team = sb.toString().toCharArray();
            calc(team);
        }
        System.out.println(min);
    }

    private static void calc(char[] team) {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (team[i] == team[j] && team[i] == '0') {
                    start += S[i][j] + S[j][i];
                }
                if (team[i] == team[j] && team[i] == '1') {
                    link += S[i][j] + S[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(start - link));
        if (min == 0) { // 최솟값이 0인 경우 정답이므로 바로 출력 및 종료
            System.out.println(0);
            System.exit(0);
        }
    }
}