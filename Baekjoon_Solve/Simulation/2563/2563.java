// 색종이 (2563번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		visited = new boolean[101][101];
		
		StringTokenizer st;
		int a, b;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			for (int j = a; j < a + 10; j++) {
				for (int k = b; k < b + 10; k++) {
					visited[j][k] = true;
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) if (visited[i][j]) cnt += 1;
		}
		
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}