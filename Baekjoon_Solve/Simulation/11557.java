// Yangjojang of The Year (11557번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int T, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			int maxL = -1;
			String YOTY = "";
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String school = st.nextToken();
				int L = Integer.parseInt(st.nextToken());
				if (L > maxL) {
					maxL = L;
					YOTY = school;
				}
			}
			
			bw.write(YOTY + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}