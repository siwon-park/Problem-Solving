// 점수 계산 (2822번)
import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Pair[] pairs = new Pair[8];
		for (int i = 0; i < 8; i++) {
			int s = Integer.parseInt(br.readLine());
			pairs[i] = new Pair(s, i + 1);
		}
		
		Arrays.sort(pairs, (o1, o2) -> {
			if (o1.score < o2.score) return 1;
			else if (o1.score > o2.score) return -1;
			else return Integer.compare(o1.idx, o2.idx);
		});
		
		int total = 0;
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			total += pairs[i].score;
			arr[i] = pairs[i].idx;
		}
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(arr[i]);
			sb.append(" ");
		}
		
		bw.write(total + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();		
	}
}


class Pair {
	int score, idx;
	
	Pair(int score, int idx) {
		this.score = score;
		this.idx = idx;
	}
}