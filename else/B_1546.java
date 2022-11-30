import java.util.Scanner;

/**
 * @author : Hunseong-Park
 * @date : 2022-11-30
 */
public class B_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] score = new int[N];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
            if (max < score[i]) {
                max = score[i];
            }
            sum += score[i];
        }
        System.out.println(sum * 100.0 / max / N);
    }
}
