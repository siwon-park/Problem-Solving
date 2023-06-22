// 캠핑 (4796번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = 1;
		int l, p, v;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			if (l == 0 && p == 0 && v == 0) break;
			
			int ret = 0;
			ret += (v / p) * l;
			if (l >= v % p) ret += v % p;
			else ret += l;
			
			bw.write(String.format("Case %d: ", t));
			bw.write(ret + "\n");
			t += 1;
		}
		
		bw.flush();
		br.close();
		bw.close();
	}	
}