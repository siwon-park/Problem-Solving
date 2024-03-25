// 밥 (23559번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, X;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		int total = 0;
		ArrayList<int[]> arrayList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// 일단 모두 1000원짜리 학식을 먹음
			X -= 1000;
			total += B;
			if (A > B) { // A가 B보다 클 때만 리스트에 삽입
				arrayList.add(new int[] {A - B, A, B});				
			}
		}
		
		Collections.sort(arrayList, (o1, o2) -> {
			if (o1[0] < o2[0]) return 1;
			else if (o1[0] > o2[0]) return -1;
			else {
				if (o1[1] < o2[1]) return 1;
				else if (o1[1] > o2[1]) return -1;
				else return Integer.compare(o2[2], o1[2]);
			}
		});
		
		if (X >= 4000) { // 남은 돈이 4000원 이상이면 
			for (int[] info : arrayList) {
				if (X < 4000) break; // 4000원보다 남은 돈이 작으면 break;
				X += 1000;
				X -= 5000;
				total += info[1]; // B를 버리고 A(5000원)를 선택
				total -= info[2];
			}
			bw.write(total + "");
		} else {
			bw.write(total + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}