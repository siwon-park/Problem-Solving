import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static class Pair {
        int y; // y좌표
        int x; // x좌표
        int d; // 움직인 거리
        int k; // 마지막 방향
        int bit; // 선물 배달 상태 비트
        Pair(int y, int x, int d, int k, int bit) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.k = k;
            this.bit = bit;
        }
    }

    /*
    * bfs함수
    * 모든 선물을 배달하는데 걸리는 최소 시간을 반환
    * 불가능할 경우 -1을 반환
    * */
    static int bfs(int sy, int sx, int delv) {
        int ans = MAX; // 최단 거리
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sy, sx, 0, -1, delv));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.bit == bit) { // 선물을 다 배달했으면 더 이상 탐색할 필요 없음
                ans = Math.min(ans, pair.d);
                continue;
            }
            for (int k=0; k<4; k++) {
                if (k == pair.k) continue; // 마지막에 이동한 방향과 같으면 continue
                int ny = pair.y + dy[k];
                int nx = pair.x + dx[k];
                if (0 <= ny && ny < N && 0 <= nx && nx < M && graph[ny][nx] != '#') {
                    if (!visited[ny][nx][k][pair.bit]) {
                        if (graph[ny][nx] == 'A' || graph[ny][nx] == 'B') {
                            visited[ny][nx][k][pair.bit] = true;
                            int newBit = pair.bit | (1 << (graph[ny][nx] - 65));
                            queue.add(new Pair(ny, nx, pair.d + 1, k, newBit));
                        } else {
                            visited[ny][nx][k][pair.bit] = true;
                            queue.add(new Pair(ny, nx, pair.d + 1, k, pair.bit));
                        }
                    }
                }
            }
        }
        return ans == MAX ? -1 : ans;
    }
    
    static int N, M; // 세로 크기, 가로 크기
    static char[][] graph; // 격자판
    static boolean[][][][] visited; // 방문배열
    static int MAX = Integer.MAX_VALUE;
    static int bit = (1 << 2) - 1; // 비트 (선물 2개를 다 선물하면 비트는 11이 됨)
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        visited = new boolean[N][M][4][bit];

        int sy = 0;
        int sx = 0;
        char present = 'A';
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                graph[i][j] = line.charAt(j);
                if (graph[i][j] == 'S') {
                    sy = i;
                    sx = j;
                } else if (graph[i][j] == 'C') {
                    graph[i][j] = present;
                    present = 'B';
                }
            }
        }

        int ans = bfs(sy, sx, 0);
        System.out.println(ans);
    }
}