import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_16958 {

    static City[] cities;
    static int[][] distance;
    static int N, T, M;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        cities = new City[N + 1];
        distance = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cities[i] = new City(s, x, y);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                boolean isTeleport = cities[i].s + cities[j].s == 2;
                int w = Math.abs(cities[i].x - cities[j].x) + Math.abs(cities[i].y - cities[j].y);
                distance[i][j] = isTeleport ? Math.min(T, w) : w;
            }
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            answer.append(distance[S][E]).append("\n");
        }
        System.out.println(answer);
    }

    static class City {
        int s;
        int x;
        int y;

        public City(int s, int x, int y) {
            this.s = s;
            this.x = x;
            this.y = y;
        }
    }
}