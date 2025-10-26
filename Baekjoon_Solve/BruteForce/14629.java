import java.io.*;

// 숫자 조각 (14629번)
public class Main {

    static long N, ans, diff;
    static boolean[] visited = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Long.parseLong(br.readLine());
        ans = Long.MAX_VALUE;
        diff = N;
        backtracking(0);
        System.out.println(ans);
    }

    private static void backtracking(long cur) {
        if (Math.abs(cur - N) < diff) {
            diff = Math.abs(cur - N);
            ans = cur;
        } else if (Math.abs(cur - N) == diff) {
            ans = Math.min(ans, cur);
        }
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(cur * 10 + i);
                visited[i] = false;
            }
        }
    }
}

