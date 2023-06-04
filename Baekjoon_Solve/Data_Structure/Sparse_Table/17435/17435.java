// 합성함수와 쿼리 (17435번)
import java.io.*;
import java.util.*;

public class Main {

    static final int LOG = 20; // 2 ^ 19 = 50만
    static int N;
    static int[][] parent;

    static void setParent() {
        for (int k = 0; k < LOG - 1; k++) {
            for (int n = 1; n < N + 1; n++)
                if (parent[n][k] != -1) parent[n][k + 1] = parent[parent[n][k]][k];
        }
    }

    static int findFunctionX(int n, int x) {
        for (int i = 0; n > 0; i++) {
            if (n % 2 == 1) x = parent[x][i];
            n /= 2;
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1][LOG];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(parent[i], -1);
            parent[i][0] = Integer.parseInt(st.nextToken());
        }

        setParent();

        int M = Integer.parseInt(br.readLine());
        int n, x;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            bw.write(findFunctionX(n, x) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}