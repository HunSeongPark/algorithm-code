import java.io.*;

class B_12871
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String a = "";
        String b = "";
        int lcm = (s1.length() * s2.length()) / GCD(s1.length(), s2.length());

        for (int i = 0; i < lcm / s1.length(); i++) {
            a += s1;
        }
        for (int i = 0; i < lcm / s2.length(); i++) {
            b += s2;
        }
        if (a.compareTo(b) == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static int GCD(int n1, int n2) {
        if (n2 == 0) return n1;
        return GCD(n2, n1 % n2);
    }
}