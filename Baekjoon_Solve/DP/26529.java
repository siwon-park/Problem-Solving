// Bunnies (26529번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int[] memo;
	
	static int recur(int n) {
		if (memo[n] != 0) return memo[n];
		if (n <= 1) return memo[n];
		int ret = recur(n - 1) + recur(n - 2);
		memo[n] = ret;
		return memo[n];
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		memo = new int[46];
		memo[0] = 1;
		memo[1] = 1;
		recur(45);
		
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			int x = Integer.parseInt(br.readLine());
			bw.write(memo[x] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
 	}
}