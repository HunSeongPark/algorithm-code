package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_21921_sliding_window {
    static int N, X;
    static int[] arr;
    static int max, window, day = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 최초 윈도우 값 설정 (0 ~ X 합)
        for (int i = 0; i < X; i++) {
            max += arr[i];
            window += arr[i];
        }
        // 슬라이딩 윈도우 이용, 한 칸씩 윈도우 이동
        // 현재 윈도우 = 현재 윈도우 - 현재 윈도우 맨 첫번째 방문자수 + i일 방문자수
        for (int i = X; i < N; i++) {
            window -= arr[i - X];
            window += arr[i];
            if (window > max) {
                max = window;
                day = 1;
            } else if (window == max) {
                day++;
            }
        }
        System.out.println(max == 0 ? "SAD" : max);
        if (max > 0) System.out.println(day);
    }
}