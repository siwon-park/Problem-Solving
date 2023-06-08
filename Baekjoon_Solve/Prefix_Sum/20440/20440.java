// 니가 싫어 싫어 너무 싫어 싫어 오지 마 내게 찝쩍대지마 - 1 (20440번)
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static HashMap<Integer, Integer> idxTable; // 인덱스 테이블
	static Pair[] pairs;
	static HashSet<Integer> hashSet;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		idxTable = new HashMap<>();
		pairs = new Pair[N];
		hashSet = new HashSet<>();
		
		StringTokenizer st;
		int s, e;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			pairs[i] = new Pair(s, e);
			hashSet.add(s);
			hashSet.add(e);
		}
		
		ArrayList<Integer> list = new ArrayList<>(hashSet);
		Collections.sort(list); // 오름차순 정렬
		for (int i = 0; i < list.size(); i++) idxTable.put(list.get(i), i);
		
		int M = hashSet.size();
		// 누적합 계산
		int[] prefixSum = new int[M];
		for (int i = 0; i < N; i++) {
			Pair pair = pairs[i];
			prefixSum[idxTable.get(pair.s)] += 1;
			prefixSum[idxTable.get(pair.e)] -= 1;
		}
		
		int maxMosq = prefixSum[0];
		int minIdx = 0; // 최소 시작 인덱스
		for (int i = 1; i < M; i++) {
			prefixSum[i] += prefixSum[i - 1];
			if (maxMosq < prefixSum[i]) {
				maxMosq = prefixSum[i];
				minIdx = i;
			}
		}
		
		int end = minIdx;
		for (int i = minIdx + 1; i < M; i++) {
			if (prefixSum[i] < maxMosq) {
				end = i;
				break;
			}
		}
		
		System.out.println(maxMosq);
		System.out.println(list.get(minIdx) + " " + list.get(end));
	}
}

class Pair {
	int s;
	int e;
	
	Pair(int s, int e) {
		this.s = s;
		this.e = e;
	}
}