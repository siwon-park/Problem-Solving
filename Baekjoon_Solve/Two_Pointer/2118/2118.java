// 두 개의 탑 (2118번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 지점의 수
		
		int radius = 0; // 지름
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			radius += arr[i];
		}
		
		// 정뱡향 -> 역방향은 지름 - 정방향을 하면 됨
		int[] prefix = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			prefix[i] = prefix[i - 1] + arr[i - 1];
		}
		
		int half = radius / 2; // 반지름
		int s = 0;
		int e = 1;
		int maxBetween = 0; // 두 탑 사이의 거리
		while (s < e && e < N) {
			int cur_radius = prefix[e] - prefix[s];
			maxBetween = Math.max(Math.min(cur_radius, radius - cur_radius), maxBetween);
			if (cur_radius >= half) {
				s += 1;
			} else {
				e += 1;
			}
		}
		bw.write(maxBetween + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}