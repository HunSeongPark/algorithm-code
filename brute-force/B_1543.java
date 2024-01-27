import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1543 {

    static String s, w;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        w = br.readLine();
        // 단어 길이가 문서 길이보다 길면 0
        if (w.length() > s.length()) {
            System.out.println(0);
            return;
        }
        int len = w.length();
        int end = w.length();
        // 문서의 끝에 도달할 때까지 반복
        while (end <= s.length()) {
            // end까지 단어 길이만큼 substring으로 슬라이싱
            String substring = s.substring(end - len, end);
            // substring이 단어와 일치한다면 count 증가 및 위치 다음 index로 이동
            if (substring.contains(w)) {
                count++;
                end = end + len;
            } else {
                end++;
            }
        }
        System.out.println(count);
    }
}