import java.io.*;
import java.util.*;

// 마약수사대 (17220번)
public class Main {

    static int N, M;
    static boolean[] visited;
    static int[] parent;
    static ArrayList<Integer>[] graph;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            parent[i] = 0;
            graph[i] = new ArrayList<>();
        }

        int node = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken(); // 부모
            String b = st.nextToken(); // 자식
            if (!map.containsKey(a)) map.put(a, node++);
            if (!map.containsKey(b)) map.put(b, node++);
            int nodeA = map.get(a);
            int nodeB = map.get(b);
            parent[nodeB] += 1; // b의 부모
            graph[nodeA].add(nodeB); // a -> b
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 중간 공급자 수
        visited = new boolean[N];
        for (int i = 0; i < K; i++) {
            node = map.get(st.nextToken());
            visited[node] = true;
        }

        // 루트 노드이면서 방문하지 않은 노드에 대해서 dfs 수행
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (parent[i] == 0 && !visited[i]) {
                visited[i] = true;
                ans += dfs(i) - 1; // 루트 제외
            }
        }

        System.out.println(ans);

    }

    private static int dfs(int parent) {
        int cnt = 1;
        for (int child : graph[parent]) {
            if (!visited[child]) {
                visited[child] = true;
                cnt += dfs(child);
            }
        }
        return cnt;
    }

}
