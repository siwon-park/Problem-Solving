// 생일 선물 (12892번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 친구 수
		int D = Integer.parseInt(st.nextToken()); // 최소 가격 차
		
		Present[] presents = new Present[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			presents[i] = new Present(p, v);
		}
		
		// 가격 순으로 정렬
		Arrays.sort(presents, (o1, o2) -> Integer.compare(o1.p, o2.p));
		
		
		long curV = 0; // 현재 가격차
		long maxV = presents[0].v; // 최대 만족감
		int s = 0;
		int e = 0;
		while (s <= e && e < N) {
			if (presents[e].p - presents[s].p < D) { // 양 끝 선물의 가격차가 D보다 작으면
				curV += presents[e].v;
				e += 1;
			} else {
				curV -= presents[s].v;
				s += 1;
			}
			maxV = Math.max(curV, maxV);
		}
		
		bw.write(maxV + "");
		bw.flush();
		bw.close();
		br.close();
 	}
}


class Present {
	int p;
	int v;
	Present(int p, int v) {
		this.p = p;
		this.v = v;
	}
}