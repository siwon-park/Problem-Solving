// Joke (7790번)
import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = 0;
		String line;
		while ((line = br.readLine()) != null) {
			for (int i = 0; i < line.length() - 3; i++) {
				if ("joke".equals(line.substring(i, i + 4))) {
					cnt += 1;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
