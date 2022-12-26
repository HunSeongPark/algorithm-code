import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_1043 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        int N;
        int M;
        int result = 0;
        int truth;
        ArrayList<String> party = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int true_num = Integer.parseInt(st.nextToken());
        if (true_num == 0) {
            System.out.println(M);
            return;
        }
        truth = Integer.parseInt(st.nextToken());
        for (int i = 1; i < true_num; i++) {
            int truth2 = Integer.parseInt(st.nextToken());
            union(truth, truth2);
            truth = truth2;
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            party.add(str);
            st = new StringTokenizer(str);
            int member_num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 1; j < member_num; j++) {
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
                a = b;
            }
        }
        for (int i = 0; i < M; i++) {
            String[] list = party.get(i).split(" ");
            boolean isLie = true;
            for (int j = 1; j < list.length; j++) {
                if (find(Integer.parseInt(list[j])) == find(truth)) {
                    isLie = false;
                    break;
                }
            }
            if (isLie) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}