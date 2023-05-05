// Line Friends (Small) (14588번)
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
    * 플로이드-워셜
    * */
    static int[][] floyd(int n, int[][] graph) {
        for (int k = 1; k < n + 1; k++) {
            for (int a = 1; a < n + 1; a++) {
                for (int b = 1; b < n + 1; b++) {
                    if (graph[a][k] == MAX || graph[k][b] == MAX) continue;
                    int cost = graph[a][k] + graph[k][b];
                    if (cost < graph[a][b]) graph[a][b] = cost;
                }
            }
        }
        return graph;
    }

    /*
    * 왼쪽, 오른쪽 범위 내 포함되어 있는지 확인하는 함수
    * */
    static boolean inRange(Pair o1, Pair o2) {
        if (o1.left <= o2.left && o2.left <= o1.right) return true;
        else if (o1.left <= o2.right && o2.right <= o1.right) return true;
        else if (o2.left <= o1.left && o1.left <= o2.right) return true;
        else if (o2.left <= o1.right && o1.right <= o2.right) return true;
        return false;
    }

    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 선분의 수
        int[][] graph = new int[N + 1][N + 1]; // 선분 간 연결 비용 관계
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(graph[i], MAX);
            graph[i][i] = 0;
        }

        Pair[] pairs = new Pair[N + 1]; // 선분 그룹
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(l, r);
        }

        int Q = Integer.parseInt(br.readLine()); // 쿼리의 수
        Pair[] queries = new Pair[Q];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queries[i] = new Pair(a, b);
        }

        // pairs 내 연결 관계 맵핑(O(N^2)) -> 1만큼 가까운 친구들
        for (int i = 1; i < N; i++) {
            Pair o1 = pairs[i];
            for (int j = i + 1; j < N + 1; j++) {
                Pair o2 = pairs[j];
                if (inRange(o1, o2)) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }

        floyd(N, graph);

        for (int i = 0; i < Q; i++) {
            Pair query = queries[i];
            int ret = graph[query.left][query.right];
            if (ret == MAX) ret = -1;
            bw.write(ret + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

class Pair {
    int left;
    int right;

    Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}