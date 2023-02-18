// 알고리즘 수업 - 깊이 우선 탐색 6(24484번)
//////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/24484
  // DFS
  // 오름차순 정렬한다는 것 빼곤 지난번 깊이 우선 탐색 문제 시리즈와 크게 차이점이 없다.
  // 이제야 조금 자바의 DFS, BFS와 친숙해진듯하다...
//////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static int M;
  static int R;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static long[] visited;
  static long[] depth;
  static int ord = 1;

  public static void dfs(int cur, int d) {
    visited[cur] = ord++;
    depth[cur] = d;
    for (int i=0; i<graph.get(cur).size(); i++) {
      int nxt = graph.get(cur).get(i);
      if (visited[nxt] == 0) {
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

    visited = new long[N+1];
    depth = new long[N+1];
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
      Collections.sort(graph.get(i), Collections.reverseOrder());
    }

    dfs(R, 0);
    // System.out.println(Arrays.toString(visited));
    // System.out.println(Arrays.toString(depth));
    long ret = 0L;
    for (int i=1; i<N+1; i++) {
      ret += (visited[i]*depth[i]);
    }
    System.out.println(ret);
  }
}
