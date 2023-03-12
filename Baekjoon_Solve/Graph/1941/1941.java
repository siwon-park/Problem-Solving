import java.io.*;


public class Main {

    static void dfs(int cnt, int sCnt, int bit) {
        if (cnt == 7 || cnt - sCnt >= 4) { // 학생이 7명이거나, 임도연파가 4명 이상이면 종료
            if (sCnt >= 4) ans += 1; // 이다솜파('S')가 4명 이상이면 경우의 수 추가
            return;
        }
        for (int i = 0; i < 25; i++) { // dfs를 bfs처럼 사용하기 위해 현재 연결 컴포넌트 상의 어떤 위치를 찾음
            if ((bit & (1 << i)) == 0) continue;
            int r = i / 5;
            int c = i % 5;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                int newBit = bit | (1 << (nr * 5 + nc));
                if (nr < 0 || nr > 4 || nc < 0 || nc > 4 || visited[newBit]) continue;
                visited[newBit] = true;
                if (graph[nr].charAt(nc) == 'S') dfs(cnt + 1, sCnt + 1, newBit);
                else dfs(cnt + 1, sCnt, newBit);
            }
        }
    }

    static int ans = 0;
    static String[] graph = new String[5];
    static boolean[] visited = new boolean[1 << 25];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) graph[i] = br.readLine();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int bit = 1 << (i * 5 + j);
                visited[bit] = true;
                if (graph[i].charAt(j) == 'S') dfs(1, 1, bit);
                else dfs(1, 0, bit);
            }
        }

        System.out.println(ans);
    }
}