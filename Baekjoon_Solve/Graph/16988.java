// Baaaaaaaaaduk2 (Easy) (16988번)
///////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/16988
  // BFS
  // 이 문제를 풀면서 자바를 더 공부해야겠다는 생각이 든다.
  // 객체의 복사(얕은 복사, 깊은 복사)에 대해 공부해야겠다.
  // 파이썬에서는 그냥 잘 됐던 것 같은데, 왜 이게 얕은 복사가 되어서 재귀가 끝났을 때 ArrayList가 초기화되는건지 모르겠다...
  // 아직 자바는 기초가 많이 약하다
///////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pair {
        int y;
        int x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void comb(int k, int s, Stack<Pair> arr) {
        if (k == 2) {
            Stack<Pair> copied = new Stack<>();
            copied.add(arr.get(0));
            copied.add(arr.get(1));
            cmblst.add(copied); // 그냥 arr를 add 해주니까 얕은 복사가 되어 재귀호출 종료 후 cmblst가 초기화됨
            return;
        }
        for (int i=s; i<K; i++) {
            arr.add(cand.get(i));
            comb(k + 1, i + 1, arr);
            arr.pop();
        }
    }


    static int bfs() {
        int TOTAL = 0;
        boolean[][] visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {

                if (graph[i][j] == 2 && !visited[i][j]) {
                    visited[i][j] = true;
                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(i, j));
                    boolean escapable = false;
                    int cnt = 1;

                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        int y = pair.y;
                        int x = pair.x;
                        for (int k=0; k<4; k++) {
                            int ny = y + dy[k];
                            int nx = x + dx[k];
                            if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx]) {
                                if (graph[ny][nx] == 0) {
                                    escapable = true;
                                } else if (graph[ny][nx] == 2) {
                                    queue.add(new Pair(ny, nx));
                                    visited[ny][nx] = true;
                                    cnt += 1;
                                }
                            }
                        }
                    }

                    if (!escapable) {
                        TOTAL += cnt;
                    }
                }
            }
        }

        return TOTAL;
    }

    static int[][] graph;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N;
    static int M;
    static int K;
    static ArrayList<Pair> cand = new ArrayList<>(); // 0을 넣을 수 있는 후보군
    static ArrayList<Stack<Pair>> cmblst = new ArrayList<>(); // 조합 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for (int i=0; i<N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(tmp[j]);
                if (graph[i][j] == 0) {
                    cand.add(new Pair(i, j));
                }
            }
        }

        K = cand.size();

        comb(0, 0, new Stack<>());

        int max_catch = 0;
        int L = cmblst.size();
        for (int l=0; l<L; l++) {
            Stack<Pair> lst = cmblst.get(l);
            Pair pair1 = lst.pop();
            Pair pair2 = lst.pop();
            int y1 = pair1.y;
            int x1 = pair1.x;
            int y2 = pair2.y;
            int x2 = pair2.x;
            graph[y1][x1] = 1;
            graph[y2][x2] = 1;
            int ret = bfs();
            max_catch = Math.max(max_catch, ret);
            graph[y1][x1] = 0;
            graph[y2][x2] = 0;
        }

        System.out.println(max_catch);
        br.close();
    }
}
