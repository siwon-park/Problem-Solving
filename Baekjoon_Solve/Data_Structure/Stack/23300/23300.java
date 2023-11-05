// 웹 브라우저 2 (23300번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, Q;
	static Deque<Integer> backward = new LinkedList<>(); // 뒤로 가기 -> 압축을 위해 데크 사용
	static Stack<Integer> forward = new Stack<>(); // 앞으로 가기
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		boolean isFirst = true; // 처음 접속 유무
		int cur = 0; // 현재 접속중인 페이지
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			String X = st.nextToken(); // 명령
			if (X.equals("B")) {
				if (backward.isEmpty()) continue; // 뒤로 가기 공간이 없으면 무시
				forward.add(cur); // 현재 페이지를 앞으로 가기 공간에 저장
				cur = backward.pollLast(); // 뒤로 가기 공간에서 방문한지 가장 최근의 페이지로 변경
			} else if (X.equals("F")) {
				if (forward.isEmpty()) continue; // 앞으로 가기 공간이 없으면 무시
				backward.add(cur); // 현재 페이지를 뒤로 가기 공간에 저장
				cur = forward.pop(); // 앞으로 가기 공간에서 방문한지 가장 최근의 페이지로 변경
			} else if (X.equals("A")) {
				forward.clear(); // 앞으로 가기 공간을 날림
				int nxt = Integer.parseInt(st.nextToken()); // 다음 접속할 페이지
				if (isFirst) { // 첫 접속일 경우
					cur = nxt;
					isFirst = false;
				} else {
					backward.add(cur); // 현재 페이지를 뒤로 가기에 추가
					cur = nxt; // 현재 페이지를 다음 페이지로 갱신
				}
			} else if (X.equals("C")) { // 압축
				// 뒤로 가기 공간에서 같은 번호 페이지가 연속될 경우 하나만 남기고 지움
				int last = -1; // 데크에서 뽑은 최근의 수
				int m = backward.size(); // 현재 데크의 크기만큼 반복 순회
				for (int j = 0; j < m; j++) {
					int tmp = backward.pollFirst(); // 데크의 맨 앞의 숫자를 뽑음
					if (last != tmp) { // 연속된 숫자가 나오지 않았을 경우에만 데크의 뒤로 삽입
						backward.add(tmp);
					}
					last = tmp;
				}
			}
		}
		
		bw.write(cur + "\n"); // 현재 보고 있는 페이지
		
		if (backward.isEmpty()) { // 뒤로 가기 공간이 없다면 -1
			bw.write("-1\n");
		} else {
			StringBuilder sb = new StringBuilder();
			while (!backward.isEmpty()) {
				sb.append(backward.pollLast());
				sb.append(" ");
			}
			sb.append("\n");
			bw.write(sb.toString());
		}
		
		if (forward.isEmpty()) { // 앞으로 가기 공간이 없다면 -1
			bw.write("-1\n");
		} else {
			StringBuilder sb = new StringBuilder();
			while (!forward.isEmpty()) {
				sb.append(forward.pop());
				sb.append(" ");
			}
			sb.append("\n");
			bw.write(sb.toString());
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}