// 레이저 통신 (6087번)
/*
  문제: https://www.acmicpc.net/problem/6087
  다익스트라
  기존의 파이썬 풀이가 '시간초과' 판정을 받아서 java로 다시 풀었다.
  다음 위치로 이동한 다음에, 기존 방향 그대로 가는 경우와 거울을 설치하여 2갈래의 다른 방향으로 나가는 경우가 있다.
  현재 방향이 북쪽이나 남쪽이면, 거울을 설치하게 되면 서쪽과 동쪽 방향으로 이동 가능하다.
  현재 방향이 서쪽이나 동쪽이면, 거울을 설치하게 되면 북쪽과 남쪽 방향으로 이동 가능하다.
  방향을 꺾고 다음 위치로 이동하는 것이 아니라, 현재 방향 그대로 다음 위치로 일단 이동한 다음 거울을 설치할지 말지 결정하는 게 포인트다.
  방문 배열에는 거울을 설치한 개수를 기록하고, 다음 위치에 기록된 거울의 수가 현재 거울 수보다 크면, 다음 위치에 현재 거울 수를 기록하고 이동한다.
  만약 다음 위치에 거울을 설치한다고 하면, 다음 위치에 기록된 거울의 수가 현재 거울 수 + 1보다 커야 한다.
*/

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Pair implements Comparable<Pair> {
        int y;
        int x;
        int cnt; // 거울 수
        int w; // 직전 방향
        Pair(int y, int x, int cnt, int w) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.w = w;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }

    static int dijkstra(Pair[] pairs) {
        // 출발 지점
        int sy = pairs[0].y;
        int sx = pairs[0].x;
        
        // 종료 지점
        int ty = pairs[1].y;
        int tx = pairs[1].x;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Pair::compareTo);
        for (int k=0; k<4; k++) {
            visited[sy][sx][k] = 0;
            pq.add(new Pair(sy, sx, 0, k));
        }

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int y = pair.y;
            int x = pair.x;
            int cnt = pair.cnt;
            int w = pair.w;
            if (visited[y][x][w] < cnt) {
                continue;
            }
            if (y == ty && x == tx) {
                return cnt;
            }

            // 방향 전환하지 않는 경우
            int ny = y + dy[w];
            int nx = x + dx[w];
            if (0 <= ny && ny < H && 0 <= nx && nx < W && graph[ny].charAt(nx) != '*') {
                if (cnt < visited[ny][nx][w]) {
                    visited[ny][nx][w] = cnt; // 거울을 설치하지 않음
                    pq.add(new Pair(ny, nx, cnt, w));
                }
                int[] dir = deployMirror(w); // 다음 위치에 거울을 설치함
                for (int nw: dir) {
                    if (cnt + 1 < visited[ny][nx][nw]) {
                        visited[ny][nx][nw] = cnt + 1;
                        pq.add(new Pair(ny, nx, cnt + 1, nw));
                    }
                }
            }
        }
        return -1;
    }

    static int[] deployMirror(int w) { // 방향 전환 함수(2가지 방향을 반환)
        int[] dir = new int[2];
        if (w == 0 || w == 2) { // 현재 방향이 북쪽이나 남쪽이면 거울을 설치하면 동쪽, 서쪽방향으로 퍼짐
            dir[0] = 1;
            dir[1] = 3;
        } else { // 현재 방향이 동쪽이나 서쪽이면 거울을 설치하면 다음 방향은 북쪽, 남쪽임
            dir[0] = 0;
            dir[1] = 2;
        }
        return dir;
    }

    static int H, W;
    static int MAX = Integer.MAX_VALUE;
    static String[] graph;
    static int[][][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        graph = new String[H];
        visited = new int[H][W][4]; // 어느 방향에서 왔는지까지 방문 체크

        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                for (int k=0; k<4; k++) {
                    visited[i][j][k] = MAX; // MAX로 값 초기화
                }
            }
        }

        Pair[] pairs = new Pair[2];
        int p = 0;
        for (int i=0; i<H; i++) {
            graph[i] = br.readLine();
            for (int j=0; j<W; j++) {
                if (graph[i].charAt(j) == 'C') {
                    pairs[p] = new Pair(i, j, 0, 0);
                    p ++;
                }
            }
        }

        int ret = dijkstra(pairs);
        System.out.println(ret);

    }
}
