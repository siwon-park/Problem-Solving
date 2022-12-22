// ABCDE (13023번)
/*
  문제: https://www.acmicpc.net/problem/13023
  DFS
  dfs 돌릴 때, dfs 안에서 for 구문을 빠져나온 다음에 현재 위치에 대한 방문을 false로 초기화해줘야한다.
  친구 관계를 A -> B -> C -> D -> E와 같이 만들 수 있음에도 먼저 방문한 노드를 우선 체크해버려서
  다른 친구관계를 통해서 관계를 형성할 수 있는 경우를 체크하지 못하기 때문
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean flag;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static void dfs(int cur, int rel) {
        visited[cur] = true;
        if (flag) {
            return;
        }
        if (rel >= 4) {
            flag = true;
            return;
        }
        for (int i=0; i<graph.get(cur).size(); i++) {
            int nxt = graph.get(cur).get(i);
            if (!visited[nxt]) {
                dfs(nxt, rel + 1);
            }
        }
        visited[cur] = false; // 현재 위치 false 처리
    }

    static int check() {
        for (int i=0; i<N; i++) {
            visited = new boolean[N];
            dfs(i, 0);
            if (flag) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(check());

    }
}
