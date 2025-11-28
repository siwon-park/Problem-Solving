// 원숭이도 나무에서 떨어진다 (33872번)
import java.io.*;
import java.util.*;

public class Main {

    static int N, H, S, E, ans;
    static int[] B, K, visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()) - 1;
        E = Integer.parseInt(st.nextToken()) - 1;
        B = new int[N];
        K = new int[N];
        visited = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) K[i] = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        ans = -1;
        visited[S] = 1; // 제일 처음 방문한다고 했으므로 1로 시작
        backtrack(S, H, B[S]); // S에서 시작하므로 B[S]개를 얻을 수 있다고 가정
        System.out.println(ans);
    }

    private static void backtrack(int cur, int h, int b) {
        if (h == 0) {
            if (cur == E) ans = Math.max(ans, b);
            return;
        }
        for (int nxt: graph[cur]) {
            if (K[nxt] == 1 || visited[nxt] == 2) continue; // 방문 불가
            if (visited[nxt] == 0) {
                visited[nxt] = 1;
                backtrack(nxt, h - 1, b + B[nxt]);
                visited[nxt] = 0;
            } else {
                visited[nxt] = 2;
                backtrack(nxt, h - 1, b);
                visited[nxt] = 1;
            }
        }
    }
}

