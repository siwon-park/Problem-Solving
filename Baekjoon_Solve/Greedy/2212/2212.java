// 센서 (2212번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr); // 정렬
		
		// 정렬한 두 센서의 위치 차이를 배열에 담음
		int[] diff = new int[N - 1];
		for (int i = 1; i < N; i++) diff[i - 1] = arr[i] - arr[i - 1];
		
		Arrays.sort(diff); // 정렬
		
		int ans = 0;
		if (K >= N) bw.write(0 + ""); // 집중국 수가 센서 수보다 많으면 거리 합은 0임
		else {
			// 두 센서의 위치 차이가 많이 나는 K - 1개의 그룹을 빼면 K개의 그룹을 만들 수 있음 -> 그룹 간 K - 1개의 선을 긋는다고 생각
			for (int i = 0; i < N - K; i++) ans += diff[i];
			bw.write(ans + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}