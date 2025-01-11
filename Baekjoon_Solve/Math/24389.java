// 2의 보수 (24389번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		// N의 2의 보수는 N의 모든 비트를 반전 (~N) 한 다음 1을 더하면 된다
		int M = N ^ (~N + 1); // 2의 보수와 비트 XOR 연산을 하면 비트가 서로 다르면 1로, 서로 다른 비트를 계산할 수 있다
		
		int cnt = 0;
		for (int i = 32; i >= 0; i--) {
			if ((M & (1 << i)) != 0) { // 시프트 연산 후 AND 연산을 통해서 일치하는 비트 수가 보수와 서로 다른 비트 개수이다.
				cnt += 1;
			}
		}
		
		System.out.println(cnt);
	}
}

