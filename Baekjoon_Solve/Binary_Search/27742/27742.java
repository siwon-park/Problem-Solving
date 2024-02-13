// 월드컵 조별리그 (27742번)
import java.io.*;
import java.util.*;

public class Main {

	static int T, r, c;
	static long K;
	static long[][] arr = new long[4][4];

	static boolean check(int t, int r1, int c1, long k) {
		arr[r1][c1] = k;
		boolean[] chk = new boolean[4];
		ArrayList<Pair> pairs = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			Pair pair = new Pair(0, 0, 0, i);
			for (int j = 0; j < 4; j++) {
				pair.g += arr[i][j];
				pair.gd += arr[j][i];
				if (arr[i][j] > arr[j][i]) { // 승리
					pair.s += 3;
				} else if (arr[i][j] == arr[j][i]) { // 무승부
					pair.s += 1;
				}
			}
			pair.gd = pair.g - pair.gd;
			pairs.add(pair);
		}
		
		// 정렬 -> 승점, 골득실, 다득점, 상대전적 우선
		Collections.sort(pairs, (o1, o2) -> {
			if (o1.s < o2.s) return 1;
			else if (o1.s > o2.s) return -1;
			else {
				if (o1.gd < o2.gd) return 1;
				else if (o1.gd > o2.gd) return -1;
				else {
					if (o1.g < o2.g) return 1;
					else if (o1.g > o2.g) return -1;
					else return Integer.compare(o1.t, o2.t);
				}
			}
		});
		
		arr[r1][c1] = -1;
		chk[pairs.get(0).t] = true;
		chk[pairs.get(1).t] = true;
		return chk[t - 1];
	}
	
	static long binarySearch() {
		long ans = -1;
		long s = 0;
		long e = K + 2;
		while (s <= e) {
			long mid = (s + e) >> 1;
			boolean flag = check(T, r, c, mid);
			if (flag) {
				e = mid - 1;
				ans = mid;
			} else {
				s = mid + 1;
			}
		}
		
		return (ans > K) ? -1 : ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		r = 0;
		c = 0;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Long.parseLong(st.nextToken());
				if (arr[i][j] == -1) {
					r = i;
					c = j;
				}
			}
		}
		
		long ans = binarySearch();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int s;
	long gd, g;
	int t;
	
	Pair(int s, long gd, long g, int t) {
		this.s = s;
		this.gd = gd;
		this.g = g;
		this.t = t;
	}
}