import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int a;
        int b;
        int c;
        Pair(int a, int c) {
            this.a = a;
            this.c = c;
        }

        Pair(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
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

    static int[] parent;
    static Pair[] X, Y, Z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        X = new Pair[N]; // X좌표 리스트
        Y = new Pair[N]; // Y좌표 리스트
        Z = new Pair[N]; // Z좌표 리스트

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            X[i] = new Pair(i, x);
            Y[i] = new Pair(i, y);
            Z[i] = new Pair(i, z);
        }

        // X, Y, Z를 정렬
        Arrays.sort(X, (o1, o2) -> { return Integer.compare(o1.c, o2.c);});
        Arrays.sort(Y, (o1, o2) -> { return Integer.compare(o1.c, o2.c);});
        Arrays.sort(Z, (o1, o2) -> { return Integer.compare(o1.c, o2.c);});

        // X, Y, Z 각각에 대해 간선을 구성하고 비용을 계산함
        ArrayList<Pair> edges = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            edges.add(new Pair(X[i].a, X[i + 1].a, Math.abs(X[i].c - X[i + 1].c)));
            edges.add(new Pair(Y[i].a, Y[i + 1].a, Math.abs(Y[i].c - Y[i + 1].c)));
            edges.add(new Pair(Z[i].a, Z[i + 1].a, Math.abs(Z[i].c - Z[i + 1].c)));
        }

        Collections.sort(edges, (Pair o1, Pair o2) -> {
           return Integer.compare(o1.c, o2.c);
        });

        long cost = 0L;
        int cnt = 0;
        for (Pair pair : edges) {
            if (find(pair.a) != find(pair.b)) {
                union(pair.a, pair.b);
                cost += pair.c;
                cnt++;
                if (cnt == N - 1) break;
            }
        }

        System.out.println(cost);
    }
}