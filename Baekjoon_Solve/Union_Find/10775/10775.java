// 공항 (10775번)
import java.io.*;
import java.util.*;

public class Main {

	static int G, P; // 게이트 수, 비행기 수
	static int[] parent;
	static int[] g; // i번 비행기가 1 ~ g번까지 도킹하고자 하는 게이트 번호 g
	
	static int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		g = new int[P];
		for (int i = 0; i < P; i++) g[i] = Integer.parseInt(br.readLine());
		
		parent = new int[G + 1];
		for (int i = 0; i < G + 1; i++) parent[i] = i;
		
		int ans = 0;
		for (int i = 0; i < P; i++) {
			int _g = g[i];
			int nxtIdx = find(_g); // 현재 연결 가능한 공항 게이트 최대 번호
			if (nxtIdx == 0) break;
			parent[nxtIdx] = nxtIdx - 1; // 다음 연결 가능한 공항 번호를 현재 번호 - 1로 기록함
			ans += 1;
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}