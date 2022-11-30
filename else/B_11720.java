import java.util.Scanner;

/**
 * @author : Hunseong-Park
 * @date : 2022-11-30
 */
public class B_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        char[] cArr = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += cArr[i] - '0';
        }
        System.out.println(sum);
    }
}
