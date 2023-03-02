import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int answer = Integer.MAX_VALUE;
        int answerHeight = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int height = 0; height <= 256; height++) {
            int plus = 0;
            int minus = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (height < map[i][j]) {
                        minus += map[i][j] - height;
                    } else {
                        plus += height - map[i][j];
                    }
                }
            }
            int inven = B + minus;
            if (plus > inven) continue;
            int result = plus + minus * 2;
            if (result <= answer) {
                answer = result;
                answerHeight = height;
            }
        }
        System.out.println(answer + " " + answerHeight);
    }
}