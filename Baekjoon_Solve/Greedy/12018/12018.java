// Yonsei TOTO (12018번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 과목 수
		int m = Integer.parseInt(st.nextToken()); // 마일리지 수
		int[] arr = new int[n]; // 각 과목별 넣어야 하는 최소 마일리지 -> l번째 큰 점수 이상으로만 넣으면 됨
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); // 신청한 사람 수
			int l = Integer.parseInt(st.nextToken()); // 과목 수강 인원
			int[] tmp = new int[p]; // 각 사람별 넣은 마일리지 수
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < p; j++) tmp[j] = Integer.parseInt(st.nextToken());
			if (p < l) { // 신청한 사람보다 정원이 많으면 1 마일리지만 넣어도 수강 가능
				arr[i] = 1;
				continue;
			}
			Arrays.sort(tmp); // 오름차순 정렬
			arr[i] = tmp[p - l]; // 오름차순 정렬했으니 p - l번째가 찾고자 하는 최소 마일리지임
		}
		
		Arrays.sort(arr); // 오름차순 정렬 -> 낮은 점수부터 획득하여 최대한 많이 수강하기 위함
		
		int cnt = 0; // 수강 가능한 과목 수
		for (int i = 0; i < n; i++) {
			if (m >= arr[i]) { // 현재 마일리지가 수강 마일리지 이상이면 수강함
				m -= arr[i];
				cnt += 1;
			} else break;
		}
		
		System.out.println(cnt);
	}
}