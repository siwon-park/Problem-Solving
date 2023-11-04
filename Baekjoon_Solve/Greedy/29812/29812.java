// 아니 이게 왜 안 돼 (29812번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); 
		String line = br.readLine();
		st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Character, Integer> hashMap = new HashMap<>();
		hashMap.put('H', 0);
		hashMap.put('Y', 0);
		hashMap.put('U', 0);
		
		int wasted = 0; // 사용한 에너지
		int drag = 0; // 드래그 여부 -> 1이면 드래그 X, 2부터는 드래그
		for (int i = 0; i < N; i++) {
			char c = line.charAt(i);
			if (c == 'H' || c == 'Y' || c == 'U') {
				hashMap.compute(c, (k, v) -> (v + 1));
				if (drag == 1) { // 드래그 수가 1이면 드래그를 하지 않고 바로 삭제함(D)
					wasted += D;
				} else if (drag > 1) { // 드래그 수가 2이상이면 -> 사용되는 에너지를 판단 후에 삭제함
					// 드래그하는데 너무 많은 에너지가 드는 경우 굳이 드래그 하지 않고 여러 번 삭제하는 게 이득임
					int w1 = drag * D; // 하나씩 바로 삭제하는 경우
					int w2 = M + D; // 드래그 후 삭제
					wasted += Math.min(w1, w2);
				}
				drag = 0; // 드래그한 수를 0으로 만듦
			} else { // H, Y, U가 아닐 경우 드래그
				drag += 1;
			}
		}
		
		if (drag > 0) { // 남은 drag 수에 대한 처리
			int w1 = drag * D;
			int w2 = M + D;
			wasted += Math.min(w1, w2);
		}
		
		if (wasted == 0) {
			bw.write("Nalmeok\n");
		} else {
			bw.write(wasted + "\n");
		}
		
		// 만들 수 있는 HYU의 최대 개수는 H, Y, U의 등장 빈도 중 가장 작은 등장 빈도를 가진 수임
		int HYU = Math.min(hashMap.get('H'), Math.min(hashMap.get('Y'), hashMap.get('U')));
		if (HYU == 0) {
			bw.write("I love HanYang University");
		} else {
			bw.write(HYU + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}