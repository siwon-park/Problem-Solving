// Gaaaaaaaaaarden (18809번)
import java.io.*;
import java.util.*;

public class Main {

    static int N, M, G, R; // 행, 열, 초록, 빨강
    static int MAX_FLOWER = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] map, modifiedMap;
    static ArrayList<Pair> candidates; // 배양액을 뿌릴 수 있는 곳

    static void backtrack(int rCnt, int gCnt, int s, Stack<Integer> stack) {
        if (rCnt == R && gCnt == G) { // R과 G개 모두 골랐으면
            ArrayList<Integer> tmpList = new ArrayList<>(stack);
            Queue<Pair> queue = new LinkedList<>();
            visited = new boolean[N][M];
            for (Integer num : tmpList) {
                Pair pair = candidates.get(num);
                queue.add(new Pair(pair.y, pair.x, modifiedMap[pair.y][pair.x]));
                visited[pair.y][pair.x] = true;
            }
            MAX_FLOWER = Math.max(bfs(queue), MAX_FLOWER); // bfs 함수를 실행하여 꽃의 최댓값을 찾음
            return;
        }
        for (int i = s; i < candidates.size(); i++) {
            if (rCnt < R) { // 해당 위치에 초록색을 배치함
                Pair pair = candidates.get(i);
                modifiedMap[pair.y][pair.x] = 3;
                stack.add(i);
                backtrack(rCnt + 1, gCnt, i + 1, stack);
                stack.pop();
                modifiedMap[pair.y][pair.x] = map[pair.y][pair.x];
            }
            if (gCnt < G) { // 해당 위치에 빨간색을 배치함
                Pair pair = candidates.get(i);
                modifiedMap[pair.y][pair.x] = -3;
                stack.add(i);
                backtrack(rCnt, gCnt + 1, i + 1, stack);
                stack.pop();
                modifiedMap[pair.y][pair.x] = map[pair.y][pair.x];
            }
        }
    }

    static int bfs(Queue<Pair> queue) {
        int[][] tmpMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmpMap[i][j] = modifiedMap[i][j];
            }
        }

        int flower = 0;
        while (!queue.isEmpty()) {
            Queue<Pair> nextQueue = new LinkedList<>(); // 다음 큐
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                if (tmpMap[pair.y][pair.x] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int ny = pair.y + dy[k];
                    int nx = pair.x + dx[k];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                    if (tmpMap[ny][nx] == 1 || tmpMap[ny][nx] == 2) {
                        nextQueue.add(new Pair(ny, nx, tmpMap[pair.y][pair.x]));
                    }
                }
            }
            while (!nextQueue.isEmpty()) {
                Pair pair = nextQueue.poll();
                if (tmpMap[pair.y][pair.x] == 1 || tmpMap[pair.y][pair.x] == 2) {
                    tmpMap[pair.y][pair.x] = pair.state;
                    queue.add(pair);
                } else if (tmpMap[pair.y][pair.x] + pair.state == 0) {
                    flower += 1;
                    tmpMap[pair.y][pair.x] = 0;
                }
            }

        }
        return flower;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        modifiedMap = new int[N][M];
        candidates = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                modifiedMap[i][j] = map[i][j];
                if (map[i][j] == 2) candidates.add(new Pair(i, j, 2));
            }
        }

        backtrack(0, 0, 0, new Stack<>());
        System.out.println(MAX_FLOWER);
    }
}

class Pair {
    int y;
    int x;
    int state;

    Pair(int y, int x, int state) {
        this.y = y;
        this.x = x;
        this.state = state;
    }
}