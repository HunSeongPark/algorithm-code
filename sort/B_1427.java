import java.util.Scanner;

public class B_1427 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] A = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i = 0; i < A.length; i++) {
            int max = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[max] < A[j]) {
                    max = j;
                }
            }
            int temp = A[max];
            A[max] = A[i];
            A[i] = temp;
        }

        for (int j : A) {
            System.out.print(j);
        }
    }

}