// 선물할인 (25947번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // n개의 선물
		int b = Integer.parseInt(st.nextToken()); // 예산 
		int a = Integer.parseInt(st.nextToken()); // 최대 a개의 선물
		
		long[] normal = new long[n + 1]; // 정상가
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			normal[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(normal); // 정렬
		for (int i = 1; i < n + 1; i++) {
			normal[i] += normal[i - 1]; // 누적합 계산
		}
		
		
		int ans = 0;
		for (int i = n; i >= 1; i--) {
			if (normal[i] > b) { // i개의 선물 누적 합이 예산보다 크면
				// i번째 선물을 포함하여 a개를 반값 할인했을 때, 구매가 가능한지 확인
				int idx = (i - a < 0) ? 0 : i - a;
				long sale = (normal[i] - normal[idx]) / 2; // 굳이 반값 누적 합 배열을 만들 필요가 없음
				if (normal[i] - sale <= b) { // 구매 가능하면 현재가 최대이므로 break
					ans = i;
					break;
				}
			} else {
				ans = i;
				break;
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}