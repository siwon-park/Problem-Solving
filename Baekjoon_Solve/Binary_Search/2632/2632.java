// 피자판매
import java.io.*;
import java.util.*;

public class Main {
	
	static int t, m, n, mSize, nSize;
	static int[] pizzaA, pizzaB;
	
	static int lowerBound(int[] arr, int end, int target) {
		int idx = end; // arr의 최대 크기
		int s = 0;
		int e = end - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] >= target) {
				idx = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		
		return idx;
	}
	
	static int upperBound(int[] arr, int end, int target) {
		int idx = end;
		int s = 0;
		int e = end - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] <= target) {
				s = mid + 1;
			} else {
				e = mid - 1;
				idx = mid;
			}		
		}
		return idx;
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		t = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		// 원형이기 때문에 크기를 2배로 선언
		pizzaA = new int[m * 2];
		pizzaB = new int[n * 2];
		
		int totalA = 0; // 나중에 전체의 합만 따로 넣기 위함
		for (int i = 0; i < m; i++) {
			pizzaA[i] = Integer.parseInt(br.readLine());
			pizzaA[i + m] = pizzaA[i];
			totalA += pizzaA[i];
		}
		
		int totalB = 0;
		for (int i = 0; i < n; i++) {
			pizzaB[i] = Integer.parseInt(br.readLine());
			pizzaB[i + n] = pizzaB[i];
			totalB += pizzaB[i];
		}
		
		// 한 종류에서 2조각 이상 판매할 때는 반드시 연속된 조각들을 잘라야 한다고 했으므로 나올 수 있는 모든 누적합의 경우를 구함
		ArrayList<Integer> listA = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = i; j < i + m - 1; j++) { // 원형이니 중복을 피하기 위해 조각 수 - 1개까지만 누적함
				sum += pizzaA[j];
				listA.add(sum);
			}
		}
		listA.add(0); // 피자를 한쪽에서만 고르는 경우가 있으므로 0을 추가해 줌
		listA.add(totalA); // 피자 한 판의 합 추가
		
		ArrayList<Integer> listB = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < i + n - 1; j++) { // 원형이니 중복을 피하기 위해 조각 수 - 1개까지만 누적함
				sum += pizzaB[j];
				listB.add(sum);
			}
		}
		listB.add(0);
		listB.add(totalB);
		
		// 누적합을 통해 나올 수 있는 모든 경우의 수를 배열에 담음
		pizzaA = new int[listA.size()];
		pizzaB = new int[listB.size()];
		for (int i = 0; i < listA.size(); i++) pizzaA[i] = listA.get(i);
		for (int i = 0; i < listB.size(); i++) pizzaB[i] = listB.get(i);
 
		// 정렬
		Arrays.sort(pizzaA);
		Arrays.sort(pizzaB);
		
		int mSize = pizzaA.length;
		int nSize = pizzaB.length;
		
		long ans = 0;
		for (int i = 0; i < mSize; i++) {
			int curSum = pizzaA[i]; // pizzaA의 부분 합
			if (curSum > t) break; // 구매를 원하는 피자 크기보다 크면 탐색하지 않음
			int lowerIdx = lowerBound(pizzaB, nSize, t - curSum);
			if (lowerIdx == nSize) continue;
			int upperIdx = upperBound(pizzaB, nSize, t - curSum);
			if (pizzaB[lowerIdx] == t - curSum && pizzaB[upperIdx - 1] == t - curSum) {
				ans += upperIdx - lowerIdx;
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}