// Milk Factory (17199번)
/*
  문제: https://www.acmicpc.net/problem/17199
  DFS
  모든 노드에서 각각 출발해서 i까지 도달할 수 있는 노드 i가 존재하는지 찾는 문제이다.
  단방향 그래프이며, 모든 노드에서 i까지 도달할 수 있다는 말은 역으로 i에서 출발하면 다른 모든 노드로 도착할 수 있다는 의미이다.
  따라서 a to b로 주어지는 노드 간 연결을 b to a로 연결하여 DFS를 통해서 문제를 해결하면 된다.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static void dfs(int cur) {
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        cnt += 1;
        for (int j=0; j<graph.get(cur).size(); j++) {
            int nxt = graph.get(cur).get(j);
            dfs(nxt);
        }
    }

    static int N, cnt;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a); // a to b -> b to a로 연결함
        }

        int ans = Integer.MAX_VALUE;
        for (int i=N; i>0; i--) {
            visited = new boolean[N + 1];
            cnt = 0;
            dfs(i);
            if (cnt == N) {
                ans = Math.min(ans, i);
            }
        }

        System.out.println((ans != Integer.MAX_VALUE) ? ans : -1);

    }
}
