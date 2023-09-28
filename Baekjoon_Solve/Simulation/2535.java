// 아시아 정보올림피아드 (2535번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static Pair[] pairs;
	static HashMap<Integer, Integer> rankCount = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		pairs = new Pair[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pairs[i] = new Pair(n, s, c);
		}
		
		Arrays.sort(pairs, (o1, o2) -> {
			if (o1.score < o2.score) return 1;
			else if (o1.score > o2.score) return -1;
			else {
				if (o1.stdno > o2.stdno) return 1;
				else if (o1.stdno < o2.stdno) return -1;
				else return Integer.compare(o1.nation, o2.nation);
			}
		});
		
		// 나라별 매달 수는 2개 뿐임
		int idx = 0;
		Pair[] ranks = new Pair[3];
		for (int i = 0; i < N; i++) {
			if (idx == 3) break;
			if (rankCount.get(pairs[i].nation) == null) {
				rankCount.put(pairs[i].nation, 0);
			}
			if (rankCount.get(pairs[i].nation) >= 2) continue;
			rankCount.compute(pairs[i].nation, (k, v) -> v + 1);
			ranks[idx++] = pairs[i];
		}
		
		for (int i = 0; i < 3; i++) {
			bw.write(ranks[i].nation + " " + ranks[i].stdno + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int nation, stdno, score;
	
	Pair(int nation, int stdno, int score) {
		this.nation = nation;
		this.stdno = stdno;
		this.score = score;
	}
}