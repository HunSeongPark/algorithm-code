import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_16638
{

    static int N;
    static String[] input;
    static boolean[] bracket;
    static long answer = Long.MIN_VALUE;

    // TODO 1. 괄호 백트래킹으로 설정
    // TODO 2. 괄호 -> 곱하기 -> 플마 순으로 연산
    //   TODO 2-1. 플마 연산 시 마지막 연산결과가 result
    // TODO 3. max값 도출

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bracket = new boolean[N];
        input = new String[N];
        input = br.readLine().split("");
        setBracket(0);
        System.out.println(answer);
    }

    // TODO 1. 괄호 백트래킹으로 설정
    public static void setBracket(int idx) {
        if (idx == N - 1) {
            String[] copy = input.clone();
            // TODO 3. max값 도출
            answer = Math.max(answer, getResult(copy));
            return;
        }

        setBracket(idx + 2);
        if (idx == 0 || (idx >= 2 && !bracket[idx - 2])) {
            bracket[idx] = true;
            setBracket(idx + 2);
            bracket[idx] = false;
        }
    }

    // TODO 2. 괄호 -> 곱하기 -> 플마 순으로 연산
    public static long getResult(String[] copy) {
        opBracket(copy);
        opMultiply(copy);
        return opPlusAndMinus(copy);
    }

    public static void opBracket(String[] copy) {
        for (int i = 0; i < N; i++) {
            if (bracket[i]) {
                long op1 = Long.parseLong(copy[i]);
                long op2 = Long.parseLong(copy[i + 2]);
                String result = operation(copy[i + 1].charAt(0), op1, op2);
                copy[i] = result;
                copy[i + 1] = copy[i + 2] = null;
            }
        }
    }

    public static void opMultiply(String[] copy) {
        for (int i = 0; i < N; i++) {
            if (copy[i] != null && copy[i].equals("*")) {
                int left = i - 1;
                int right = i + 1;
                while (copy[left] == null) left--;
                while (copy[right] == null) right++;
                long op1 = Long.parseLong(copy[left]);
                long op2 = Long.parseLong(copy[right]);
                String result = operation('*', op1, op2);
                copy[i] = result;
                copy[left] = copy[right] = null;
            }
        }
    }

    // TODO 2-1. 플마 연산 시 마지막 연산결과가 result
    public static long opPlusAndMinus(String[] copy) {
        long ret = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (copy[i] != null && !copy[i].equals("+") && !copy[i].equals("-") && ret == Long.MAX_VALUE) {
                ret = Long.parseLong(copy[i]);
            }
            if (copy[i] != null && (copy[i].equals("+") || copy[i].equals("-"))) {
                int left = i - 1;
                int right = i + 1;
                while (copy[left] == null) left--;
                while (copy[right] == null) right++;
                long op1 = Long.parseLong(copy[left]);
                long op2 = Long.parseLong(copy[right]);
                String result = operation(copy[i].charAt(0), op1, op2);
                copy[i] = result;
                ret = Long.parseLong(result);
                copy[left] = copy[right] = null;
            }
        }
        return ret;
    }

    public static String operation(char operator, long op1, long op2) {
        if (operator == '+') {
            return String.valueOf(op1 + op2);
        } else if (operator == '-') {
            return String.valueOf(op1 - op2);
        }
        return String.valueOf(op1 * op2);
    }
}
