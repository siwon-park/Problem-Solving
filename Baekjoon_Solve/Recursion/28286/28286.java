// 재채점을 기다리는 중 (28286번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static int[] OMR, ANS;
	static int ans;
	
	/*
	 * p: 현재 위치, k: 당기기/밀기 작업 횟수, cur: 현재 OMR 배열
	 * */
	static void backtrack(int p, int k, int[] cur) {
		if (k == K) {
			int hit = 0;
			for (int i = 1; i < N + 1; i++) {
				if (cur[i] == ANS[i]) hit += 1;
			}
			ans = Math.max(ans, hit);
			return;
		}
		
		int[] pullOMR = new int[N + 2];
		int[] pushOMR = new int[N + 2];
		
		for (int i = 1; i < N + 1; i++) {
			// 기준점 이전까지 복사
			for (int j = 1; j < i; j++) {
				pullOMR[j] = cur[j];
				pushOMR[j] = cur[j];
			}
			pushOMR[i] = 0;; // 현재 문제를 풀지 않음
			for (int j = i + 1; j < N + 1; j++) {
				pullOMR[j - 1] = cur[j];
				pushOMR[j] = cur[j - 1]; 
			}
			
			backtrack(i, k + 1, pullOMR);
			backtrack(i, k + 1, pushOMR);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		ANS = new int[N + 2];
		for (int i = 1; i < N + 1; i++) {
			ANS[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		OMR = new int[N + 2];
		ans = 0;
		for (int i = 1; i < N + 1; i++) {
			OMR[i] = Integer.parseInt(st.nextToken());
			if (OMR[i] == ANS[i]) ans += 1;
		}
		
		backtrack(0, 0, OMR);
		System.out.println(ans);
		
	}
}

