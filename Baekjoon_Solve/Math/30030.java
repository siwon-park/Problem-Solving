// 스위트콘 가격 구하기 (30030번)
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int B = Integer.parseInt(br.readLine());
		bw.write((B - B / 11) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}