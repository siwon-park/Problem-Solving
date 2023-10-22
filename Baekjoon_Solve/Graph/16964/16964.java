// DFS 스페셜 저지  (16964번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, ord;
	static ArrayList<Set<Integer>> graph;
	static boolean[] check;
	static int[] orders;
	
	
	static void dfs(int cur) {
		// 다음 방문할 순서에 해당하는 노드가 연결되어 있으면 방문함
		for (int i = 0; i < graph.get(cur).size(); i++) {
			if (ord + 1 < N) {
				int nxt = orders[ord + 1];
				if (graph.get(cur).contains(nxt) && !check[nxt]) {
					check[nxt] = true;
					ord++;
					dfs(nxt);
				}				
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
        	graph.add(new HashSet<>());
        }
        
        for (int i = 0; i < N - 1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	graph.get(a).add(b);
        	graph.get(b).add(a);
        }
        
        check = new boolean[N + 1];
        
        orders = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	orders[i] = Integer.parseInt(st.nextToken());
        }
        
        // 레벨로 일치 비교? 레벨이 맞아도 연결이 안 된 다른 노드 번호가 들어올 수도 있음
        ord = 0;
        check[1] = true;
        dfs(1);
        
        int ans = (ord != N - 1) ? 0 : 1;
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}