// YouTube (3117번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int LOG = 31; // 2 ^ 30 = 1,073,741,824
	static int N, K, M; // 학생 수, 동영상 수, 남은 수업 시간
	static int[] init, youtube; // 초기 시청 동영상 번호, 추천 동영상 번호
	static int[][] parent; // 희소 배열
	
	static void setParent() {
		for (int k = 0; k < LOG - 1; k++) {
			for (int n = 1; n < K + 1; n++) {
				if (parent[n][k] != -1) parent[n][k + 1] = parent[parent[n][k]][k];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		init = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) init[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		youtube = new int[K + 1];
		for (int i = 1; i < K + 1; i++) youtube[i] = Integer.parseInt(st.nextToken());
		
		parent = new int[K + 1][LOG];
		
		for (int i = 1; i < K + 1; i++) {
			Arrays.fill(parent[i], -1);
			parent[i][0] = youtube[i];
		}
		
		setParent();
		
		for (int i = 1; i < N + 1; i++) {
			int cur = init[i]; // 현재 동영상
			int diff = M - 1; // M - 1번째 부모가 몇 번 동영상인지 찾아야 함
			for (int j = 0; diff > 0; j++) {
				if (diff % 2 != 0) cur = parent[cur][j];
				diff /= 2;
			}
			bw.write(cur + " ");
		}

		bw.flush();
		br.close();
		bw.close();
	}	
}