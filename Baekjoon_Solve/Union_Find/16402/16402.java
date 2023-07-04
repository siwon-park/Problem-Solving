// 제국 (16402번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M; // 왕국의 수, 전쟁의 수
	static HashMap<String, Integer> kingdomMap; // 왕국 해시맵 -> 이름:번호
	static HashMap<Integer, String> numberMap; // 왕국 해시맵 -> 번호:이름
	static int[] parent; // 부모 배열
	
	static int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[b] = a; // b의 부모를 a로 함
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N];
		kingdomMap = new HashMap<>();
		numberMap = new HashMap<>();
		String kingdom;
		for (int i = 0; i < N; i++) {
			parent[i] = i;
			kingdom = br.readLine();
			kingdomMap.put(kingdom, i);
			numberMap.put(i, kingdom);
		}
		
		String[][] warResult = new String[M][3];
		for (int i = 0; i < M; i++) {
			String[] tmp = br.readLine().split(",");
			warResult[i] = tmp;
		}
		
		for (int i = 0; i < M; i++) {
			int w = Integer.parseInt(warResult[i][2]);
			int a = kingdomMap.get(warResult[i][0]);
			int b = kingdomMap.get(warResult[i][1]);
			int pa = find(a); // a의 종주국
			int pb = find(b); // b의 종주국
			if (w == 1) { // a가 이김
				if (pa != pb) union(a, b); // 서로 다른 국가 소속일 경우 a의 소속으로 병함
				else { // 서로 같은 소속이면
					if (a == pa) { // a가 종주국이면 아무 일도 일어나지 않음 
						continue;
					} else if (b == pb) { // b가 종주죽인데 속국인 a가 이김
						parent[a] = a; // a가 종주국이 됨
						parent[b] = a;
					}
				}
			} else if (w == 2) { // b가 이김
				if (pa != pb) union(b, a); // 서로 다른 국가 소속일 경우 b의 소속으로 병합
				else { // 서로 같은 소속이면
					if (b == pb) { // b가 종주국이면 아무일도 일어나지 않음
						continue;
					} else if (a == pa) { // a가 종주국인데 속국인 b가 이김
						parent[b] = b;
						parent[a] = b;
					}
				}
			}
		}
		
		TreeSet<String> treeSet = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			find(i);
			treeSet.add(numberMap.get(parent[i]));
		}
		
		bw.write(treeSet.size() + "\n");
		for (String name : treeSet) bw.write(name + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}