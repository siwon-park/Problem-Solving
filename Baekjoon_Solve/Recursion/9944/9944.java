import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static void backtrack(int r, int c, int k, int total, int cnt) {
        if (total == 0) { // 방문할 빈칸의 수가 0이면 최소 이동 횟수를 갱신
            ans = Math.min(ans, cnt);
            return;
        }
        visited[r][c] = true; // 방문 체크
        // 계속해서 같은 방향으로 가다가 벽을 만나거나 범위를 벗어나면 방향을 바꿈
        int nr = r + dy[k];
        int nc = c + dx[k];
        if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && graph[nr].charAt(nc) == '.') {
            backtrack(nr, nc, k, total - 1, cnt);
        } else {
            for (int w = 0; w < 4; w++) {
                if (w == k) continue;
                nr = r + dy[w];
                nc = c + dx[w];
                if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && graph[nr].charAt(nc) == '.') {
                    backtrack(nr, nc, w, total - 1, cnt + 1);
                }
            }
        }
        visited[r][c] = false; // 방문 체크 해제
        // 공이 더 이상 진행이 불가능하면 return
    }

    static int N, M, ans; // 완주해야할 보드의 세로, 가로 크기
    static int MAX = Integer.MAX_VALUE;
    static boolean[][] visited; // 방문 배열
    static String[] graph; // 격자판
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String line;
        int tc = 1;
        while ((line = br.readLine()) != null) { // EOF 처리
            st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new String[N];

            int total = 0;

            for (int i = 0; i < N; i++) {
                graph[i] = br.readLine();
                for (int j = 0; j < M; j++) {
                    if (graph[i].charAt(j) == '.') total++; // 빈 칸의 총 개수를 카운트
                }
            }

            ans = MAX;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i].charAt(j) == '.') {
                        for (int k = 0; k < 4; k++) {
                            visited = new boolean[N][M];
                            backtrack(i, j, k, total - 1, 1);
                        }
                    }
                }
            }

            if (total == 1) ans = 0; // total이 총 1개이면 공을 놓자마자 끝나므로 이동횟수는 0임(이동하면 1단계로 가정)
            bw.write("Case " + tc + ": " + (ans == MAX ? -1 : ans)); // 모든 빈 칸을 방문할 수 없으면 -1
            bw.write("\n");
            tc++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}