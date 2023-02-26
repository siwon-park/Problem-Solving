import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static void dfs(int cur) {
        for (int i = 0; i < graph.get(cur).size(); i++) {
            int nxt = graph.get(cur).get(i);
            cheers[nxt] += cheers[cur]; // 자식에게 자신이 받은 칭찬 수치를 그대로 전달
            dfs(nxt);
        }
    }

    static int N, M; // 회사의 직원 수, 칭찬 횟수
    static int[] cheers; // 각 사원별 칭찬받은 수치
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheers = new int[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i < N + 1; i++) {
            int p = Integer.parseInt(st.nextToken()); // 직속 상사
            graph.get(p).add(i); // p번의 직속 부하 i
        }

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            cheers[i] += w;
        }

        dfs(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(cheers[i] + " ");
        }
        System.out.println(sb);
    }
}