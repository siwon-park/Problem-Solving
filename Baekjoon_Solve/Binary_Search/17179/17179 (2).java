// 케이크 자르기 (17179번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, M, L;
	static int[] arr;
	
	static int binarySearch(int Q) {
		int l = 0;
		int s = 1; // 나올 수 있는 가장 작은 조각
		int e = L; // 나올 수 있는 가장 큰 조각
		while (s <= e) {
			int mid = (s + e) >> 1; // 최대 mid 크기로 자름
			int cnt = -1; // 자른 횟수 -> 가장 끝에서도 자른다고 가정하므로 -1부터 시작
			int cut = 0; // 현재 잘라진 크기
			for (int i = 1; i < M + 2; i++) {
				// 새로 자른 부분을 현재 자른 크기에 더했을 때 mid보다 작을 경우 잘라서 이어 붙임 
				if (cut + arr[i] - arr[i - 1] < mid) {
					cut += arr[i] - arr[i - 1];
				} else {
					cnt += 1;
					cut = 0;
				}
			}
			if (cnt >= Q) { // 자른 횟수가 Q개 이상이면 최소 크기를 mid값으로 자를 수 있음 -> 크기를 늘려서 탐색함
				s = mid + 1;
				l = mid;
			} else { // 자른 횟수가 Q개 보다 작다면 최소 크기를 줄여서 탐색함
				e = mid - 1;
			}
			
		}
		return l;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	     
		N = Integer.parseInt(st.nextToken()); // 쿼리 수
		M = Integer.parseInt(st.nextToken()); // 자를 지점의 수
		L = Integer.parseInt(st.nextToken()); // 롤 케익의 길이
		
		arr = new int[M + 2]; // 시작과 끝을 넣기 위함
		arr[0] = 0;
		arr[M + 1] = L;
		for (int i = 1; i < M + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < N; i++) {
			int q = Integer.parseInt(br.readLine());
			int ans = binarySearch(q);
			bw.write(ans + "\n");
		}
	    
		bw.flush();
		bw.close();
		br.close();
	}
}