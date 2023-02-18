// Cow Picnic (6207번)
/*
  문제: https://www.acmicpc.net/problem/6207
  DFS
  주어진 특정 노드들이 모두 도달할 수 있는 노드들의 개수를 찾는 문제이다.
  단방향 그래프로 주어져서 방문 체크할 필요 없이 count 배열에 기록만 하면 된다고 생각했다.
  물론 문제를 보면서 사이클 발생 가능성에 대해 고려는 했으나 언급이 되어 있지 않아 신경쓰지 않았는데,
  아니나 다를까 메모리 초과가 발생했다.
  그래서 노드별 dfs를 돌릴 때, 방문 배열을 초기화시켜서 방문 배열로 이미 방문했던 노드는 방문하지 않도록 체크하면서
  count 배열에 방문한 노드의 수들을 기록했다.
  최종적으로 count 배열에 기록된 숫자가 K이면 ans += 1을 하여 최종적으로 누적된 ans를 출력하였다.
*/
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static void dfs(int cur) {
        count[cur] += 1;
        visited[cur] = true;
        for (int i=0; i<graph.get(cur).size(); i++) {
            int nxt = graph.get(cur).get(i);
            if (!visited[nxt]) {
                dfs(nxt);
            }
        }
    }

    static int K, N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] count;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        count = new int[N + 1];

        int[] cow = new int[K];
        for (int i=0; i<K; i++) {
            cow[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        for (int i: cow) {
            visited = new boolean[N + 1];
            dfs(i);
        }

        int ans = 0;
        for (int i=1; i<N + 1; i++) {
            ans += (count[i] == K) ? 1 : 0;
        }

        System.out.println(ans);
    }
}
