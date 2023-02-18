// 알고리즘 수업 - 깊이 우선 탐색 3(24481번)
///////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/24481
  // DFS
  // 이번엔 깊이우선탐색으로 방문된 깊이우선탐색 트리의 깊이를 구하는 문제이다.
  // 말이 거창하지 사실 dfs함수에 현재의 깊이 d를 인자로 넣어주면 된다.
  // 이 문제 시리즈가 자바 연습하기 참 좋은 것 같다.
///////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  static Integer[] visited;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

  public static void dfs(int cur, int d) {
    visited[cur] = d;
    for (int i=0; i<graph.get(cur).size(); i++) {
      int nxt = graph.get(cur).get(i);
      if (visited[nxt] == null) {
        dfs(nxt, d+1);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());
    visited = new Integer[N+1];

    for (int i=0; i<N+1; i++) {
      graph.add(new ArrayList<Integer>());
    }

    for (int i=0; i<M; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st2.nextToken());
      int v = Integer.parseInt(st2.nextToken());
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    for (int i=1; i<N+1; i++) {
      Collections.sort(graph.get(i));
    }

    dfs(R, 0);
    // System.out.println(graph);
    for (int i=1; i<N+1; i++) {
      int ret = (visited[i] == null) ? -1 : visited[i];
      System.out.println(ret);
    }
  }
}
