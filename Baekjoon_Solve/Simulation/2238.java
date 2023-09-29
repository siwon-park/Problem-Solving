// 경매 (3135번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int U, N;
	static int[] count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int U = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		count = new int[U + 1];
		
		int _min = 100_001; // 최소 제시 수
		HashMap<Integer, String> nameHashMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int offer = Integer.parseInt(st.nextToken());
			count[offer] += 1;
			if (nameHashMap.get(offer) == null) {
				nameHashMap.put(offer, name);
			}
		}
		
		String bidder = "";
		int bidPrice = 100_001;
		for (int i = 1; i < U + 1; i++) {
			if (count[i] > 0 && count[i] < _min) {
				_min = count[i];
				bidder = nameHashMap.get(i);
				bidPrice = i;
			}
		}
		
		bw.write(bidder + " " + bidPrice);
		bw.flush();
		bw.close();
		br.close();
	}
}