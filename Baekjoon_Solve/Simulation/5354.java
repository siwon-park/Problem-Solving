// J박스 (5354번)
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb = new StringBuilder();
			for (int i = 0; i < N; i++) sb.append("#");
			bw.write(sb.toString() + "\n");
			for (int i = 1; i < N - 1; i++) {
				sb = new StringBuilder();
				sb.append("#");
				for (int j = 1; j < N - 1; j++) {
					sb.append("J");
				}
				sb.append("#");
				bw.write(sb.toString() + "\n");
			}
			if (N > 1) {
				sb = new StringBuilder();
				for (int i = 0; i < N; i++) sb.append("#");
				bw.write(sb.toString() + "\n");				
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

