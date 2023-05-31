// 가운데에서 만나기 (21940번)
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void floyd() {
        for (int k = 1; k < N + 1; k++) {
            for (int a = 1; a < N + 1; a++) {
                for (int b = 1; b < N + 1; b++) {
                    if (graph[a][k] == MAX || graph[k][b] == MAX || a == b) continue;
                    int cost = graph[a][k] + graph[k][b];
                    graph[a][b] = Math.min(cost, graph[a][b]);
                }
            }
        }
    }

    static int N, M; // 도시의 수, 도로의 수
    static int[][] graph;
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(graph[i], MAX);
            graph[i][i] = 0;
        }

        int u, v, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[u][v] = w;
        }

        floyd();

        int K = Integer.parseInt(br.readLine());
        int[] dist = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        int a;

        for (int i = 0; i < K; i++) {
            a = Integer.parseInt(st.nextToken()); // 준영이와 친구들의 도시
            for (int x = 1; x < N + 1; x++) {
                if (graph[a][x] == MAX || graph[x][a] == MAX) dist[x] = MAX;
                else dist[x] = Math.max(dist[x], graph[a][x] + graph[x][a]);
            }
        }

        int min_val = MAX;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (dist[i] < min_val) {
                min_val = dist[i];
                sb = new StringBuilder();
                sb.append(i + " ");
            } else if (dist[i] == min_val) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }
}