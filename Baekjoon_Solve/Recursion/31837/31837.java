// 시간표 만들기 (31837번)
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static ArrayList<int[]> schedules;
	static ArrayList<int[]>[] courses;
	static int ans = 0;
	
	static void backtrack(int g, int score) {
		if (score > 22) return;
		if (score == 22) {
			// 시간 중복에 대해 체크
			ArrayList<int[]> tmp = new ArrayList<>();
			tmp.addAll(schedules);
			tmp.sort((o1, o2) -> {
				if (o1[3] < o2[3]) return -1;
				else if (o1[3] > o2[3]) return 1;
				else {
					if (o1[0] < o2[0]) return -1;
					else if (o1[0] > o2[0]) return 1;
					else return Integer.compare(o1[1], o2[1]);
				}
			});
			
			int w = 0;
			int last = 0;
			for (int[] info : tmp) {
				if (w == info[3]) {
					if (info[0] >= last) {
						last = info[1];
					} else {
						return;
					}
				} else {
					w = info[3];
					last = info[1];
				}
			}
			ans += 1;
			return;
		}
		if (g >= N) return;
		// g번 그룹에 대해 선택함
		for (int[] info : courses[g]) {
			int s = info[0]; // 시작 시간
			int e = info[1]; // 끝 시간
			int c = info[2]; // 학점
			int d = info[3]; // 요일
			schedules.add(info);
			backtrack(g + 1, score + c);
			schedules.remove(schedules.size() - 1);
		}
		
		// g번 그룹에 대해 선택하지 않음
		backtrack(g + 1, score);
		
		
	}
	
	static int strToInt(String strTime) {
		String[] tmp = strTime.split("\\:");
		return Integer.valueOf(tmp[0]) * 60 + Integer.valueOf(tmp[1]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		courses = new ArrayList[N];
		for (int i = 0; i < N; i++) courses[i] = new ArrayList<>();
		
		schedules = new ArrayList<>();
		
		for (int g = 0; g < N; g++) {
			int A = Integer.parseInt(br.readLine());
			for (int j = 0; j < A; j++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int s = strToInt(st.nextToken());
				int e = strToInt(st.nextToken());
				courses[g].add(new int[] {s, e, c, d});
			}
		}
		
		backtrack(0, 0);
		System.out.println(ans);
	}
}

