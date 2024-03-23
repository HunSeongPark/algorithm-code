import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16434 {
    static int N;
    static long A, result = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int typ = Integer.parseInt(st.nextToken()); // 타입
            int atk = Integer.parseInt(st.nextToken()); // 공격력
            int hp = Integer.parseInt(st.nextToken()); // 체력
            arr[i][0] = typ;
            arr[i][1] = atk;
            arr[i][2] = hp;
        }
        long L = 1;
        long R = Long.MAX_VALUE - 100;
        while (L <= R) {
            long mid = (L + R) / 2;
            if (check(mid)) {
                result = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(result);
    }

    public static boolean check(long maxHp) {
        long curHp = maxHp;
        double a = A;
        for (int i = 0; i < N; i++) {
            int typ = arr[i][0];
            int atk = arr[i][1];
            int hp = arr[i][2];
            if (typ == 1) {
                // 몬스터
                long minusHp = (long)(Math.ceil(hp / a - 1)) * atk;
                curHp -= minusHp;
                if (curHp <= 0) return false;
            } else {
                // 포션
                a += atk;
                curHp = Math.min(curHp + hp, maxHp);
            }
        }
        return true;
    }
}