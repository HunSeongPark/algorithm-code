    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class B_1018 {

        static int N;
        static int M;
        static boolean[][] map;
        static int answer = Integer.MAX_VALUE;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = s.charAt(j) == 'W';
                }
            }
            for (int i = 0; i <= N - 8; i++) {
                for (int j = 0; j <= M - 8; j++) {
                    checkCount(i, j);
                }
            }
            System.out.println(answer);
        }

        public static void checkCount(int x, int y) {
            int count = 0;
            boolean color = map[x][y];
            for (int i = x; i < x + 8; i++) {
                for (int j = y; j < y + 8; j++) {
                    if (color != map[i][j]) {
                        count++;
                    }
                    color = !color;
                }
                color = !color;
            }
            answer = Math.min(answer, Math.min(count, 64 - count));
        }
    }