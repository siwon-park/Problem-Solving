import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] arr = {1, 2, 3, 4, 5, 4, 3, 2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		System.out.println(arr[(n - 1) % 8]);
	}
}
