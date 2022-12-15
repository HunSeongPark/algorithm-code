import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_18352 {

    static int N;
    static int M;
    static int K;
    static int X;
    static ArrayList<Integer>[] A;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        boolean isEmpty = true;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == K) {
                isEmpty = false;
                System.out.println(i);
            }
        }
        if (isEmpty) {
            System.out.println(-1);
        }
        clear();
    }

    public static void bfs() {
        visited[X]++;
        queue.add(X);
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            for (Integer i : A[vertex]) {
                if (visited[i] == -1) {
                    visited[i] = visited[vertex] + 1;
                    queue.add(i);
                }
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            visited[i] = -1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}