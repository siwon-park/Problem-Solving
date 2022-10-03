// 이모티콘(14226번)
//////////////////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/14226
  // BFS
  // 분명히 논리대로 잘 짰다고 생각했는데, 어디서 틀렸는지 몰라서 정말 한참을 헤맸다.
  // 이차원의 배열 필요없이 1차원으로만 대소비교를 통해서 가능할 것이라 생각했던 게 큰 오산이었다.
  // 잘 생각해보면, 클립보드에 몇 개가 복사되어있는지도 정말 중요하다.
  // 왜냐하면, 특정 시점에 클립보드에 들어있는 양이 엄청 많은데 cur - 1로 이동하게 된다면, cur - 1인 지점에서 time이 최소가 아닐 수도 있다.
  // 그렇지만 클립보드에 들어있는 양이 많아서, 붙여넣기를 했을 때 더 빠른 시간 안에 특정 지점에 도착하는 경우가 생길 수도 있다.
  // 이점에서 유의해보면 클립보드에 들어있는 양도 고려해야하므로 2차원의 배열을 사용하는 것이다.
  // 그리고 cur == S 일 때 바로 return 해주는 것이 좋다. 왜냐하면 큐에 실제로 들어가는 경우의 수가 매우 많고, 어차피 BFS 탐색으로 도착한 지점은
  // 최소의 성질을 갖고 있기 때문이다.
//////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static class Pair {
        int cur;
        int clip;
        int time;

        Pair(int cur, int clip, int time) {
            this.cur = cur;
            this.clip = clip;
            this.time = time;
        }
    }

    static int bfs() {
        int[][] visited = new int[1001][1001];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 0, 0)); // 이모티콘 수, 클립 보드의 이모티콘 수, 시간
        
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int cur = pair.cur;
            int clip = pair.clip;
            int time = pair.time;

            if (cur == S) {
                return time;
            }
            // 1번 연산(이모티콘 복사)
            if (visited[cur][clip] == 0) {
                visited[cur][clip] = time;
                queue.add(new Pair(cur, cur, time + 1));
            }
            // 2번 연산(이모티콘 붙여 넣기)
            if (clip > 0 && cur + clip < 1001 && visited[cur + clip][clip] == 0) {
                queue.add(new Pair(cur + clip, clip, time + 1));
            }
            // 3번 연산(이모티콘 1개 삭제)
            if (0 <= cur - 1 && visited[cur - 1][clip] == 0) {
                queue.add(new Pair(cur - 1, clip, time + 1));
            }
        }
        return -1;
    }

    static int S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        int t = bfs();
        System.out.println(t);
    }
}
