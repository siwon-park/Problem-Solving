// 라디오 (3135번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		
		int minPress = Math.abs(A - B);
		for (int i = 0; i < N; i++) {
			int remember = Integer.parseInt(br.readLine());
			minPress = Math.min(1 + Math.abs(remember - B), minPress);
		}
		
		bw.write(minPress + "");
		bw.flush();
		bw.close();
		br.close();
	}
}