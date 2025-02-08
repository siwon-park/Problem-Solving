import java.io.*;
import java.util.*;

// Fence Planning (17197번)
public class Main {

    static final int MAX = 1_000_000_000;
    static int N, M;
    static int[] parent;
    static Pair[] pairs;

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

    static class Pair {
        int x, y;
        Pair() {
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Rectangle {
        int x1, y1, x2, y2;
        Rectangle() {
            this.x1 = MAX;
            this.y1 = MAX;
            this.x2 = -MAX;
            this.y2 = -MAX;
        }
        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) parent[i] = i;

        pairs = new Pair[N + 1];
        Rectangle[] rectangles = new Rectangle[N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            rectangles[i] = new Rectangle();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b); // if (find(a) != find(b)) 일 때만 합치지 않고, 일단 다 합침
            int pa = find(a);
            Rectangle r = rectangles[pa];
            r.x1 = Math.min(r.x1, Math.min(pairs[a].x, pairs[b].x));
            r.y1 = Math.min(r.y1, Math.min(pairs[a].y, pairs[b].y));
            r.x2 = Math.max(r.x2, Math.max(pairs[a].x, pairs[b].x));
            r.y2 = Math.max(r.y2, Math.max(pairs[a].y, pairs[b].y));
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < N + 1; i++) {
            int a = find(i);
            Rectangle r = rectangles[a];
            if (r.x1 == MAX || r.y1 == MAX || r.x2 == -MAX || r.y2 == -MAX) continue;
            ans = Math.min(ans, (r.x2 - r.x1 + r.y2 - r.y1) * 2);
        }

        System.out.println(ans);
    }
}

