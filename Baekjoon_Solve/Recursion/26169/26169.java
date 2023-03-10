import java.io.*;
import java.util.StringTokenizer;


public class Main {

    /*
    * 백트랙킹 함수
    * y, x: 좌표점, m: 이동 횟수, a: 먹은 사과의 개수
    * */
    static void backtrack(int y, int x, int m, int a) {
        if (m > 3) { // 3번 초과하여 이동시 return
            return;
        }
        int tmp = graph[y][x]; // 원래 칸 정보를 기록
        graph[y][x] = -1; // 현재 칸을 장애물 칸으로 만듦
        if (a >= 2) ans = 1; // 3번 이하의 이동으로 사과를 2개 이상 먹을 수 있으면 ans = 1로 바꿈
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (ny < 0 || ny > 4 || nx < 0 || nx > 4) continue;
            if (graph[ny][nx] == 0) backtrack(ny, nx, m + 1, a);
            else if (graph[ny][nx] == 1) backtrack(ny, nx, m + 1, a + 1);
        }
        graph[y][x] = tmp; // 칸 정보를 복구함
    }

    static int r, c; // 학생의 위치(항상 빈 칸)
    static int ans;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] graph; // 격자판(5x5)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        graph = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        ans = 0;
        backtrack(r, c, 0, 0);
        System.out.println(ans);
    }
}