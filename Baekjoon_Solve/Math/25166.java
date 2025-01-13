// 배고픈 아리의 샌드위치 구매하기 (25166번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 10종류의 돈을 각각 한 개씩 가지고 있음 => 쓸 수 있으면 무조건 씀
		for (int i = 9; i >= 0; i--) {
			int bit = (1 << i);
			if (S >= bit) {
				S -= bit;
			}
		}
		
		if (S == 0) {
			System.out.println("No thanks");
		} else if ((S & M) == S) { // AND 연산 결과가 S라면 M이 S의 모든 비트를 들고 있음
			System.out.println("Thanks");			
		} else {
			System.out.println("Impossible");			
		}
	}
}
