import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int n = line.length();
        char last = line.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(last);
        for (int i = 1; i < n; i++) {
            char c = line.charAt(i);
            if (c == last) {
                continue;
            }
            sb.append(c);
            last = c;
        }

        System.out.println(sb);
    }
}
