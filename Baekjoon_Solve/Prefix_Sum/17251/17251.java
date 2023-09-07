// 힘 겨루기 (17251번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr, prefix;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		N = Integer.parseInt(br.readLine());
		
		int _max = 0;
		arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			_max = Math.max(_max, arr[i]);
		}
		
		prefix = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			if (arr[i] == _max) prefix[i] += 1;
			prefix[i] += prefix[i - 1];
		}
		
		int r = 0, b = 0;
		for (int i = 1; i < N; i++) {
			int rCnt = prefix[i]; // R팀의 최댓값 누적 갯수
			int bCnt = prefix[N] - rCnt; // B팀의 최댓값 누적 갯수
			if (rCnt > 0 && bCnt == 0) r += 1;
			else if (rCnt == 0 && bCnt > 0) b += 1;
		}
		
		if (r == b) bw.write("X");
		else if (r > b) bw.write("R");
		else bw.write("B");
		
		bw.flush();
		bw.close();
		br.close();
	}
}