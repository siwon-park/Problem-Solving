// String Permutation (14534번)
import java.io.*;
import java.util.*;

public class Main {

    static String S;
    static int L;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            S = br.readLine();
            L = S.length();
            visited = new boolean[L];
            System.out.println("Case # " + (t + 1) + ":");
            permute(new StringBuilder(), 0);
        }

    }

    private static void permute(StringBuilder sb, int k) {
        if (k == L) {
            System.out.println(sb.toString());
            return;
        }
        for (int i = 0; i < L; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(S.charAt(i));
                permute(sb, k + 1);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}

