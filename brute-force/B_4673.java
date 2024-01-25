public class B_4673 {

    static int[] arr = new int[10001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        for (int i = 0; i <= 10000; i++) {
            int d = d(i);
            if (d <= 10000) {
                arr[d(i)] = -1;
            }
        }
        for (int i = 0; i <= 10000; i++) {
            if (arr[i] != -1) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int d(int i) {
        int a = i / 1000;
        int b = (i % 1000) / 100;
        int c = (i % 100) / 10;
        int d = i % 10;
        return i + a + b + c + d;
    }
}