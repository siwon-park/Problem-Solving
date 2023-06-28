// 세 수의 합 (2295번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] U, two; // 집합 U, 두 수의 합
	
	static boolean binarySearch(int target) {
		int s = 0;
		int e = M - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (two[mid] > target) e = mid - 1;
			else if (two[mid] < target) s = mid + 1;
			else return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		U = new int[N];
		for (int i = 0; i < N; i++) U[i] = Integer.parseInt(br.readLine());
		
		// 두 수의 합을 구한다. 두 수는 같은 수일 수도 있다.
		HashSet<Integer> tmp = new HashSet();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) tmp.add(U[i] + U[j]);
		}
		
		M = tmp.size();
		two = new int[M];
		int t = 0;
		for (Integer i : tmp) two[t++] = i;
		Arrays.sort(two); // 이분 탐색을 위한 오름차순 정렬
		
		int k = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int target = U[i] - U[j];
				if (target <= 0) continue;
				boolean flag = binarySearch(target);
				if (flag) k = Math.max(k, U[i]);
			}
		}
		
		bw.write(k + "");
		bw.flush();
		bw.close();
		br.close();
	}
}