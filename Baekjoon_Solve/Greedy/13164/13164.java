// 행복 유치원 (13164번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr); // 정렬
		int[] diff = new int[N - 1];
		for (int i = 1; i < N; i++) diff[i - 1] = arr[i] - arr[i - 1];
		
		Arrays.sort(diff); // 정렬
		
		int ans = 0;
		if (K >= N) bw.write(ans + "");
		else {
			for (int i = 0; i < N - K; i++) ans += diff[i];
			bw.write(ans + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}