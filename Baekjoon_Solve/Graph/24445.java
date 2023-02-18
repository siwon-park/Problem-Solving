// 알고리즘 수업 - 너비 우선 탐색 2 (24445번)
///////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/24445
  // BFS
  // 자바로 구현한 첫 BFS이다.
  // 단지 큐만 쓰면 될 줄 알았는데, 이 문제는 정렬이 필요해서 여러 가지 몰랐던 개념들을 새로 익힐 수 있었다.
  // 정렬 메서드를 오버라이드하는 방법은 꼭 익혀야 하는 것 같다.
  // 풀었던 간단한 BFS 문제를 자바로도 풀어봐야겠다.
///////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  static int N; // 노드의 수
  static int M; // 간선의 수
  static int R; // 시작 정점
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int[] order;

  public static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    int visitOrd = 1;
    order[start] = visitOrd;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int i=0; i<graph.get(cur).size(); i++) {
        int nxt = graph.get(cur).get(i);
        if (order[nxt] == 0) {
          order[nxt] = ++visitOrd;
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
    
    order = new int[N+1];

    for (int i=0; i<N+1; i++){
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

    bfs(R);
    
    for (int i=1; i<N+1; i++) {
      System.out.println(order[i]);
    }
    br.close();
  }
}
