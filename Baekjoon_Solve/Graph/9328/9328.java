// 열쇠 (9328번)
import java.io.*;
import java.util.*;

public class Main {

    static int bfs(Queue<Pair> queue) {
        int count = 0; // 문서의 개수
        Queue<Pair>[] queues = new Queue[26]; // 각 키(문)에 대한 큐 배열
        for (int i = 0; i < 26; i++) queues[i] = new LinkedList<>();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (count == MAX) break; // 이미 문서를 다 찾았으면 탐색할 필요 없음
            for (int k = 0; k < 4; k++) {
                int ny = pair.y + dy[k];
                int nx = pair.x + dx[k];
                if (ny < 0 || ny >= H + 2 || nx < 0 || nx >= W + 2) continue;
                if (!visited[ny][nx]) { // 방문하지 않은 곳일 경우 방문
                    if ('A' <= graph[ny][nx] && graph[ny][nx] <= 'Z') { // 문일 경우 -> 큐 배열에 삽입
                        visited[ny][nx] = true;
                        int idx = graph[ny][nx] - 65;
                        if (keys[idx]) queue.add(new Pair(ny, nx)); // 키를 가지고 있으면 큐에 삽입
                        else queues[idx].add(new Pair(ny, nx)); // 키가 없으면 일단 큐 배열에 삽입 후 대기
                    }
                    else if ('a' <= graph[ny][nx] && graph[ny][nx] <= 'z') { // 열쇠일 경우 획득
                        visited[ny][nx] = true;
                        int idx = graph[ny][nx] - 97;
                        queue.add(new Pair(ny, nx)); // 중요!) 획득했던 안했던 다음 위치로 이동은 해야함
                        if (!keys[idx]) { // 획득하지 않았던 키면
                            keys[idx] = true; // 키를 획득하고 해당 키에 해당 하는 대기 중인 큐 배열을 큐에 삽입
                            while (!queues[idx].isEmpty()) queue.add(queues[idx].poll());
                        }
                    }
                    else if (graph[ny][nx] == '$') { // 문서일 경우 획득 -> 먼저 도착하는 쪽이 획득 가능
                        count += 1;
                        visited[ny][nx] = true;
                        graph[ny][nx] = '.'; // 문서를 획득했으니 빈 공간으로 변경
                        queue.add(new Pair(ny, nx));
                    }
                    else if (graph[ny][nx] == '.') { // 빈 칸이면 이동
                        visited[ny][nx] = true;
                        queue.add(new Pair(ny, nx));
                    }
                }
            }
        }
        return count;
    }
    static int T, H, W, MAX; // 테스트 케이스 수, 높이, 너비, 최대 훔칠 수 있는 문서의 개수
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Character[][] graph; // 격자판
    static boolean[] keys; // 키 배열
    static boolean[][] visited; // 방문 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            // 그래프에 대한 입력
            MAX = 0;
            graph = new Character[H + 2][W + 2]; // 초기엔 빌딩의 밖에 있으므로 H + 2 x W + 2로 선언
            for (int i = 0; i < W + 2; i++) {
                graph[0][i] = '.';
                graph[H + 1][i] = '.';
            }

            for (int i = 1; i < H + 1; i++) {
                String line = br.readLine();
                for (int j = 1; j < W + 1; j++) {
                    graph[i][j] = line.charAt(j - 1);
                    if (graph[i][j] == '$') MAX++;
                }
                graph[i][0] = '.';
                graph[i][W + 1] = '.';
            }
            // 열쇠에 대한 입력
            String initKeys = br.readLine();
            keys = new boolean[26];
            if (!initKeys.equals("0")) {
                for (int i = 0; i < initKeys.length(); i++) {
                    keys[initKeys.charAt(i) - 97] = true;
                }
            }

            visited = new boolean[H + 2][W + 2];
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(0, 0));
            visited[0][0] = true;
            int ret = bfs(queue);
            bw.write(ret + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Pair {
    int y;
    int x;

    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}