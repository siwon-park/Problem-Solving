import java.io.*;
import java.util.*;


public class Main {

    // 깊이 우선 탐색을 통해서 각 노드별로 자식 수를 카운트함
    static int dfs(int cur, int[] child) {
        int n = 1;
        for (int i = 0; i < graph.get(cur).size(); i++) {
            int nxt = graph.get(cur).get(i);
            n += dfs(nxt, child);
        }
        child[cur] = n;
        return n;
    }

    static int N, M, cnt;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 노드의 개수

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] parent = new int[N];
        int[] child1 = new int[N]; // i번 노드의 자식 개수
        int[] child2 = new int[N];
        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            parent[i] = p; // i번 노드의 부모는 p이다.
            if (p == -1) {
                root = i;
                parent[i] = i; // i의 부모를 i로 함 => 루트 삭제 시 전부 삭제하기 위함
            }
            else {
                graph.get(p).add(i);
            }
        }

        M = Integer.parseInt(br.readLine());

        cnt = 0;
        dfs(root, child1); // root에서 출발하여 자식 카운트
        dfs(M, child2); // 삭제할 노드에서 출발하여 자식 카운트

        // 삭제할 노드의 부모에서도 자식 노드를 빼줌 => 자식 노드들을 뺐더니 리프가 되는 경우가 있기 때문
        child1[parent[M]] -= child2[M];

        // 전체 자식 배열에서 삭제할 노드와 부모-자식 관계인 노드들의 자식의 수를 빼줌
        for (int i = 0; i < N; i++) {
            child1[i] -= child2[i];
            if (child1[i] == 1) cnt += 1;
        }

        System.out.println(cnt);
    }
}