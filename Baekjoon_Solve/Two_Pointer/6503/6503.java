// 망가진 키보드 (6503번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			int m = Integer.parseInt(br.readLine()); // 사용 가능한 최대 문자의 종류 수
			if (m == 0) break;
			String line = br.readLine();
			int[] count = new int[200];
			int n = line.length(); // 문자열의 최대 길이
			int s = 0;
			int e = 0;
			int used = 0;
			int maxLen = 0;
			while (e < n) {
				char cur = line.charAt(e);
				count[cur] += 1;
				if (count[cur] == 1) used += 1;
				if (used <= m) { // 지금까지 사용한 문자 종류가 m보다 작으면 e를 오른쪽으로 옮김
					maxLen = Math.max(maxLen, e - s + 1); // 부분 문자열의 최대 길이 갱신
					e += 1;
				} else {
					char sChar = line.charAt(s); // s위치에 있는 문자
					count[sChar] -= 1;
					if (count[sChar] == 0) used -= 1;
					s += 1; // s를 오른쪽으로 옮김
					e += 1;
				}
			}
			bw.write(maxLen + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
