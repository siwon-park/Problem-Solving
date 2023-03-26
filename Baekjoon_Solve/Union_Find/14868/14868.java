import java.io.*;
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

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    static int spread(Queue<Pair> queue, int left) {
        int t = 0; // 최소 햇수
        while (true) {
            if (left == 0) return t; // 남은 병합할 문명의 수가 0이면 t를 반환
            Queue<Pair> nextQueue = new LinkedList<>(); // 다음 큐
            while (!queue.isEmpty()) { // 큐가 비어있지 않은 동안
                Pair pair = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int ny = pair.y + dy[k];
                    int nx = pair.x + dx[k];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                    if (!visited[ny][nx] && map[ny][nx] == -1) { // -1인 지역일 경우 연결
                        visited[ny][nx] = true;
                        nextQueue.add(new Pair(ny, nx)); // 다음 큐에 삽입
                    } else if (map[ny][nx] != -1) { // 인접한 지역이 문명인 경우
                        // 현재 지역이 만약 -1이라면 인접 문명으로 변경
                        if (map[pair.y][pair.x] == -1) map[pair.y][pair.x] = map[ny][nx];
                        int a = map[pair.y][pair.x];
                        int b = map[ny][nx];
                        if (find(a) != find(b)) { // 다른 문명일 경우 병합 후 남은 영역 차감
                            union(a, b);
                            left -= 1;
                        }
                    }
                }
            }
            queue = nextQueue; // 현재 큐를 다음 큐로 갱신
            t += 1;
        }
    }

    static int N, K; // 지도의 크기, 문명 발상지 수
    static int[][] map; // 지도
    static int[] parent; // 부모 배열
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) map[i][j] = -1;
        }

        parent = new int[K];
        Queue<Pair> root = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            parent[i] = i;
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[y - 1][x - 1] = i; // 지도에 부모를 기록
            root.add(new Pair(y - 1, x - 1));
        }

        int left = K - 1; // 남은 결합할 문명 수
        for (int i = 0; i < K; i++) { // 서로 인접한 루트 문명에 대한 전처리
            Pair pair = root.poll(); // 큐에서 뽑음
            visited[pair.y][pair.x] = true;
            for (int k = 0; k < 4; k++) {
                int ny = pair.y + dy[k];
                int nx = pair.x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (map[ny][nx] != -1) { // 인접한 문명이 루트 문명이면 병합 후 결합 문명 수 감소
                    int a = map[pair.y][pair.x];
                    int b = map[ny][nx];
                    if (find(a) != find(b)) {
                        union(a, b);
                        left -= 1;
                        visited[ny][nx] = true;
                    }
                }
                root.add(new Pair(ny, nx)); // 루트 문명과 인접한 지역을 큐에 삽입
            }
        }

        int ret = spread(root, left);
        System.out.println(ret);
    }
}