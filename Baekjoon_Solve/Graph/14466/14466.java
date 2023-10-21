// 소가 길을 건너간 이유 6 (14466번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int N, K, R;
	static int[][] road;
	static int[][] visited;
	static int[] component = new int[101]; // 각 컴포넌트별 수
	static boolean[][] isCow;
	static Pair[] cows;
	
	static void bfs(int r, int c, int no) {
		visited[r][c] = no;
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(r, c));
		component[no] += 1; // 컴포넌트 수를 증가
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			for (int k = 0; k < 4; k++) {
				int ny = pair.y + dy[k];
				int nx = pair.x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				if ((road[pair.y][pair.x] & (1 << k)) > 0) continue; // 해당 방향에 길이 있으면 가지 않음
				if (visited[ny][nx] == 0) {
					visited[ny][nx] = no;
					if (isCow[ny][nx]) { // 소일 경우에만
						component[no] += 1; // 컴포넌트 수를 증가						
					}
					queue.add(new Pair(ny, nx));
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        road = new int[N][N];
        visited = new int[N][N];
        for (int i = 0; i < R; i++) {
        	st = new StringTokenizer(br.readLine());
        	int r1 = Integer.parseInt(st.nextToken()) - 1;
        	int c1 = Integer.parseInt(st.nextToken()) - 1;
        	int r2 = Integer.parseInt(st.nextToken()) - 1;
        	int c2 = Integer.parseInt(st.nextToken()) - 1;
        	// 1111 -> 길이 4방향으로 있음, 상우하좌 방향
        	if (r1 > r2) {
        		road[r1][c1] |= (1 << 0);
        		road[r2][c2] |= (1 << 2);
        	} else if (r1 < r2) {
        		road[r1][c1] |= (1 << 2);
        		road[r2][c2] |= (1 << 0);
        	} else if (c1 > c2) {
        		road[r1][c1] |= (1 << 3);
        		road[r2][c2] |= (1 << 1);
        	} else if (c1 < c2) {
        		road[r1][c1] |= (1 << 1);
        		road[r2][c2] |= (1 << 3);
        	}
        }
        
        cows = new Pair[K];
        isCow = new boolean[N][N];
        for (int i = 0; i < K; i++) {
        	st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken()) - 1;
        	int c = Integer.parseInt(st.nextToken()) - 1;
        	cows[i] = new Pair(r, c);
        	isCow[r][c] = true;
        }
        
        int cmp = 1; // 컴포넌트의 번호
        for (int i = 0; i < K; i++) {
        	if (visited[cows[i].y][cows[i].x] == 0) {
        		bfs(cows[i].y, cows[i].x, cmp);
        		cmp += 1;
        	}
        }
        
        int ans = 0;
        for (int i = 1; i < cmp - 1; i++) {
        	for (int j = i + 1; j < cmp; j++) {
        		ans += component[i] * component[j];
        	}
        }
        
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}


class Pair {
	int y, x;
	Pair() {}
	Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
}