import java.util.Arrays;

class Solution {
	
	static int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x]; 
	} 
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	static int[] parent; // 부모 배열
	
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) parent[i] = i;
        
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        int a, b, c;
        for (int i = 0; i < costs.length; i++) {
        	a = costs[i][0];
        	b = costs[i][1];
        	c = costs[i][2];
        	if (find(a) != find(b)) { // 같은 집합이 아니면 병합함
        		union(a, b);
        		answer += c;
        	}
        }
        
        return answer;
    }
}