import java.io.*;
import java.util.*;

// Family Tree (33243번)
public class Main {

    static int N;
    static int[] depth;
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static ArrayList<Integer>[] graph;

    static void dfs(int cur, int lvl) {
        depth[lvl] += 1;
        for (int i = 0; i < graph[cur].size(); i++) {
            int nxt = graph[cur].get(i);
            dfs(nxt, lvl + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        depth = new int[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        String root = br.readLine(); // 최상단 조상
        int cnt = 0;
        hashMap.put(root, cnt++);

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken(); // 부모
            st.nextToken(); // - 구분자
            String B = st.nextToken(); // 자식
            if (!hashMap.containsKey(A)) {
                hashMap.put(A, cnt++);
            }
            if (!hashMap.containsKey(B)) {
                hashMap.put(B, cnt++);
            }
            int a = hashMap.get(A);
            int b = hashMap.get(B);
            graph[a].add(b);
        }

        dfs(0, 0);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, depth[i]);
        }
        System.out.println(ans);
    }
}

