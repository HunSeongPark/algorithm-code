import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_25206 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double sum = 0;
        double total = 0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double n = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if (grade.equals("P")) {
                continue;
            }
            total += n;
            switch (grade) {
                case "A+" -> n *= 4.5;
                case "A0" -> n *= 4;
                case "B+" -> n *= 3.5;
                case "B0" -> n *= 3;
                case "C+" -> n *= 2.5;
                case "C0" -> n *= 2;
                case "D+" -> n *= 1.5;
                case "F" -> n = 0;
            }
            sum += n;
        }
        System.out.printf("%.6f", sum / total);
    }
}