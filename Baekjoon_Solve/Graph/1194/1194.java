import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static class Pair {
        int y;
        int x;
        int d;
        int bit;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        Pair(int y, int x, int d, int bit) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.bit = bit;
        }
    }

    static void init() {
        int MAX = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 64; k ++) {
                    visited[i][j][k] = MAX;
                }
            }
        }
    }

    static int bfs(int r, int c) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r, c, 0, 0));
        visited[r][c][0] = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (graph[pair.y].charAt(pair.x) == '1') {
                return pair.d;
            }
            for (int k = 0; k < 4; k++) {
                int ny = pair.y + dy[k];
                int nx = pair.x + dx[k];
                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    char pos = graph[ny].charAt(nx);
                    if (pos != '#') {
                        if ('a' <= pos && pos <= 'f') { // 열쇠일 경우 -> 비트 변경
                            int nxtBit = pair.bit | (1 << (pos - 97));
                            if (pair.d + 1 < visited[ny][nx][nxtBit]) {
                                visited[ny][nx][nxtBit] = pair.d + 1;
                                queue.add(new Pair(ny, nx, pair.d + 1, nxtBit));
                            }
                        } else if ('A' <= pos && pos <= 'F') { // 문일 경우 -> 해당 비트에 해당하는 열쇠가 있으면 지날 수 있음
                            if ((pair.bit & (1 << (pos - 65))) > 0  && pair.d + 1 < visited[ny][nx][pair.bit]) {
                                visited[ny][nx][pair.bit] = pair.d + 1;
                                queue.add(new Pair(ny, nx, pair.d + 1, pair.bit));
                            }
                        } else { // 아무것도 아닐 경우 -> 그냥 지나감
                            if (pair.d + 1 < visited[ny][nx][pair.bit]) {
                                visited[ny][nx][pair.bit] = pair.d + 1;
                                queue.add(new Pair(ny, nx, pair.d + 1, pair.bit));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    static int N, M; // 미로의 세로, 가로
    static String[] graph; // 그래프
    static int mask; // 비트 마스크
    static int[][][] visited; // 최소거리 방문 배열
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static ArrayList<Pair> escape;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new String[N];
        escape = new ArrayList<>();
        visited = new int[N][M][(1 << 6)];

        // 출발 위치
        int sy = 0;
        int sx = 0;

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                if (graph[i].charAt(j) == '0') {
                    sy = i;
                    sx = j;
                } else if (graph[i].charAt(j) == '1') {
                    escape.add(new Pair(i, j));
                }
            }
        }

        init(); // visited 배열 초기화

        /*
        * 열쇠: 언제나 이동할 수 있다. 이 곳에 처음 들어가면 열쇠를 집는다. ('a', 'b', 'c', 'd', 'e', 'f')
        * 문: 대응하는 열쇠가 있을 때만 이동할 수 있다. ('A', 'B', 'C', 'D', 'E', 'F')
        * */
        int ret = bfs(sy, sx);
        System.out.println(ret);
    }
}