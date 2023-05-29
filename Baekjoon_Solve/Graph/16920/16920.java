// 확장 게임 (16920번)
import java.io.*;
import java.util.*;

public class Main {

    static void bfs() {
        boolean flag = true;
        while (flag) {
            for (int p = 1; p < P + 1; p++) {
                Queue<Pair> queue = queues[p]; // 현재 플레이어의 큐
                Queue<Pair> nextQueue = new LinkedList<>(); // 현재 플레이어의 다음 턴 큐
                while (!queue.isEmpty()) {
                    Pair pair = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int ny = pair.y + dy[k];
                        int nx = pair.x + dx[k];
                        if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                        if (graph[ny][nx] == 0) {
                            graph[ny][nx] = pair.p;
                            count[pair.p] += 1;
                            if (pair.s + 1 < S[pair.p]) queue.add(new Pair(ny, nx, pair.s + 1, pair.p));
                            else nextQueue.add(new Pair(ny, nx, 0, pair.p));
                        }
                    }
                }
                queues[p] = nextQueue;
            }
            flag = false;
            for (int p = 1; p < P + 1; p++) {
                if (!queues[p].isEmpty()) {
                    flag = true;
                    break;
                }
            }
        }
    }

    static int N, M, P; // 행, 열, 플레이어의 수
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] S, count; // 각 플레이어가 최대 펼칠 수 있는 칸의 수, 각 플레이어가 가진 성의 수
    static int[][] graph; // 그래프
    static Queue<Pair>[] queues; // 큐 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        S = new int[P + 1];
        count = new int[P + 1];
        queues = new Queue[P + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < P + 1; i++) {
            S[i] = Integer.parseInt(st.nextToken());
            queues[i] = new LinkedList<>();
        }

        graph = new int[N][M];
        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '.') graph[i][j] = 0;
                else if (line.charAt(j) == '#') graph[i][j] = -1;
                else {
                    graph[i][j] = Integer.parseInt(line.charAt(j) + "");
                    queues[graph[i][j]].add(new Pair(i, j, 0, graph[i][j]));
                    count[graph[i][j]] += 1; // 플레이어가 가지고 있는 성의 수를 증가
                }
            }
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < P + 1; i++) sb.append(count[i] + " ");
        System.out.println(sb);
    }
}

class Pair {
    int y;
    int x;
    int s; // 이동한 칸 수
    int p; // 플레이어

    Pair(int y, int x, int s, int p) {
        this.y = y;
        this.x = x;
        this.s = s;
        this.p = p;
    }
}