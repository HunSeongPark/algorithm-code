import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int packMin = Integer.MAX_VALUE;
        int oneMin = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            packMin = Math.min(packMin, Integer.parseInt(st.nextToken()));
            oneMin = Math.min(oneMin, Integer.parseInt(st.nextToken()));
        }
        if (packMin / 6 >= oneMin) {
            System.out.println(oneMin * N);
        } else if (N % 6 == 0){
            System.out.println(packMin * (N / 6));
        } else {
            System.out.println(packMin * (N / 6) + Math.min(oneMin * (N % 6), packMin));
        }
    }
}