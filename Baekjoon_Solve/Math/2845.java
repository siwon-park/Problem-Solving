// 파티가 끝나고 난 뒤 (2845번)
import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int total = L * P;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			int part = Integer.parseInt(st.nextToken());
			bw.write((part - total) + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}