// 이 문제는 D2 입니다. (23303번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		if (line.contains("d2") || line.contains("D2")) {
			bw.write("D2");
		} else {
			bw.write("unrated");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
