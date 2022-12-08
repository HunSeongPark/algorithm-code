import java.io.*;
import java.util.StringTokenizer;

public class B_11004 {

    static int N, K;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        input();
        quick_sort(0, N - 1);
        System.out.println(A[K - 1]);
        clear();
    }

    private static void quick_sort(int S, int E) {
        if (S < E) {
            int pivot = partition(S, E);
            if (pivot > K - 1) {
                quick_sort(S, pivot - 1);
            } else if (pivot < K - 1) {
                quick_sort(pivot + 1, E);
            }
        }
    }

    private static int partition(int S, int E) {
        if (S + 1 == E) {
            if (A[S] > A[E]) swap(S, E);
            return E;
        }
        int M = (S + E) / 2;
        swap(S, M);
        int i = S + 1;
        int j = E;
        int pivot = A[S];
        while (true) {
            while (i <= E && pivot > A[i]) {
                i++;
            }
            while (j >= S && pivot < A[j]) {
                j--;
            }

            if (i < j) {
                swap(i++, j--);
            } else {
                A[S] = A[j];
                A[j] = pivot;
                return j;
            }
        }
    }

    private static void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void clear() throws IOException {
        br.close();
        bw.close();
    }
}