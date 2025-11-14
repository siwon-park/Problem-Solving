// Bookshelf 2 (6148번)
import java.io.*;
import java.util.*;

public class Main {

    static int N, B;
    static int[] H;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        H = new int[N];
        for (int i = 0; i < N; i++) H[i] = Integer.parseInt(br.readLine());
        ans = B;
        backtrack(0, 0);
        System.out.println(ans);
    }

    private static void backtrack(int idx, int sum) {
        if (sum >= B) {
            ans = Math.min(ans, sum - B);
            return;
        }
        for (int i = idx; i < N; i++) backtrack(i + 1, sum + H[i]);
    }
}

