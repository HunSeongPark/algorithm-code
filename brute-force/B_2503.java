import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2503 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Question[] questions = new Question[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            questions[i] = new Question(num, strike, ball);
        }
        for (int n = 123; n <= 987; n++) {
            if (!checkNum(n)) continue;
            int passCount = 0;
            for (int i = 0; i < N; i++) {
                String questionNum = questions[i].num;
                String curNum = String.valueOf(n);
                int strike = questions[i].strike;
                int ball = questions[i].ball;
                int strikeCount = 0;
                int ballCount = 0;
                // Strike Count
                for (int j = 0; j < 3; j++) {
                    if (questionNum.charAt(j) == curNum.charAt(j)) strikeCount++;
                }
                // Ball Count
                for (int j = 0; j < 3; j++) {
                    if (questionNum.contains(String.valueOf(curNum.charAt(j))) &&
                            questionNum.charAt(j) != curNum.charAt(j)) {
                        ballCount++;
                    }
                }
                if (strikeCount == strike && ballCount == ball) {
                    passCount++;
                }
            }
            if (passCount == N) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean checkNum(int n) {
        int[] count = new int[10];
        for (int i = 0; i < 3; i++) {
            int num = n % 10;
            if (num == 0) return false;
            count[num]++;
            if (count[num] > 1) return false;
            n /= 10;
        }
        return true;
    }

    public static class Question {
        String num;
        int strike;
        int ball;

        public Question(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
}