// Subset Sum (4132번)
import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = Integer.MAX_VALUE;
    static int N, M, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        for (int i = 0; i < M; i++) arr[i] = Integer.parseInt(br.readLine());
        ans = MAX;
        backtrack(0, 0);
        System.out.println(ans == MAX ? "IMPOSSIBLE" : ans);
    }

    private static void backtrack(int idx, int sum) {
        if (sum >= N) {
            ans = Math.min(ans, sum);
            return;
        }
        for (int i = idx; i < M; i++) {
            backtrack(i + 1, sum + arr[i]);
        }
    }

}
