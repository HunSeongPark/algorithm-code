package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_21921_prefix_sum {
    static int N, X;
    static int[] prefixSum;
    static int max, day = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        prefixSum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        // 누적합 배열 초기화
        // i번째 구간합 = 1 ~ i까지의 합 = i - 1번째 구간합 + i번째 값
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }
        // 1 ~ X 합 최댓값으로 초기화
        max = prefixSum[X];
        // 구간합 이용, i번째 ~ i + X - 1번째 구간합 계산
        // a ~ b까지 구간합 = prefix[b] - prefix[a - 1]
        for (int i = 2; i <= N - X + 1; i++) {
            int cur = prefixSum[i + X - 1] - prefixSum[i - 1];
            if (cur > max) {
                max = cur;
                day = 1;
            } else if (cur == max){
                day++;
            }
        }
        System.out.println(max == 0 ? "SAD" : max);
        if (max > 0) System.out.println(day);
    }
}