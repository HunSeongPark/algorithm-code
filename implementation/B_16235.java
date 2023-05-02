import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_16235 {

    static Node[][] map;
    static int N, M, K;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new Node[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = new Node(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[x][y].liveTree.add(z);
        }
        for (int k = 0; k < K; k++) {
            springAndSummer();
            autumnAndWinter();
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                answer += map[i][j].liveTree.size();
            }
        }
        System.out.println(answer);
    }

    public static void springAndSummer() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                PriorityQueue<Integer> newTree = new PriorityQueue<>();
                while (!map[i][j].liveTree.isEmpty()) {
                    if (map[i][j].cur < map[i][j].liveTree.peek()) {
                        map[i][j].dieTree.add(map[i][j].liveTree.poll());
                    } else {
                        map[i][j].cur -= map[i][j].liveTree.peek();
                        newTree.add(map[i][j].liveTree.poll() + 1);
                    }
                }
                map[i][j].liveTree = newTree;
                while (!map[i][j].dieTree.isEmpty()) {
                    map[i][j].cur += map[i][j].dieTree.poll() / 2;
                }
            }
        }
    }

    public static void autumnAndWinter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int count = 0;
                for (Integer tree : map[i][j].liveTree) {
                    if (tree % 5 == 0) count++;
                }
                for (int n = 0; n < 8; n++) {
                    int x = i + dx[n];
                    int y = j + dy[n];
                    if (x < 1 || x > N || y < 1 || y > N) continue;
                    for (int t = 0; t < count; t++) map[x][y].liveTree.add(1);
                }
                map[i][j].cur += map[i][j].A;
            }
        }
    }

    public static class Node {
        int A;
        int cur;
        PriorityQueue<Integer> liveTree;
        Queue<Integer> dieTree;

        public Node(int A) {
            this.A = A;
            this.cur = 5;
            liveTree = new PriorityQueue<>();
            dieTree = new LinkedList<>();
        }
    }
}