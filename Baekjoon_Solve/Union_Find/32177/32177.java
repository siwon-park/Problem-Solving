import java.io.*;
import java.util.*;

// 에어드롭 (32177번)
public class Main {

    static int N, T; // 친구 수, 버전 차이
    static double K; // 최대 유클리드 거리
    static int[] parent;
    static Pair[] pairs;

    static double euclidDistance(Pair p1, Pair p2) {
        int dist = (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
        return Math.sqrt(dist);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Double.parseDouble(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) parent[i] = i;

        pairs = new Pair[N + 1];
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        pairs[0] = new Pair(x, y, v, 1);

        int p;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(x, y, v, p);
            double k = euclidDistance(pairs[0], pairs[i]);
            if (Math.abs(pairs[0].v - pairs[i].v) <= T && k <= K) { // 버전 차이 T이하면서 유클리드 거리 K 이하
                union(0, i); // 0번(푸앙이)와 i번을 union
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                double k = euclidDistance(pairs[i], pairs[j]);
                if (Math.abs(pairs[i].v - pairs[j].v) <= T && k <= K) {
                    if (find(i) != find(j)) {
                        union(i, j);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (find(i) == 0 && pairs[i].p == 1) {
                sb.append(i).append(" ");
            }
        }

        if (sb.length() == 0) {
            bw.write("0");
        } else {
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Pair {
    int x, y, v, p;

    Pair(int x, int y, int v, int p) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.p = p;
    }
}
