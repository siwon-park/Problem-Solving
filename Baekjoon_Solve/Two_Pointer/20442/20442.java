// ㅋㅋ루ㅋㅋ(20442번)
import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer> reverse(ArrayList<Integer> arrayList) {
		ArrayList<Integer> reversed = new ArrayList<>();
		int n = arrayList.size();
		for (int i = n - 1; i >= 0; i--) {
			reversed.add(arrayList.get(i));
		}
		return reversed;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		int N = line.length();
		ArrayList<Integer> leftK = new ArrayList<>(); // 현재 R에서 왼쪽에 있는 k의 누적 개수
		ArrayList<Integer> rightK = new ArrayList<>(); // 현재 R에서 오른쪽에 있는 k의 누적 개수
		
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			if (line.charAt(i) == 'R') {
				leftK.add(cnt1);
			} else {
				cnt1++; // k의 수를 증가
			}
			if (line.charAt(N - 1 - i) == 'R') {
				rightK.add(cnt2);
			} else {
				cnt2++;
			}
		}
		
		rightK = reverse(rightK);
		
		// 각 인덱스에 R이 존재 -> 인덱스만으로 사이에 있는 R의 개수를 알 수 있음
		int s = 0;
		int e = rightK.size() - 1;
		int kkrkk = 0;
		while (s <= e) {
			int left = leftK.get(s);
			int right = rightK.get(e);
			kkrkk = Math.max(kkrkk, (e - s + 1) + Math.min(left, right) * 2);
			if (left < right) {
				s += 1;
			} else {
				e -= 1;
			}
		}
		
		bw.write(kkrkk + "");
		bw.flush();
		bw.close();
		br.close();
	} 
}