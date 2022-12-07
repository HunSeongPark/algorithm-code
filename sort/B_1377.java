import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1377 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        IdxElement[] A = new IdxElement[N];
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            A[i] = new IdxElement(value, i);
        }
        Arrays.sort(A);
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < A[i].index - i) {
                max = A[i].index - i;
            }
        }
        System.out.println(max + 1);
        br.close();
    }

    static class IdxElement implements Comparable<IdxElement> {
        int value;
        int index;

        public IdxElement(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(IdxElement o) {
            return this.value - o.value;
        }
    }

}