// 알고리즘 수업 - 너비 우선 탐색 4(24447번)
//////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/24447
  // BFS
  // 오버플로우가 날 수도 있으니 long형으로 선언해야한다
  // 그외에는 주의할 사항 없음
//////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static int M;
  static int R;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static long[] visitied;
  static long[] depth;

  public static void bfs(int s) {
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    visitied[s] = 1; // 방문 배열
    depth[s] = 0; // 깊이 배열
    int ord = 1; // 방문 순서
    while(!q.isEmpty()) {
      int cur = q.poll();
      for (int i=0; i<graph.get(cur).size(); i++) {
        int nxt = graph.get(cur).get(i);
        if (visitied[nxt] == 0) {
          depth[nxt] = depth[cur] + 1;
          visitied[nxt] = ++ord;
          q.add(nxt);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    visitied = new long[N+1];
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
    // 정렬
    for (int i=1; i<N+1; i++) {
      Collections.sort(graph.get(i));
    }

    bfs(R);
    // System.out.println(Arrays.toString(visitied));
    // System.out.println(Arrays.toString(depth));
    Long ret = 0L;
    for (int i=1; i<N+1; i++) {
      ret += visitied[i]*depth[i];
    }
    System.out.println(ret);
  }
}
