import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int u;
        int v;
        int w;
        Pair(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int N = R * C;
            parent = new int[N];
            for (int i = 0; i < N; i++) { // 부모 배열 초기화
                parent[i] = i;
            }

            ArrayList<Pair> pairs = new ArrayList<>();

            // R만큼 열 간 연결 정보를 입력 받음
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C - 1; j++) {
                    int w = Integer.parseInt(st.nextToken()); // 비용
                    int u = i * C + j; // 노드1
                    int v = u + 1; // 노드2(다음 열)
                    pairs.add(new Pair(u, v, w));
                }
            }

            // R - 1만큼 행 간 연결 정보를 입력 받음
            for (int i = 0; i < R - 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    int w = Integer.parseInt(st.nextToken()); // 비용
                    int u = i * C + j; // 노드1
                    int v = u + C; // 노드2(다음 행)
                    pairs.add(new Pair(u, v, w));
                }
            }

            Collections.sort(pairs, (Pair o1, Pair o2) -> Integer.compare(o1.w, o2.w)); // 비용이 낮은 순으로 정렬
            int ans = 0;
            for (Pair pair : pairs) {
                if (find(pair.u) != find(pair.v)) {
                    union(pair.u, pair.v);
                    ans += pair.w;
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}