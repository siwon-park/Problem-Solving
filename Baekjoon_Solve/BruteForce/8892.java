// 팰린드롬 (8892번)
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            ArrayList<String> list = new ArrayList<>();
            for (int k = 0; k < K; k++) {
                String S = br.readLine();
                list.add(S);
            }

            int found = 0;
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < K; j++) {
                    if (i == j || found == 1) continue;
                    String str = list.get(i) + list.get(j);
                    StringBuilder sb = new StringBuilder(str);
                    String rev = sb.reverse().toString();
                    int m = str.length() / 2;
                    if (str.substring(0, m).equals(rev.substring(0, m))) {
                        System.out.println(str);
                        found = 1;
                        break;
                    }
                }
            }
            if (found == 0) {
                System.out.println("0");
            }
        }
    }
}

