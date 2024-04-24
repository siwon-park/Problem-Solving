// 프로젝트 스케줄링 (14907번)
import java.io.*;
import java.util.*;

public class Main {

	static int[] time = new int[26];
	static int[] indegree = new int[26];
	static ArrayList<int[]>[] graph = new ArrayList[26];
	
	static int topology(Queue<Integer> queue) {
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < graph[cur].size(); i++) {
				int[] pair = graph[cur].get(i);
				int nxt = pair[0];
				int t = pair[1];
				indegree[nxt] -= 1; // 진입차수 감소
				time[nxt] = Math.max(time[nxt], time[cur] + t);
				if (indegree[nxt] == 0) {
					queue.add(nxt);
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < 26; i++) {
			ans = Math.max(ans, time[i]);
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for (int i = 0; i < 26; i++) graph[i] = new ArrayList<>();
		
		Queue<Integer> _queue = new LinkedList<>();
		String line = "";
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			String[] str = line.split(" ");
			int n = str[0].charAt(0) - 65; // 작업
			int t = Integer.valueOf(str[1]); // 작업 시간
			if (str.length < 3) { // 진입 차수가 0
				_queue.add(n);
				time[n] = t;
			} else { // 진입 차수 1 이상
				for (int i = 0; i < str[2].length(); i++) {
					int m = str[2].charAt(i) - 65;
					indegree[n] += 1;
					graph[m].add(new int[] {n, t}); // n -> m에 t시간이 소모
				}
			}
		}
		
		System.out.println(topology(_queue));
	}
}
