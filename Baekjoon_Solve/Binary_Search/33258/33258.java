// 상현이의 수학 공부 대작전 (33258번)
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        L = Integer.parseInt(br.readLine());

        int ans = Integer.MAX_VALUE;
        int s = 0, e = ans;
        while (s <= e) {
            int mid = (s + e) / 2;
            long l = 0; // 최악의 경우 int 범위를 벗어날 수도 있어 long으로 선언
            for (int i = 0; i < N; i++) {
                if (mid >= arr[i]) l += mid;
                else l += (long) 2 * (mid - arr[i]);
            }
            if (l >= L) {
                ans = Math.min(ans, mid);
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        System.out.println(ans);
    }
}

