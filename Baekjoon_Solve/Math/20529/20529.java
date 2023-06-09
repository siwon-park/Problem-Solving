// 가장 가까운 세 사람의 심리적 거리 (20529번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int check(String mbtiA, String mbtiB) {
		int diff = 0;
		for (int i = 0; i < 4; i++) if (mbtiA.charAt(i) != mbtiB.charAt(i)) diff += 1;
		return diff;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스의 수
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			HashMap<String, Integer> mbtiMap = new HashMap<>(); // mbti 테이블 (mbti별 등장빈도)
			String type;
			int maxApp = 0; // 최대 등장 빈도
			for (int i = 0; i < N; i++) {
				type = st.nextToken();
				mbtiMap.computeIfPresent(type, (k, v) -> v + 1);
				mbtiMap.putIfAbsent(type, 1);
				maxApp = Math.max(maxApp, mbtiMap.get(type)); // 최대 등장 빈도 갱신
			}
			
			int M = mbtiMap.size(); // 등장한 MBTI의 종류 수
			if (maxApp >= 3) { // 최대 등장 빈도가 3이상이면 같은 성격 3개를 고르면 0임
				bw.write(0 + "\n");
			} else { // 최대 등장 빈도가 2이하면 3개 중 최솟값이 되는 케이스를 찾음
				ArrayList<String> keyList = new ArrayList<>(mbtiMap.keySet());
				String mbtiA, mbtiB, mbtiC;
				int min = 13;
				for (int i = 0; i < M; i++) {
					mbtiA = keyList.get(i);
					mbtiMap.computeIfPresent(mbtiA, (k, v) -> v - 1);
					for (int j = i; j < M; j++) {
						mbtiB = keyList.get(j);
						if (mbtiMap.get(mbtiB) == 0) continue; // 고를 수 없는 mbti면 continue;
						mbtiMap.computeIfPresent(mbtiB, (k, v) -> v - 1);
						for (int k = i; k < M; k++) {
							mbtiC = keyList.get(k);
							if (mbtiMap.get(mbtiC) == 0) continue;
							min = Math.min(min, check(mbtiA, mbtiB) + check(mbtiB, mbtiC) + check(mbtiA, mbtiC));
						}
						mbtiMap.computeIfPresent(mbtiB, (k, v) -> v + 1);
					}
					mbtiMap.computeIfPresent(mbtiA, (k, v) -> v + 1);
				}
				bw.write(min + "\n");
			} 
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}