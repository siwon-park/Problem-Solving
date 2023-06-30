// 흙길 보수하기 (1911번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 웅덩이의 수
		int L = Integer.parseInt(st.nextToken()); // 널빤지의 수
		
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[i][0] = s;
			arr[i][1] = e;
		}
		
		// s가 빠른 순으로 정렬
		Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		
		int cnt = 0;
		int start = arr[0][0]; // 널빤지를 놓기 시작하는 지점
		for (int i = 0; i < N; i++) {
			 // 널빤지를 놓아야 하는 곳이 현재 웅덩이의 끝보다 크면 놓을 필요가 없음
			if (start > arr[i][1]) continue;
			else {
				// 널빤지를 놓아야 하는 곳이 웅덩이의 시작 이상이면 시작 지점을 바꿈
				if (arr[i][0] >= start) start = arr[i][0];
				// 널빤지를 놓아야 하는 시점부터 웅덩이의 끝을 포함하는 길이를 전부 덮어야 함 -> 올림
				int r = (int) Math.ceil((arr[i][1] - start) / (double) L);
				cnt += r;
				start += r * L; // 놓은 곳의 다음부터 놓아야 함
			}
		}
		
		bw.write(cnt + "");
		bw.flush();
		br.close();
		bw.close();
	}
}