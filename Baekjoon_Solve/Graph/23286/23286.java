// 허들 넘기 (23286번)
import java.io.*;
import java.util.*;

public class Main {

    static void floyd() {
        for (int k = 1; k < N + 1; k++) {
            for (int a = 1; a < N + 1; a++) {
                for (int b = 1; b < N + 1; b++) {
                    if (graph[a][k] == -1 || graph[k][b] == -1) continue;
                    int cost = Math.max(graph[a][k], graph[k][b]);
                    if (graph[a][b] == -1) graph[a][b] = cost;
                    else graph[a][b] = Math.min(cost, graph[a][b]);
                }
            }
        }
    }

    static int N, M, T; // 정점의 수, 간선의 수, 연습 정보
    static int[][] graph; // 격자판

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) graph[i][j] = -1;
        }

        int u, v, h;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            graph[u][v] = h; // u -> v로 가는데 h만큼 비용이 듦
        }

        floyd(); // 플로이드

        int s, t;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            bw.write(graph[s][t] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}