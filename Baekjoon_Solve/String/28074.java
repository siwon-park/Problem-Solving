// 모비스 (28074번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		HashSet<Character> hashSet = new HashSet<>();
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == 'M' || line.charAt(i) == 'O' || line.charAt(i) == 'B' || line.charAt(i) == 'I' || line.charAt(i) == 'S') {
				hashSet.add(line.charAt(i));
			}
		}
		
		if (hashSet.size() == 5) {
			bw.write("YES");
		} else {
			bw.write("NO");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}