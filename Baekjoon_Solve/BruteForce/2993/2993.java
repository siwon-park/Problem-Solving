// 세 부분 (2993번)
import java.io.*;
import java.util.*;

public class Main {

	/*
	 * 문자열의 길이 중 2개의 인덱스를 뽑음
	 * */
	static void recur(int k, int s, int[] idx) {
		if (k == 2) {
			int idx1 = idx[0];
			int idx2 = idx[1];
			String str1 = words.substring(0, idx1);
			String str2 = words.substring(idx1, idx2);
			String str3 = words.substring(idx2, N);
			if (str1.length() > 0 && str2.length() > 0 && str3.length() > 0) { // 나눈 문자열의 길이가 0보다 클 경우에만
				StringBuilder sb = new StringBuilder();
				sb.append(new StringBuilder(str1).reverse());
				sb.append(new StringBuilder(str2).reverse());
				sb.append(new StringBuilder(str3).reverse());
				if (fastest.compareTo(sb.toString()) > 0) fastest = sb.toString();				
			}
			return;
		}
		for (int i = s; i < N; i++) {
			idx[k] = i;
			recur(k + 1, i + 1, idx);
			idx[k] = -1;
		}
	}
	
	static int N; // 문자열의 길이
	static String words, fastest; // 원본 문자열, 가장 빠른 문자열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		words = br.readLine();
		N = words.length();
		fastest = words.substring(0, N);
		int[] idx = new int[2];
		Arrays.fill(idx, -1);
		recur(0, 0, idx);
		System.out.println(fastest);
	}
}