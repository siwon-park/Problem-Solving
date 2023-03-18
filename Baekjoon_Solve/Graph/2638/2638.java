import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static class Pair {
        int y;
        int x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int bfs() {
        int time = 0; // 치즈가 다 녹는데 걸리는 시간
        int[][] faced = new int[N][M]; // 마주한 횟수
        Queue<Pair> air = new LinkedList<>();
        air.add(new Pair(0, 0)); // 가장 자리는 공기
        faced[0][0] = 1;
        while (true) {
            Queue<Pair> nextAir = new LinkedList<>(); // 다음 공기
            while (!air.isEmpty()) {
                Pair pair = air.poll();
                for (int k = 0; k < 4; k++) {
                    int ny = pair.y + dy[k];
                    int nx = pair.x + dx[k];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                    if (graph[ny][nx] == 0 && faced[ny][nx] == 0) { // 만약 공기면서, 처음 마주하는 곳이면 '현재' 공기큐에 삽입
                        air.add(new Pair(ny, nx));
                        faced[ny][nx] += 1;
                    } else if (graph[ny][nx] == 1) { // 만약 치즈면
                        if (faced[ny][nx] == 1) { // 방문 기록이 이미 1이면 2로 만들고 '다음' 공기큐에 삽입
                            faced[ny][nx] = 2;
                            nextAir.add(new Pair(ny, nx));
                        } else if (faced[ny][nx] < 1) { // 방문 기록이 1보다 작으면 방문 기록을 증가시킴
                            faced[ny][nx] += 1;
                        }
                    }
                }
            }
            
            air = nextAir; // 다음 공기
            if (air.isEmpty()) break;
            time += 1;
        }
        return time;
    }

    static int N, M; // N x M
    static int[][] graph;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int t = bfs();
        System.out.println(t);
    }
}