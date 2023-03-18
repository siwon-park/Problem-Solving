import java.io.*;
import java.util.HashSet;


public class Main {

    static void backtrack(int k, String n, String route) {
        if (k == M) {
            if (Integer.parseInt(n) == N) hashSet.add(route);
            return;
        }
        for (int i = 0; i < M; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String s = line.charAt(i) + "";
                backtrack(k + 1, n + s, route + "-" + n + s);
                backtrack(k + 1, s + n, route + "-" + s + n);
                visited[i] = false;
            }
        }
    }

    static String line;
    static int N, M, ans;
    static HashSet<String> hashSet;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        M = line.length();
        N = Integer.parseInt(line);

        visited = new boolean[M];
        hashSet = new HashSet<>();

        backtrack(0, "", "");
        ans = hashSet.size();

        System.out.println(ans);
    }
}
