import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static int dfs(int cur) {
        if (memo[cur] != 0) return memo[cur];
        int v = 1; // 방문할 수 있는 쉼터의 수
        for (int i = 0; i < graph.get(cur).size(); i++) {
            int nxt = graph.get(cur).get(i); // 연결된 노드
            if (height[nxt] > height[cur]) v = Math.max(v, 1 + dfs(nxt));
        }
        memo[cur] = v;
        return memo[cur];
    }

    static int N, M;
    static int[] height, memo;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 쉼터의 수
        M = Integer.parseInt(st.nextToken()); // 연결 간선 수
        height = new int[N + 1];
        memo = new int[N + 1];
        graph = new ArrayList<>();
        graph.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            if (memo[i] == 0) dfs(i);
            bw.write(memo[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}