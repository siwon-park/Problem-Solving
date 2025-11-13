// Coin Row (5351번)
import java.io.*;
import java.util.*;

public class Main {

    static int ans = 0;
    static ArrayList<Integer> coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            ans = 0;
            coins = new ArrayList<>();
            while (st.hasMoreTokens()) {
                coins.add(Integer.parseInt(st.nextToken()));
            }

            backtracking(0, 0);
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int idx, int cur) {
        ans = Math.max(ans, cur);
        for (int i = idx; i < coins.size(); i++) {
            cur += coins.get(i);
            backtracking(i + 2, cur);
            cur -= coins.get(i);
        }
    }
}

