import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_9461
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] DP = new long[101];
        DP[1] = 1;
        DP[2] = 1;
        DP[3] = 1;
        for (int i = 4; i <= 100; i++) {
            DP[i] = DP[i - 2] + DP[i - 3];
        }
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(DP[N]);
        }
    }
}