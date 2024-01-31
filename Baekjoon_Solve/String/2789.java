// 유학 금지 (2789번)
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == 'C' || c == 'A' || c == 'M' || c == 'B' || c == 'R' || c == 'I' || c == 'D' || c == 'G' || c == 'E') continue;
			sb.append(c);
		}
		
		System.out.println(sb.toString());
	}
}

