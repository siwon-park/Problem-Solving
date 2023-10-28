// 이차원 배열과 연산 (17140번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int r, c, k, maxR, maxC;
	static int[][] graph = new int[100][100];
	
	static void operateArray(int _maxR, int _maxC) {
		if (_maxR >= _maxC) { // R 연산
			for (int i = 0; i < _maxR; i++) {
				HashMap<Integer, Integer> hashMap = new HashMap<>();
				for (int j = 0; j < _maxC; j++) {
					if (graph[i][j] == 0) continue; // 0은 무시
					hashMap.computeIfPresent(graph[i][j], (k, v) -> (v + 1));
					hashMap.putIfAbsent(graph[i][j], 1);
				}
				ArrayList<Pair> pairList = new ArrayList<>();
				for (Integer k : hashMap.keySet()) {
					pairList.add(new Pair(k, hashMap.get(k)));
				}
				Collections.sort(pairList); // 정렬
				int col = 0;
				Arrays.fill(graph[i], 0); // 현재 행 배열을 0으로 초기화
				for (Pair pair : pairList) {
					graph[i][col++] = pair.num; // 수를 먼저 넣음
					if (col == 100) break;
					graph[i][col++] = pair.cnt; // 등장 횟수를 넣음
					if (col == 100) break;
				}
				maxC = Math.max(maxC, col); // 최대 열 갱신
			}
		} else { // C 연산
			for (int j = 0; j < _maxC; j++) {
				HashMap<Integer, Integer> hashMap = new HashMap<>();
				for (int i = 0; i < _maxR; i++) {
					if (graph[i][j] == 0) continue; // 0은 무시
					hashMap.computeIfPresent(graph[i][j], (k, v) -> (v + 1));
					hashMap.putIfAbsent(graph[i][j], 1);
				}
				ArrayList<Pair> pairList = new ArrayList<>();
				for (Integer k : hashMap.keySet()) {
					pairList.add(new Pair(k, hashMap.get(k)));
				}
				Collections.sort(pairList); // 정렬
				int row = 0;
				for (Pair pair : pairList) {
					graph[row++][j] = pair.num; // 수를 먼저 넣음
					if (row == 100) break;
					graph[row++][j] = pair.cnt; // 등장 횟수를 넣음
					if (row == 100) break;
				}
				maxR = Math.max(maxR, row); // 최대 행 갱신
				// 남은 행을 0으로 초기화 (혹시 모르니)
				while (row < 100) {
					graph[row++][j] = 0;
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        
        // 초기 배열의 최대 행, 열 크기
        maxR = 3;
        maxC = 3;
        
        for (int i = 0; i < 3; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 3; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int t = 100;
        boolean flag = false;
        while (t >= 0) {
        	if (graph[r][c] == k) {
        		flag = true;
        		bw.write((100 - t) + "");
        		break;
        	}
        	operateArray(maxR, maxC);
        	t -= 1;
        }
        
        if (!flag) {
        	bw.write(-1 + "");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}


class Pair implements Comparable<Pair>{
	int num, cnt;
	Pair() {}
	Pair(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
	
	@Override
	public int compareTo(Pair o) {
		if (this.cnt > o.cnt) return 1;
		else if (this.cnt < o.cnt) return -1;
		else return Integer.compare(this.num, o.num);	
	}
}