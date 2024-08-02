// CD (4158번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) break;
			HashSet<Integer> hashSet = new HashSet<>();
			for (int i = 0; i < N; i++) {
				hashSet.add(Integer.parseInt(br.readLine()));
			}
			
			int ans = 0;
			for (int i = 0; i < M; i++) {
				int cd = Integer.parseInt(br.readLine());
				if (hashSet.contains(cd)) ans += 1; 
			}
			
			bw.write(ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

