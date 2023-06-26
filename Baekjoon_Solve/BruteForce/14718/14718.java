// 용감한 용사 진수 (14718번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 병사의 수
		int K = Integer.parseInt(st.nextToken()); // 이겨야 하는 병사 수
		int[] _str = new int[N]; // 힘
		int[] _dex = new int[N]; // 민첩
		int[][] army = new int[N][3]; // 병사
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			_str[i] = Integer.parseInt(st.nextToken());
			_dex[i] = Integer.parseInt(st.nextToken());
			army[i][0] = _str[i];
			army[i][1] = _dex[i];
			army[i][2] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> _int; // 지능
		int minStats = 3_000_001; // 최소 스탯 합
		for (int i = 0; i < N; i++) {
			int curStr = _str[i]; // 현재 고른 힘
			for (int j = 0; j < N; j++) {
				int curDex = _dex[j];
				_int = new ArrayList<>();
				for (int k = 0; k < N; k++) {
					// 병사 스탯 중 힘, 민첩이 현재 고른 힘과 민첩보다 작거나 같으면 지능 스탯을 지능 리스트에 추가
					if (curStr >= army[k][0] && curDex >= army[k][1]) {
						_int.add(army[k][2]);
					}
				}
				
				// 만약 지능의 길이가 K이상이면 총 스탯의 최솟값을 갱신함
				if (_int.size() >= K) {
					Collections.sort(_int); // 오름차순 정렬
					minStats = Math.min(minStats, curStr + curDex + _int.get(K - 1));
				}
			}
		}
		
		bw.write(minStats + "");
		bw.flush();
		bw.close();
		br.close();
	}
}