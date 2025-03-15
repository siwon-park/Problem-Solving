import java.io.*;
import java.util.*;

// Money Matters (5033번)
public class Main {

    static int N, M;
    static int[] parent, money;

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
            money[a] += money[b];
        }
        else {
            parent[a] = b;
            money[b] += money[a];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 친구 수
        M = Integer.parseInt(st.nextToken()); // 관계 수
        parent = new int[N];
        money = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            money[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (find(x) != find(y)) {
                union(x, y);
            }
        }

        boolean even = true; // 균등함
        int init = money[find(0)]; // 0번의 돈

        for (int i = 1; i < N; i++) {
            int p = find(i);
            if (init != money[p]) {
                even = false;
                break;
            }
        }

        if (even) {
            System.out.println("POSSIBLE");
        } else {
            System.out.println("IMPOSSIBLE");
        }

    }
}
