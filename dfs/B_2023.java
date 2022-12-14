import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2023 {

    static ArrayList<Integer>[] A;
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
        clear();
    }

    private static void dfs(int n, int j) {
        if (j == N) {
            if (isPrime(n)) {
                System.out.println(n);
            }
            return;
        }
        for (int i = 1; i <= 9; i += 2) {
            int newNum = n * 10 + i;
            if (isPrime(newNum)) {
                dfs(newNum, j + 1);
            }
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}