// 분리배출 (32980번)
import java.io.*;
import java.util.*;

public class Main {
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long ans = 0;
		ArrayList<String> arrayList = new ArrayList<>();
		for (int i = 0; i < N; i++) arrayList.add(br.readLine());

		int[] price = new int[7];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) price[i] = Integer.parseInt(st.nextToken());
		
		int O = Integer.parseInt(br.readLine());
		price[6] = O;
		
		for (String trash : arrayList) {
			int[] arr = new int[7];
			int len = trash.length();
			for (int i = 0; i < len; i++) {
				char c = trash.charAt(i);
				switch (c) {
					case 'P' : arr[0] += 1;
						break;
					case 'C' : arr[1] += 1;
						break;
					case 'V' : arr[2] += 1;
						break;
					case 'S' : arr[3] += 1;
						break;
					case 'G' : arr[4] += 1;
						break;
					case 'F' : arr[5] += 1;
						break;
					case 'O' : arr[6] += 1;
						break;
				}
			}
			
			boolean isUnique = false;
			int cost = 0;
			for (int i = 0; i < 7; i++) {
				if (arr[i] == len && i != 6) {
					isUnique = true;
					cost = price[i];
				}
			}
			
			if (isUnique) {
				ans += Math.min(len * cost, len * O);
			} else {
				ans += len * O;
			}
		}
		
		System.out.println(ans);
	}
}

