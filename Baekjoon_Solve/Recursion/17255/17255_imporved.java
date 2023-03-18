import java.io.*;
import java.util.HashSet;


public class Main {

    static void backtrack(String route, int l, int r) {
        if (l - 1 < 0 && r + 1 >= M) {
            if(!hashSet.contains(route)) {
                hashSet.add(route);
                ans += 1;
            }
            return;
        }
        if (l - 1 >= 0) backtrack(route + line.charAt(l - 1) + route, l - 1, r);
        if (r + 1 < M) backtrack(route + route + line.charAt(r + 1), l, r + 1);
    }

    static String line;
    static int N, M, ans;
    static HashSet<String> hashSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        M = line.length();
        N = Integer.parseInt(line);

        hashSet = new HashSet<>();

        ans = 0;
        for (int i = 0; i < M; i++) backtrack(line.charAt(i) + "", i, i);

        System.out.println(ans);
    }
}