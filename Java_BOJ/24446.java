// 알고리즘 수업 - 너비 우선 탐색 3(24446번)
///////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/24446
  // BFS
  // 질문 게시판에 올려져 있는 반례가 아니었다면 아마 좀 많은 시간을 고생했을 것 같다.
  // 틀렸을 경우 출력초과를 받는 것 같다.
  // BFS탐색을 통한 방문 트리의 깊이를 구하는 문제이므로, 현재 큐의 길이만큼 요소를 뽑고, 그 길이만큼 뽑는 동안 트리의 깊이는 같아야한다.
///////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static int M;
  static int R;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static Integer[] visited;

  public static void bfs(int s) {
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    int d = 0; // 트리의 깊이
    visited[s] = d;
    d ++;
    while(!q.isEmpty()) {
      int n = q.size(); // 현재 큐의 길이
      // 큐의 길이만큼 큐에서 요소를 뽑는다 => 길이만큼 요소를 뽑는 동안 깊이는 같다.
      for (int j=0; j<n; j++) {
        int cur = q.poll();
        for (int i=0; i<graph.get(cur).size(); i++) {
          int nxt = graph.get(cur).get(i);
          if (visited[nxt] == null) {
            visited[nxt] = d;
            q.add(nxt);
          }
        }
      }
      d++; // 깊이를 갱신한다.
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    visited = new Integer[N+1];

    for (int i=0; i<N+1; i++) {
      graph.add(new ArrayList<Integer>());
    }

    // 그래프를 입력받음
    for (int i=0; i<M; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st2.nextToken());
      int v = Integer.parseInt(st2.nextToken());
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    
    bfs(R);
    for (int i=1; i<N+1; i++) {
      int depth = (visited[i] != null) ? visited[i] : -1; 
      System.out.println(depth);
    }
    // System.out.println(Arrays.toString(visited));
    br.close();
  }
}
