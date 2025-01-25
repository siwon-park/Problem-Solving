import java.io.*;
import java.util.*;

// OIJ (OIJ) (33163번)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            if (c == 'J') sb.append('O');
            else if (c == 'O') sb.append('I');
            else if (c == 'I') sb.append('J');
        }

        System.out.println(sb);

    }
}
