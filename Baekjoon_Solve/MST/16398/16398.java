import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Pair implements Comparable<Pair>{
        int a;
        int b;
        int c; // 비용
        Pair(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.c, o.c);
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int pa = find(a); // a의 부모
        int pb = find(b); // b의 부모
        if (pa < pb) {
            parent[b] = pa;
            parent[pb] = pa;
        } else {
            parent[a] = pb;
            parent[pa] = pb;
        }
    }

    static int N; // 행성의 수
    static int E; // 연결한 간선의 수 // 최소 스패닝 트리의 간선 수는 N - 1개
    static int[] parent; // 부모 배열
    static int[][] graph; // 행성 간 연결 비용 그래프
    static long ans; // 최소 관리 비용 // C가 최대 1억, N이 최대 1000이므로 오버 플로우가 날 수도 있어 long으로 선언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        parent = new int[N + 1]; // N + 1 크기로 부모 배열 초기화
        ArrayList<Pair> pairs = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            parent[i + 1] = i + 1; // 자기 자신을 부모로 초기화
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (i < j) {
                    pairs.add(new Pair(i + 1, j + 1, graph[i][j]));
                }
            }
        }

        pairs.sort(Pair::compareTo); // 연결 비용을 기준으로 정렬
        for (Pair pair : pairs) {
            int a = pair.a;
            int b = pair.b;
            int c = pair.c;
            if (find(a) != find(b)) {
                union(a, b);
                ans += c;
                E += 1;
                if (E == N - 1) { // 간선 수가 N - 1개이면 break
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
