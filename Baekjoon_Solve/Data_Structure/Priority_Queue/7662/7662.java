// 이중 우선순위 큐 (7662번)
import java.io.*;
import java.util.*;

public class Main {
	
	static TreeMap<Integer, Integer> treeMap;
	static int T, K; // 테스트 케이스 수, 테스트 케이스별 쿼리 수
	static final String INSERT = "I"; // 삽입
	static final String DELETE = "D"; // 삭제
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			K = Integer.parseInt(br.readLine());
			treeMap = new TreeMap<>();
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				String x = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (x.equals(INSERT)) { // 삽입 연산 -> 있으면 횟수 증가, 없으면 횟수 감소
					treeMap.computeIfPresent(num, (key, val) -> val + 1);
					treeMap.putIfAbsent(num, 1);
				} else {
					if (treeMap.isEmpty()) continue; // 큐가 비어있으면 무시
					if (num == -1) { // 최솟값 삭제
						int min = treeMap.firstKey();
						treeMap.computeIfPresent(min, (key, val) -> val - 1);
						if (treeMap.get(min) == 0) treeMap.remove(min);
					} else {
						int max = treeMap.lastKey();
						treeMap.computeIfPresent(max, (key, val) -> val - 1);
						if (treeMap.get(max) == 0) treeMap.remove(max);
					}
				}
			}
			
			if (treeMap.isEmpty()) bw.write("EMPTY" + "\n");
			else bw.write(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}