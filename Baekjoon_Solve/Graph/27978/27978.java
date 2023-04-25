import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int H, W; // 세로 길이, 가로 길이
    static int re, ce; // 도착 지점
    static final int MAX = Integer.MAX_VALUE;
    static String[] graph; // 격자판(. : 바다, # : 암초, * : 보물, K : 배)
    static int[][][] dist; // 방문 배열
    // dr1, dc1은 0, dr2, dc2는 1의 비용 소모
    static int[] dr1 = {-1, 0, 1};
    static int[] dc1 = {1, 1, 1};
    static int[] dr2 = {1, 1, 0, -1, -1};
    static int[] dc2 = {0, -1, -1, -1, 0};

    static int bfs(Deque<Pair> deque) {
        while (!deque.isEmpty()) {
            Pair pair = deque.pollFirst();
            if (dist[pair.r][pair.c][pair.e] < pair.d) continue;
            if (pair.r == re && pair.c == ce) return pair.d;
            int nr, nc;
            // 물살을 타고 감(연료 소모 없이 감)
            for (int k = 0; k < 3; k++) {
                nr = pair.r + dr1[k];
                nc = pair.c + dc1[k];
                if (inRange(nr, nc) && pair.d < dist[nr][nc][0]) {
                    deque.addFirst(new Pair(nr, nc, 0, pair.d));
                    dist[nr][nc][0] = pair.d;
                }
            }
            // 물살을 타지 않고 감(연료를 1 소모해서 감)
            for (int k = 0; k < 5; k++) {
                nr = pair.r + dr2[k];
                nc = pair.c + dc2[k];
                if (inRange(nr, nc) && pair.d + 1 < dist[nr][nc][1]) {
                    deque.addLast(new Pair(nr, nc, 1, pair.d + 1));
                    dist[nr][nc][1] = pair.d + 1;
                }
            }
        }
        return -1;
    }

    static boolean inRange(int nr, int nc) {
        if (nr < 0 || nr >= H || nc < 0 || nc >= W) return false;
        if (graph[nr].charAt(nc) == '#') return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Pair> deque = new LinkedList<>();
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        dist = new int[H][W][2];
        graph = new String[H];
        for (int i = 0; i < H; i++) {
            graph[i] = br.readLine();
            for (int j = 0; j < W; j++) {
                if (graph[i].charAt(j) == 'K') {
                    deque.add(new Pair(i, j, 0, 0)); // 출발 지점
                    dist[i][j][0] = 0;
                } else if (graph[i].charAt(j) == '*') {
                    re = i;
                    ce = j;
                }
                for (int k = 0; k < 2; k++) dist[i][j][k] = MAX;
            }
        }

        int ans = bfs(deque);
        System.out.println(ans);
    }
}

class Pair {
    int r;
    int c;
    int e; // 물살을 타고 왔냐, 엔진을 써서 왔냐 여부
    int d;

    Pair(int r, int c, int e, int d) {
        this.r = r;
        this.c = c;
        this.e = e;
        this.d = d;
    }
}