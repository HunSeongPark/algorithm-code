import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_19236
{
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static Node[][] originalMap = new Node[4][4];
    static int answer = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int n = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                originalMap[i][j] = new Node(n, dir);
            }
        }
        dfs(0, 0, originalMap[0][0].dir, 0, copyMap(originalMap));
        System.out.println(answer);
    }

    public static void dfs(int i, int j, int dir, int result, Node[][] map) {
        result += map[i][j].n;
        map[i][j] = new Node(-1, -1);
        move(i, j, map);
        i += dx[dir];
        j += dy[dir];
        while (i >= 0 && i < 4 && j >= 0 && j < 4) {
            if (map[i][j].n == -1) {
                i += dx[dir];
                j += dy[dir];
                continue;
            }
            dfs(i, j, map[i][j].dir, result, copyMap(map));
            i += dx[dir];
            j += dy[dir];
        }
        answer = Math.max(answer, result);
    }

    public static void move(int i, int j, Node[][] map) {
        int targetX = -1;
        int targetY = -1;
        for (int target = 1; target <= 16; target++) {
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    if (map[x][y].n == target) {
                        targetX = x;
                        targetY = y;
                        break;
                    }
                }
            }
            if (targetX != -1) {
                int dir = map[targetX][targetY].dir;
                int changeX = targetX + dx[dir];
                int changeY = targetY + dy[dir];
                int count = 1;
                while (changeX < 0 || changeX >= 4 || changeY < 0 || changeY >= 4 || (changeX == i && changeY == j)) {
                    dir++;
                    if (dir > 8) dir = 1;
                    changeX = targetX + dx[dir];
                    changeY = targetY + dy[dir];
                    count++;
                    if (count > 8) break;
                }
                Node tmp = new Node(target, dir);
                map[targetX][targetY] = map[changeX][changeY];
                map[changeX][changeY] = tmp;
            }
            targetX = -1;
            targetY = -1;
        }
    }

    public static Node[][] copyMap(Node[][] original) {
        Node[][] copy = new Node[4][4];
        for (int i = 0; i < 4; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    public static class Node {
        int n;
        int dir;

        public Node(int n, int dir) {
            this.n = n;
            this.dir = dir;
        }
    }
}