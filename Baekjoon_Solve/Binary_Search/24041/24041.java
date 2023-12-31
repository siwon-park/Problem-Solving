// 성싶당 밀키트 (24041번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, G, K;
	static ArrayList<Pair> reqList = new ArrayList<>(); // 필수 재료들
	static ArrayList<Pair> notReqList = new ArrayList<>(); // 필수가 아닌 재료들
	
	static long binarySearch() {
		long s = 1;
		long e = 2_000_000_000;
		long ans = e;
		while (s <= e) {
			long mid = (s + e) / 2;
			boolean flag = check(mid);
			if (flag) { // 합이 G이하라면 -> true; mid값을 늘려서 탐색
				s = mid + 1;
				ans = mid;
			} else {
				e = mid - 1;
			}
		}
		return ans;
	}
	
	static boolean check(long mid) {
		long sumG = 0; // 현재 세균의 합
		PriorityQueue<Long> removePq = new PriorityQueue<>((o1, o2) -> Long.compare(o1, o2));
		
		for (int i = 0; i < reqList.size(); i++) {
			Pair pair = reqList.get(i);
			long g = pair.s * Math.max(1, mid - pair.l); // 현재 세균의 수
			sumG += g;
			if (sumG > G) return false;
		}
		
		for (int i = 0; i < notReqList.size(); i++) {
			Pair pair = notReqList.get(i);
			long g = pair.s * Math.max(1, mid - pair.l); // 현재 세균의 수
			removePq.add(g);
		}
		
		// 최대 K개를 뺀다.
		while (removePq.size() > K) {
			sumG += removePq.poll();
		}
		
		return sumG <= G;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			if (o == 0) {
				reqList.add(new Pair(s, l, o));
			} else {
				notReqList.add(new Pair(s, l, o));				
			}
		}
		
		long ans = binarySearch();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int s, l, o;
	Pair(){}
	Pair(int s, int l, int o){
		this.s = s;
		this.l = l;
		this.o = o;
	}
}