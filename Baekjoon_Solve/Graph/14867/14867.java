// 물통 (14867번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int a, b, c, d;
	static HashSet<Integer>[] setArr = new HashSet[100_001];
	
	static int bfs() {
		setArr[0].add(0);
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 0});
		while (!queue.isEmpty()) { // 간선의 가중치가 1이기 때문에 먼저 도착한 쪽이 무조건 빠름
			int[] tmp = queue.poll();
			int cur_a = tmp[0];
			int cur_b = tmp[1];
			if (cur_a == c && cur_b == d) return tmp[2];
			// F(a) -> a의 물통에 물을 가득 채움
			if (cur_a < a && !setArr[a].contains(cur_b)) {
				setArr[a].add(cur_b);
				queue.add(new int[] {a, cur_b, tmp[2] + 1});
			}
			
			// F(b) -> b의 물통에 물을 가득 채움
			if (cur_b < b && !setArr[cur_a].contains(b)) {
				setArr[cur_a].add(b);
				queue.add(new int[] {cur_a, b, tmp[2] + 1});
			}
			
			// E(a) -> a를 0으로 만듦
			if (!setArr[0].contains(cur_b)) {
				setArr[0].add(cur_b);
				queue.add(new int[] {0, cur_b, tmp[2] + 1});
			}
			
			
			// E(b) -> b를 0으로 만듦
			if (!setArr[cur_a].contains(0)) {
				setArr[cur_a].add(0);
				queue.add(new int[] {cur_a, 0, tmp[2] + 1});
			}
			
			// M(a, b) -> a의 물을 b로 옮김
			if (cur_a <= b - cur_b && !setArr[0].contains(cur_a + cur_b)) {
				setArr[0].add(cur_a + cur_b);
				queue.add(new int[] {0, cur_a + cur_b, tmp[2] + 1});
			} else if (cur_a > b - cur_b && !setArr[cur_a - b + cur_b].contains(b)) {
				setArr[cur_a - b + cur_b].add(b);
				queue.add(new int[] {cur_a - b + cur_b, b, tmp[2] + 1});
			}
			
			// M(b, a) -> b의 물을 a로 옮김
			if (cur_b <= a - cur_a && !setArr[cur_a + cur_b].contains(0)) {
				setArr[cur_a + cur_b].add(0);
				queue.add(new int[] {cur_a + cur_b, 0, tmp[2] + 1});
			} else if (cur_b > a - cur_a && !setArr[a].contains(cur_b - a + cur_a)) {
				setArr[a].add(cur_b - a + cur_a);
				queue.add(new int[] {a, cur_b - a + cur_a, tmp[2] + 1});
			}
			
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 100_001; i++) {
			setArr[i] = new HashSet<>();
		}
		
		int ans = bfs();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	} 
}