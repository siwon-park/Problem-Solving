import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pair {
        int y;
        int x;
        int d;
        Pair(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

    static void bfs1(List<Pair> pairs) {
        Queue<Pair> queue = new LinkedList<>();
        for (Pair pair : pairs) {
            queue.add(pair);
            mDistance[pair.y][pair.x] = 0;
        }
        int ny, nx;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int k = 0; k < 4; k++) {
                ny = pair.y + dy[k];
                nx = pair.x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (mDistance[ny][nx] == -1 && pair.d < K) {
                    mDistance[ny][nx] = pair.d + 1;
                    queue.add(new Pair(ny, nx, pair.d + 1));
                }
            }
        }
    }

    static void bfs2(List<Pair> pairs) {
        Queue<Pair> queue = new LinkedList<>();
        for (Pair pair : pairs) {
            queue.add(pair);
            visited[pair.y][pair.x] = 0;
            mDistance[pair.y][pair.x] = -1; // 시루의 초기 위치가 마네킹이 도달할 수 있으면 움직일 수 있게 변경
        }
        int ny, nx;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (mDistance[pair.y][pair.x] != -1) continue; // 이동 불가능한 칸인 경우 continue
            for (int k = 0; k < 4; k++) {
                ny = pair.y + dy[k];
                nx = pair.x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[ny][nx] == -1 && graph[ny][nx] == 0) { // 다음 칸이 빈칸이면서 방문하지 않았으면
                    if (mDistance[ny][nx] == -1) { // 마네킹과의 거리가 K 초과이면 다음 칸으로 이동
                        visited[ny][nx] = pair.d + 1;
                        queue.add(new Pair(ny, nx, pair.d + 1));
                    } 
                }
            }
        }
    }

    static int N, M, K; // 세로, 가로, 떨어져야하는 거리
    static int[][] mDistance; // 마네킹의 거리 테이블
    static int[][] visited; // 최단거리 테이블
    static int[][] graph; // 격자판
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new int[N][M];
        mDistance = new int[N][M];

        ArrayList<Pair> siru = new ArrayList<>(); // 시루
        ArrayList<Pair> mannequins = new ArrayList<>(); // 마네킹
        ArrayList<Pair> chairs = new ArrayList<>(); // 의자
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                mDistance[i][j] = -1; // 마네킹의 거리 테이블을 -1로 초기화
                visited[i][j] = -1; // 방문 배열도 -1로 초기화
                if (graph[i][j] == 4) siru.add(new Pair(i, j, 0)); // 시루의 위치 기록
                else if (graph[i][j] == 3) mannequins.add(new Pair(i, j, 0)); // 마네킹의 위치들 기록
                else if (graph[i][j] == 2) { // 의자일 경우
                    chairs.add(new Pair(i, j, 0));
                    graph[i][j] = 0; // 의자를 방문할 수 있도록 의자의 위치를 수정
                }
            }
        }

        bfs1(mannequins);
        bfs2(siru);

        int minHp = Integer.MAX_VALUE;
        for (Pair chair :chairs) {
            if (visited[chair.y][chair.x] == -1) continue; // 의자까지 도달이 불가능하면 continue
            minHp = Math.min(visited[chair.y][chair.x], minHp);
        }
        minHp = (minHp == Integer.MAX_VALUE) ? -1 : minHp;
        System.out.println(minHp);
    }
}