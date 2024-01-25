import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_1644 {

    static boolean[] primes;
    static ArrayList<Integer> primeList = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        primes = new boolean[N + 1];
        getPrimes();
        if (primeList.size() == 0) {
            System.out.println(0);
            return;
        }
        int L = 0;
        int R = 0;
        int sum = primeList.get(0);
        int answer = 0;
        while (R < primeList.size() - 1) {
            if (sum == N) {
                answer++;
                sum += primeList.get(++R);
            } else if (sum > N) {
                sum -= primeList.get(L++);
            } else {
                sum += primeList.get(++R);
            }
        }
        if (primeList.get(primeList.size() - 1) == N) answer++;
        System.out.println(answer);
    }

    // 에라토스테네스의 체 O(N loglogN)
    private static void getPrimes() {
        for (int i = 2; i <= N; i++) {
            if (!primes[i]) {
                primeList.add(i);
                for (int j = i + i; j <= N; j += i) {
                    primes[j] = true;
                }
            }
        }
    }
}
