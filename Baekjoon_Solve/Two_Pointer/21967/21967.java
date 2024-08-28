// 세워라 반석 위에 (21967번)
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int[] count = new int[11];
		int s = 0;
		int e = 0;
		count[arr[s]] += 1;
		int min = arr[s];
		int max = arr[s];
		int len = 1;
		while (s <= e && e < N) {
			if (max - min <= 2) {
				len = Math.max(len, e - s + 1);
				e += 1;
				if (e < N) {
					count[arr[e]] += 1;
					if (count[arr[e]] == 1) {
						max = 0;
						min = 11;
						for (int i = 1; i < 11; i++) {
							if (count[i] != 0) {
								max = Math.max(max, i);
								min = Math.min(min, i);
							}
						}
					}
				}
			} else {
				count[arr[s]] -= 1;
				if (count[arr[s]] == 0) {
					max = 0;
					min = 11;
					for (int i = 1; i < 11; i++) {
						if (count[i] != 0) {
							max = Math.max(max, i);
							min = Math.min(min, i);
						}
					}
				}
				s += 1;
			}
		}
		
		System.out.println(len);
	}
}

