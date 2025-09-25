import java.io.*;
import java.util.*;

// snails (34434번)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[1 << 15];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for (int i = 4; i < arr.length; i++) arr[i] = arr[i - 4] + arr[i - 3] + arr[i - 2] + arr[i - 1];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            boolean flag = true;
            while (st.hasMoreTokens()) {
                long num = Long.parseLong(st.nextToken());
                if (num != arr[idx]) {
                    flag = false;
                    break;
                }
                idx++;
            }
            if (flag) System.out.println("NAUTILUS");
            else System.out.println("SNAIL");
        }
    }
}

