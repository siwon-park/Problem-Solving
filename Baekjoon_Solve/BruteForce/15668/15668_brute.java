// 방 번호 (15668번)
import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[] visit;
	
	static boolean check(int a) {
		while (a != 0) {
			if(visit[a % 10]) return false;
			visit[a % 10] = true;
			a /= 10;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		boolean flag = false;
		for(int i = 1; i < N && i < 100000; i++) { // i를 작은수라고 가정하면 i는 5자리를 초과할 수 없음
			visit = new boolean[10];
			if(!check(i)) continue;
			if(!check(N - i)) continue;
			if(i + (N - i) == N) {
				bw.write(i + " + " + (N - i));
				flag = true;
				break;
			}
		}
		if(!flag)
			bw.write("-1");
		
		bw.flush();
		bw.close();
		br.close();
	}
}