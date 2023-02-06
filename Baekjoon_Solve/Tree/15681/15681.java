import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static void makeTree(int cur, int p) { // 부모를 p로 가지는 노드 cur에 대해 트리를 구성하는 함수
        for (int i=0; i<graph.get(cur).size(); i++) {
            int nxt = graph.get(cur).get(i);
            if (nxt != p) { // 연결된 노드가 부모 노드가 아니면 트리로 구성하여 자식에 포함시킨다
                tree.get(cur).add(nxt); // cur의 자식으로 nxt를 추가
                parent[nxt] = cur; // cur를 nxt의 부모로 기록
                makeTree(nxt, cur); // nxt가 현재 노드로, cur은 부모가 됨
            }
        }
    }

    static int dfs(int cur) {
        if (subTree[cur] != 0) {
            return subTree[cur];
        }
        int ret = 1; // 현재 노드를 포함하여 서브 트리를 계산
        for (int i=0; i<tree.get(cur).size(); i++) { // tree.get(cur).size() -> 현재 노드와 연결된 자식 노드
            int nxt = tree.get(cur).get(i); // 자식 노드
            ret += dfs(nxt);;
        }
        subTree[cur] = ret;
        return subTree[cur];
    }

    static int N, R, Q;
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<ArrayList<Integer>> tree;
    static int[] subTree, parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드의 수
        R = Integer.parseInt(st.nextToken()); // 루트 노드 번호
        Q = Integer.parseInt(st.nextToken()); // 쿼리의 수
        subTree = new int[N + 1]; // 각 노드의 서브 트리의 노드 개수 배열
        parent = new int[N + 1]; // 각 노드의 부모 정보 배열
        visited = new boolean[N + 1]; // 각 노드의 부모 정보 배열
        graph = new ArrayList<>(); // 그래프(입력에 대한 그래프 구성)
        tree = new ArrayList<>(); // 트리(그래프를 통해 트리를 형성)

        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }

        // 트리 자료 구조이므로, N - 1개의 간선을 가진다
        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        makeTree(R, 0);

        dfs(R);

        // 쿼리
        for (int i=0; i<Q; i++) {
            int u = Integer.parseInt(br.readLine());
            bw.write(subTree[u] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}