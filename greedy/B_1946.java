import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            User[] users = new User[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                users[i] = new User(a, b);
            }
            Arrays.sort(users);
            int result = 1;
            int min = users[0].b;
            for (int i = 1; i < N; i++) {
                User current = users[i];
                if (current.b < min) {
                    min = current.b;
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    public static class User implements Comparable<User> {
        int a;
        int b;

        public User(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(User o) {
            return this.a - o.a;
        }
    }
}