import java.util.*;

class Solution {
	
	static int n, cnt; // 노드 수
	static int[] node;
	static boolean[][] visited;
	static ArrayList<Integer>[] tree; // 이진 트리
	
	static void dfs(int cur, int w, int s, int bit) {
		visited[cur][bit] = true;
		if (w >= s) return; // 늑대 >= 양이면 return
		cnt = Math.max(cnt, s);
		for (int i = 0; i < tree[cur].size(); i++) {
			int nxt = tree[cur].get(i); // 다음 노드
			
			int nBit = bit | (1 << nxt);
			if (!visited[nxt][nBit]) {
				if ((bit & (1 << nxt)) == 0) {
					if (node[nxt] == 1) dfs(nxt, w + 1, s, nBit);
					else dfs(nxt, w, s + 1, nBit);
				} else dfs(nxt, w, s, nBit);
			}
		}
	}
	
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        n = info.length;
        node = info;
        visited = new boolean[n][(1 << n)];
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        
        for (int[] tmp : edges) {
        	int p = tmp[0];
        	int c = tmp[1];
        	tree[p].add(c);
        	tree[c].add(p);
        }
        
        cnt = 0;
        dfs(0, 0, 1, 1);
        answer = cnt;
        return answer;
    }
}