// 넴모넴모 2020 (19845번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, Q;
	static int[] arr;
	
	static int lowerBound(int y, int cur) {
		int idx = 0;
		int s = 0;
		int e = y;
		while (s <= e) {
			int mid = (s + e) >> 1;
			if (arr[mid] >= cur) {
				e = mid - 1;
				idx = mid;
			} else {
				s = mid + 1;
			}
		}
		return idx;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine()); // ay >= ay+1
		for (int i = 0; i < N; i++) {
			arr[N - 1 - i] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = N - Integer.parseInt(st.nextToken());
			
			int eraseX = Math.max(arr[y] - x, 0); // 가로로 사라지는 넴모들
			/*
			 * 세로로 사라지는 넴모들
			 * x 위치에서 위로 전부 다 사라지기 때문에 x개보다는 많아야 함
			 * 인덱싱을 위해 x - 1을 했기 때문에 원본 x = x + 1임
			 * x가 들어갈 하한 위치를 lowerBound로 찾고 그 값을 y와 비교하여 계산
			 * */
			if (eraseX > 0) {
				int idx = lowerBound(y, x + 1);
				bw.write(((Math.abs(y - idx)) + eraseX) + "\n");
			} else {
				bw.write(eraseX + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
