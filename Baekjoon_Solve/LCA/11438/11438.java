// LCA 2 (11438번)
import java.io.*;
import java.util.*;

public class Main {

    /*
    * 깊이를 기록하는 함수
    * */
    static void setDepth(int cur, int d) {
        depth[cur] = d;
        for (int i = 0; i < graph.get(cur).size(); i++) {
            int nxt = graph.get(cur).get(i);
            if (depth[nxt] == -1) {
                parent[nxt][0] = cur;
                setDepth(nxt, d + 1);
            }
        }
    }

    /*
    * 부모 배열(희소 배열)을 만드는 함수
    * */
    static void setParent() {
        parent[1][0] = 1; // 1번의 조상은 1
        for (int k = 0; k < MAX - 1; k++) {
            for (int n = 1; n < N + 1; n++) {
                if (parent[n][k] != -1) parent[n][k + 1] = parent[parent[n][k]][k];
            }
        }
    }

    /*
    * 최소 공통 조상(lca)를 찾는 함수
    * */
    static int findLCA(int a, int b) {
        // a가 더 깊도록 설정 -> depth[a] >= depth[b]를 만족시키기 위함
        if (depth[a] < depth[b]) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        // 깊이 차를 없애면서 이동
        int diff = depth[a] - depth[b];
        for (int i = 0; diff > 0; i++) {
            if (diff % 2 == 1) a = parent[a][i];
            diff /= 2;
        }
        
        // a와 b의 부모가 같다면 a(또는 b)를 리턴
        if (a == b) return a;
        for (int i = MAX - 1; i >= 0; i--) {
            if (parent[a][i] != -1 && parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }

    static int N, M; // 정점의 수, 쿼리의 수
    static final int MAX = 21; // 2 ^ 21 >= 100만
    static int[] depth; // 정점의 깊이(루트의 깊이: 0, 배열의 초깃값은 -1)
    static int[][] parent; // 정점 n의 2 ^ k번째 부모, 조상이 없는 경우는 -1
    static ArrayList<ArrayList<Integer>> graph; // 그래프

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());

        int u, v;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        parent = new int[N + 1][MAX];
        depth = new int[N + 1];
        for (int i = 0; i < N + 1; i++) Arrays.fill(parent[i], -1);
        Arrays.fill(depth, -1);

        setDepth(1, 0); // 1번 정점의 깊이는 0
        setParent();

        M = Integer.parseInt(br.readLine());
        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bw.write(findLCA(a, b) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}