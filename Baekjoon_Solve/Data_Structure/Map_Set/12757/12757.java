// 전설의 JBNU (12757번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K;
	static TreeMap<Integer, Integer> treeMap;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 키의 차이가 K보다 큰 데이터는 무시함
		
		treeMap = new TreeMap<>();
		
		// N개의 줄에는 key : value 쌍이 주어짐
		int key, val;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			key = Integer.parseInt(st.nextToken());
			val = Integer.parseInt(st.nextToken());
			treeMap.put(key, val);
		}
		
		int op;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			op = Integer.parseInt(st.nextToken());
			key = Integer.parseInt(st.nextToken());
			if (op == 1) { // key:value 쌍을 추가
				val = Integer.parseInt(st.nextToken());
				treeMap.put(key, val);
			} else if (op == 2) { // key로 검색된 value를 변경 -> key가 유일한지 확인 후 변경
				val = Integer.parseInt(st.nextToken());
				if (treeMap.get(key) != null) treeMap.put(key, val);
				else {
					int diff1 = K + 1;
					int diff2 = K + 1;
					int lowKey = -1;
					int highKey = 1_000_000_001;
					// 각 키가 존재하는지 확인한 후 key와의 차이를 확인
					if (treeMap.floorKey(key) != null) {
						lowKey = treeMap.floorKey(key);
						diff1 = Math.abs(key - lowKey);
					}
					if (treeMap.ceilingKey(key) != null) {
						highKey = treeMap.ceilingKey(key);
						diff2 = Math.abs(key - highKey);						
					}
					if (diff1 <= K && diff2 <= K) { // 두 키 모두 차이가 K보다 작은 경우
						if (diff1 == diff2) continue; // 키가 유일하지 않기 때문에 무시
						else if (diff1 < diff2) treeMap.put(lowKey, val);
						else treeMap.put(highKey, val);
					} else if (diff1 <= K) {
						treeMap.put(lowKey, val);
					} else if (diff2 <= K) {
						treeMap.put(highKey, val);
					}
				}
			} else { // key로 검색된 데이터를 찾음
				if (treeMap.get(key) != null) bw.write(treeMap.get(key) + "\n"); // key가 정확히 일치
				else { // key가 일치하지 않을 경우 가장 가까운 키를 찾음
					int diff1 = K + 1;
					int diff2 = K + 1;
					int lowKey = -1;
					int highKey = 1_000_000_001;
					if (treeMap.floorKey(key) != null) {
						lowKey = treeMap.floorKey(key);
						diff1 = Math.abs(key - lowKey);
					}
					if (treeMap.ceilingKey(key) != null) {
						highKey = treeMap.ceilingKey(key);
						diff2 = Math.abs(key - highKey);						
					}
					// 각 키별로 key와의 차이를 확인
					if (diff1 <= K && diff2 <= K) { // 두 키 모두 차이가 K보다 작은 경우
						if (diff1 == diff2) bw.write("?\n"); // 키가 유일하지 않으면 ? 출력
						else if (diff1 < diff2) bw.write(treeMap.get(lowKey) + "\n");
						else bw.write(treeMap.get(highKey) + "\n");
					} else if (diff1 <= K) {
						bw.write(treeMap.get(lowKey) + "\n");
					} else if (diff2 <= K) {
						bw.write(treeMap.get(highKey) + "\n");
					} else bw.write("-1\n");
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
 	}
}
