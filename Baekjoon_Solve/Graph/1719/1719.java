import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int findPath(int s, int e) {
        // path[s][e] = k -> s에서 e로 가기 위해 k를 경유함
        // path[a][b] = k이니 a -> k -> b에서 역순 탐색을 하기 위해서 (path[a][k] = w은 a -> w -> k)
        // b = k를 넣는다. path[a][b] != 0인 동안 반복
        while(path[s][e] != 0) {
            int k = path[s][e];
            e = k;
        }
        return e;
    }

    static int N, M; // 집하장의 개수, 집하장 간 경로의 수
    static int[][] graph;
    static int[][] path; // 경로를 기록하기 위한 배열
    static int MAX = 10_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        path = new int[N + 1][N + 1];
        for (int i=1; i<N+1; i++) {
            for (int j=1; j<N+1; j++) {
                if (i == j) {
                    continue;
                }
                graph[i][j] = MAX; // 그래프의 값 MAX로 초기화
            }
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
            graph[b][a] = c;
        }

        for (int k=1; k<N+1; k++) {
            for (int a=1; a<N+1; a++) {
                for (int b=1; b<N+1; b++) {
                    if (graph[a][k] + graph[k][b] < graph[a][b]) {
                        graph[a][b] = graph[a][k] + graph[k][b];
                        path[a][b] = k; // a -> b로 가기위해 k를 경유함
                    }
                }
            }
        }

        for (int i=1; i<N+1; i++) {
            for (int j=1; j<N+1; j++) {
                if (i == j) {
                    bw.write("-" + " ");
                } else {
                    bw.write(findPath(i, j) + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}