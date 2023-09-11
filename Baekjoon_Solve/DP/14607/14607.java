// 피자 (Large) (14607번)
import java.io.*;
import java.util.*;

public class Main {

	static long N;
	static HashMap<Long, Long> hashMap;
	
	static long recur(long n) {
		if (hashMap.get(n) != null) return hashMap.get(n);
		long ret = 0;
		if (n % 2 == 0) {
			ret = (n / 2) * (n / 2) + recur(n / 2) * 2;
		} else {
			ret = (n / 2) * ((n + 1) / 2) + recur(n / 2) + recur(((n + 1) / 2));
		}
		hashMap.put(n, ret);
		return hashMap.get(n);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Long.parseLong(br.readLine());
		hashMap = new HashMap<>();
		hashMap.put(0L, 0L);
		hashMap.put(1L, 0L);
		hashMap.put(2L, 1L);
		
		recur(N);
		
		bw.write(hashMap.get(N) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}