import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int x;
        int y;
        int z;
        Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    static int M, N; // 집의 수, 길의 수
    static int[] parent; // 부모 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (M == 0 && N == 0) break;

            int ans = 0;
            Pair[] pairs = new Pair[N];
            parent = new int[M];
            for (int i = 0; i < M; i++) parent[i] = i;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                pairs[i] = new Pair(x, y, z);
                ans += z;
            }

            Arrays.sort(pairs, (Pair o1, Pair o2) -> {
               return Integer.compare(o1.z, o2.z);
            });

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                Pair pair = pairs[i];
                if (find(pair.x) != find(pair.y)) {
                    union(pair.x, pair.y);
                    ans -= pair.z;
                    cnt++;
                    if (cnt == M - 1) break;
                }
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
