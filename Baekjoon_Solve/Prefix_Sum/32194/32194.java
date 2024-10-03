// 질문은 계속돼 (32194번)
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 2];
		
		arr[1] = 1; // 첫번째 질문의 답은 예
		for (int i = 2; i < N + 2; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int ret = arr[y] - arr[x - 1];
			if (q == 1) { // 구간의 답이 모두 예인가?
				if (ret == y - x + 1) { // 맞음
					arr[i] = arr[i - 1] + 1;
					bw.write("Yes" + "\n");
				} else {
					arr[i] = arr[i - 1];
					bw.write("No" + "\n");
				}
			} else { // 구간의 답이 모두 아니오인가?
				if (ret == 0) { // 맞음
					arr[i] = arr[i - 1] + 1;
					bw.write("Yes" + "\n");
				} else {
					arr[i] = arr[i - 1];
					bw.write("No" + "\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

