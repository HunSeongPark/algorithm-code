import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_6588 {

    static final int MAX = 1_000_001;
    static boolean[] primes = new boolean[MAX];
    static ArrayList<Integer> primeList = new ArrayList<>();
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        getPrimes();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            for (Integer i : primeList) {
                if (i > n) {
                    answer.append("Goldbach's conjecture is wrong.").append("\n");
                    break;
                }
                if (!primes[n - i]) {
                    answer.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    private static void getPrimes() {
        for (int i = 2; i < MAX; i++) {
            if (!primes[i]) {
                if (i % 2 == 1) primeList.add(i);
                for (int j = i + i; j < MAX; j+=i) {
                    primes[j] = true;
                }
            }
        }
    }
}
