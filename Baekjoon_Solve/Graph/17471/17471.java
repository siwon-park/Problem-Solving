// 게리맨더링 (17471번)
import java.io.*;
import java.util.*;

public class Main {

    static void dfs(int k, HashSet<Integer> set1, HashSet<Integer> set2) {
        if (k == N + 1) {
            if (!set1.isEmpty() && !set2.isEmpty()) { // 두 선거구가 비어있지 않음
                int cnt1 = bfs(set1);
                int cnt2 = bfs(set2);
                if (cnt1 == 1 && cnt2 == 1) { // 선거구가 하나일 경우에만
                    int ret1 = count(set1);
                    int ret2 = count(set2);
                    MAX = Math.min(Math.abs(ret1 - ret2), MAX);
                }
            }
            return;
        }

        // 1번 선거구에 추가
        set1.add(k);
        dfs(k + 1, set1, set2);
        set1.remove(k);
        // 2번 선거구에 추가
        set2.add(k);
        dfs(k + 1, set1, set2);
        set2.remove(k);
    }

    static int bfs(HashSet<Integer> set) { // 연결 컴포넌트의 개수를 반환하는 bfs
        int cnt = 0;
        boolean[] visited = new boolean[N + 1];
        for (Integer i : set) visited[i] = true; // 현재 선거구만 방문하게 true로 체크함
        for (Integer i : set) {
            if (visited[i]) {
                visited[i] = false;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int j = 0; j < graph.get(cur).size(); j++) {
                        int nxt = graph.get(cur).get(j);
                        if (visited[nxt]) {
                            visited[nxt] = false;
                            queue.add(nxt);
                        }
                    }
                }
                cnt += 1;
            }
        }
        return cnt;
    }

    static int count(HashSet<Integer> set) {
        int ret = 0;
        for (Integer i : set) {
            ret += arr[i];
        }
        return ret;
    }

    static int MAX = Integer.MAX_VALUE;
    static int N; // 인구수
    static int[] arr; // 각 지역별 인구
    static ArrayList<ArrayList<Integer>> graph; // 그래프

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 현재 구역과 인접한 지역의 수
            for (int j = 0; j < m; j++) {
                int k = Integer.parseInt(st.nextToken());
                graph.get(i).add(k);
            }
        }

        dfs(1, new HashSet<>(), new HashSet<>());
        System.out.println((MAX == Integer.MAX_VALUE) ? -1 : MAX);
    }
}