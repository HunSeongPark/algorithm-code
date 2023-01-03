package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 1;
        int min = Integer.MAX_VALUE;
        if (A[0] >= S) {
            System.out.println(1);
            return;
        }
        int sum = 0;
        while (end < N && start <= end) {
            if (sum >= S) {
                min = Math.min(min, end - start + 1);
                sum -= A[start];
                start++;
            } else {
                end++;
                if (end < N) {
                    sum += A[end];
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}