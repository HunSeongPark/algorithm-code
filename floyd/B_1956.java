import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1956 {

    static int V, E;
    static int[][] adj;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new int[V + 1][V + 1];
        dist = new int[V + 1][V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u][v] = w;
        }
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j) {
                    if (adj[i][j] != 0) dist[i][j] = adj[i][j];
                    else dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (dist[i][j] == 0) {
                        if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    } else {
                        if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            answer = Math.min(answer, dist[i][i] == 0 ? Integer.MAX_VALUE : dist[i][i]);
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}