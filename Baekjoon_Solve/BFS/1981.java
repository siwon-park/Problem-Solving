// 배열에서 이동 (1981번)
///////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/1981
  // BFS, 이분탐색
  // 이분탐색과 BFS를 둘 다 사용해야하는 문제이다.
  // 이분탐색으로 최대-최소의 값을 구한 다음에 0 ~ 200 사이 중 해당 값만큼 차이가 나는 s와 e를 최소, 최대로 하여
  // BFS 탐색을 돌려서 (0, 0)에서 (n-1, n-1)까지 탐색 가능한지 확인하는 것이다.
  // 탐색 가능하다면 break로 바로 빠져나온 다음에 mid 값을 줄여서 이분 탐색을 실시한다.
  // 처음에 3차원의 배열을 선언하고, visited[y좌표][x좌표][max값과 min값의 차이]로 방문을 체크했으나, 
  // 해당 풀이법은 1%에서 틀렸습니다를 받았다. 그 이유는 max - min <= mid일 경우에만 탐색을 하게 했는데,
  // 전체 경로를 기준으로 했을 때 max - min <= mid를 만족해야하는데 저렇게 탐색하는 것은 탐색 도중에 max - min <= mid를 찾는 것이므로
  // 탐색 도중 조건이 안 맞다면 전체적으로 봤을 때 조건에 부합하는데도 탐색을 하지 않기 때문에 잘못된 답을 도출할 수도 있다.
///////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = binarySearch();
        System.out.println(ans);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n;
    static int[][] graph;

    static class Pair {
        int y;
        int x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    static boolean bfs(int start, int end) {
        if (start > graph[0][0] || graph[0][0] > end) {
            return false;
        }
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.y == n - 1 && pair.x == n - 1) {
                return true;
            }
            for (int k=0; k<4; k++) {
                int ny = pair.y + dy[k];
                int nx = pair.x + dx[k];
                if (0 <= ny && ny < n && 0 <= nx && nx < n && !visited[ny][nx]) {
                    if (start <= graph[ny][nx] && graph[ny][nx] <= end) {
                        visited[ny][nx] = true;
                        queue.add(new Pair(ny, nx));
                    }
                }
            }
        }
        return false;
    }


    static int binarySearch() {
        int diff = 0;
        int s = 0;
        int e = 200;
        while (s <= e) {
            int mid = (s + e) / 2;
            boolean flag = false;

            for (int i=0; i+mid <=200; i++) {
                boolean ret = bfs(i, i+mid); // mid값의 차이로 가능한 경우의 수에 대해 bfs탐색
                if (ret) {
                    flag = true;
                    break;
                }
            }

            if (flag) { // mid 값의 차이로 bfs 탐색을 할 수 있으면 mid의 크기를 줄여서 탐색
                e = mid - 1;
                diff = mid;
            } else {
                s = mid + 1;
            }
        }
        return diff;
    }
}
