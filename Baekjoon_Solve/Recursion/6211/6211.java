import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static void backtrack(int k, int s, int total) {
        if (total > C) return;
        ans = Math.max(ans, total);
        if (k == B) return;
        for (int i = s; i < B; i++) backtrack(k + 1, i + 1, total + arr[i]);
    }

    static int C, B, ans; // 최대 칼로리, 양동이 수, 정답
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[B];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) arr[i] = Integer.parseInt(st.nextToken());

        ans = 0;
        backtrack(0, 0, 0);
        System.out.println(ans);
    }
}