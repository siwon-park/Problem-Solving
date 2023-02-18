// 알고리즘 수업 - 깊이 우선 탐색 5(24483번)
////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/24483
  // DFS
  // 이번에는 방문 순서 * 깊이를 합산한 결과를 출력해야한다.
  // 처음에 그냥 문제를 대충 읽고 i * i번째 노드의 깊이로 계산했더니 틀렸습니다를 받았다.
  // 간단한 실수였지만, 잘못했으면 찾는데 오래 걸렸을 것이다. 
////////////////////////////////////////////////////////////////////////////

import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static int M;
  static int R;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static Long[] visited;
  static int[] check; // 방문 순서 배열
  static int s = 1;
  
  public static void dfs(int cur, long d) {
    visited[cur] = d;
    check[cur] = s++;
    for (int i=0; i<graph.get(cur).size(); i++) {
      int nxt = graph.get(cur).get(i);
      if (visited[nxt] == null) {
        dfs(nxt, d+1);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    
    visited = new Long[N+1];
    check = new int[N+1];
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
    long ret = 0L;
    for (int i=1; i<N+1; i++) {
      ret += (visited[i] != null) ? visited[i]*check[i] : 0;
    }
    System.out.println(ret);
    // System.out.println(Arrays.toString(visited));
    // System.out.println(Arrays.toString(check));
  }
}
