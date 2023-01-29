import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16236 {

    static int N;
    static int[][] map;
    static int time = 0;
    static Node baby;
    static ArrayList<Node> fishes = new ArrayList<>();
    static int babyNum = 2;
    static int curEat = 0;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    baby = new Node(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }
        while (true) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(baby.i, baby.j, 0));
            visited = new boolean[N][N];
            visited[baby.i][baby.j] = true;
            fishes = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                if (!fishes.isEmpty() && poll.t == fishes.get(0).t) break;
                for (int n = 0; n < 4; n++) {
                    int x = poll.i + dx[n];
                    int y = poll.j + dy[n];
                    if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y] && map[x][y] <= babyNum) {
                        visited[x][y] = true;
                        queue.add(new Node(x, y, poll.t + 1));
                        if (babyNum > map[x][y] && map[x][y] != 0) {
                            fishes.add(new Node(x, y, poll.t + 1));
                        }
                    }
                }
            }
            if (fishes.isEmpty()) {
                System.out.println(time);
                return;
            }
            Node curFish = fishes.get(0);
            for (int n = 1; n < fishes.size(); n++) {
                if (curFish.i > fishes.get(n).i) {
                    curFish = fishes.get(n);
                } else if (curFish.i == fishes.get(n).i && curFish.j > fishes.get(n).j) {
                    curFish = fishes.get(n);
                }
            }
            time += curFish.t;
            baby = new Node(curFish.i, curFish.j, 0);
            map[curFish.i][curFish.j] = 0;
            curEat++;
            if (curEat == babyNum) {
                curEat = 0;
                babyNum++;
            }
        }
    }

    public static class Node {
        int i;
        int j;
        int t;

        public Node(int i, int j, int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }
}