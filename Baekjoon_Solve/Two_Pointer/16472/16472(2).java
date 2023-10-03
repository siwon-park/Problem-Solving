// 고냥이 (16472번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<Character, Integer> countHashMap = new HashMap<>();
		int N = Integer.parseInt(br.readLine()); // 인식 가능한 최대 알파벳 수
		String line = br.readLine();
		int M = line.length();
		
		int s = -1;
		int e = 0;
		int len = 1; // 최대 연속 문자열의 길이
		while (s < e && e < M) {
			if (s < 0) s = 0;
			if (countHashMap.get(line.charAt(e)) == null) { // 등장한 적이 없는 단어면 삽입
				countHashMap.put(line.charAt(e), 1);
			} else {
				countHashMap.computeIfPresent(line.charAt(e), (k, v) -> v + 1);
			}

			if (countHashMap.size() <= N) { // 등장한 단어 종류가 N이하면, 최대 길이 갱신 후 끝 포인터를 옮김
				len = Math.max(len, e - s + 1);
				e += 1; // 끝 포인터를 오른쪽으로 옮김
			} else { // 등장 단어 종류 수가 N을 초과하면 s와 e를 둘 다 옮김
				countHashMap.computeIfPresent(line.charAt(s), (k, v) -> v - 1);
				if (countHashMap.get(line.charAt(s)) == 0) { // 등장 빈도가 0이 되면 해시맵에서 삭제
					countHashMap.remove(line.charAt(s));
				}
				s += 1;
				e += 1;	
			}
		}
		
		bw.write(len + "");
		bw.flush();
		bw.close();
		br.close();
	}
}