import java.io.*;
import java.util.StringTokenizer;

public class B_1541 {

    static String[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            String str = A[i];
            int sum = extractSum(str);
            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }
        System.out.println(result);
        clear();
    }

    private static int extractSum(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '+' && str.charAt(i) != '-') {
                int num = 0;
                while (i < str.length() && str.charAt(i) != '+' && str.charAt(i) != '-') {
                    num *= 10;
                    num += str.charAt(i) - '0';
                    i++;
                }
                result += num;
            }
        }
        return result;
    }

    private static void input() throws IOException {
        A = br.readLine().split("-");
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}