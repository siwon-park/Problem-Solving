// 꿀 아르바이트 (12847번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static long[] T;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		T = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			T[i] = Integer.parseInt(st.nextToken());
			T[i] += T[i - 1];
		}
		
		long ans = 0;
		for (int i = M; i < N + 1; i++) {
			ans = Math.max(ans, T[i] - T[i - M]);
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}