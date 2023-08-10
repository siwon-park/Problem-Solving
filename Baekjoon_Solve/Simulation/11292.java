// 키 큰 사람 (11292번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			Pair[] pairs = new Pair[N];
			double maxHeight = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				double height = Double.parseDouble(st.nextToken());
				pairs[i] = new Pair(i, height, name);
				maxHeight = Math.max(maxHeight, height);
			}
			
			// 키 큰 순서대로, 입력 순이 빠른 순서대로 정렬
			Arrays.sort(pairs, (o1, o2) -> {
				if (o1.height < o2.height) return 1;
				else if (o1.height > o2.height) return -1;
				else return Integer.compare(o1.no, o2.no);
			});
			
			for (int i = 0; i < N; i++) {
				if (pairs[i].height == maxHeight) bw.write(pairs[i].name + " ");
				else {
					bw.write("\n");
					break;
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
 	}
}


class Pair {
	int no;
	double height;
	String name;
	
	Pair(int no, double height, String name) {
		this.no = no;
		this.height = height;
		this.name = name;
	}
}