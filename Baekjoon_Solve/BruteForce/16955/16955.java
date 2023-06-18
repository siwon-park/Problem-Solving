// 오목, 이길 수 있을까? (16955번)
import java.io.*;
import java.util.*;

public class Main {
	
	static String[] graph;
	
	static int check() {
		// 행에 대해서 확인
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c <= 5; c++) {
				int dot = 0;
				int xCnt = 0;
				for (int i = 0; i < 5; i++) {
					if (graph[r].charAt(c + i) == 'X') xCnt += 1;
					else if (graph[r].charAt(c + i) == '.') dot += 1;
				}
				if (dot == 1 && xCnt == 4) return 1;
			}
		}
		
		// 열에 대해 확인
		for (int c = 0; c < 10; c++) {
			for (int r = 0; r <= 5; r++) {
				int dot = 0;
				int xCnt = 0;
				for (int i = 0; i < 5; i++) {
					if (graph[r + i].charAt(c) == 'X') xCnt += 1;
					else if (graph[r + i].charAt(c) == '.') dot += 1;
				}
				if (dot == 1 && xCnt == 4) return 1;
			}
		}
		
		// 대각에 대해 확인
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				int dot = 0;
				int xCnt = 0;
				for (int i = 0; i < 5; i++) {
					if (r + i < 10 && c + i < 10) {
						if (graph[r + i].charAt(c + i) == 'X') xCnt += 1;
						else if (graph[r + i].charAt(c + i) == '.') dot += 1;						
					}
				}
				if (dot == 1 && xCnt == 4) return 1;
				dot = 0;
				xCnt = 0;
				for (int i = 0; i < 5; i++) {
					if (r + i < 10 && c - i >= 0) {
						if (graph[r + i].charAt(c - i) == 'X') xCnt += 1;
						else if (graph[r + i].charAt(c - i) == '.') dot += 1;						
					}
				}
				if (dot == 1 && xCnt == 4) return 1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		graph = new String[10];
		for (int i = 0; i < 10; i++) graph[i] = br.readLine();
		
		System.out.println(check());
	}
}