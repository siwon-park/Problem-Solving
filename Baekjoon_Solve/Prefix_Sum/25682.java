// 체스판 다시 칠하기 2 (25682번)
///////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/25682
  // 누적합
  // 잘 풀었다고 생각했으나, 메모리와 속도면에서 매우 비효율적으로 풀었다.
  // 색이 잘못 색칠된 개수를 누적한 누적 배열을 만들어서 최솟값을 찾는게 핵심이다.
  // 나는 올바른 경우가 2가지이니, 잘못 색칠된 개수를 누적하는 배열도 2개 만들고, KxK 그리드에 대해서 구간 누적합의 최솟값을 찾아 반환했다.
  // 그런데 그럴 필요 없이 잘못된 경우는 1가지만 고려하고, 어차피 다른 한 경우는 반전하면 되니까
  // 구간 누적합의 최솟값과 최댓값을 찾아서, min(k*k - 최댓값, 최솟값)을 찾으면 된다. (아래 효율적인 풀이 참조)
///////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열
        int K = Integer.parseInt(st.nextToken()); // KxK 보드

        int[][] dpB = new int[N + 1][M + 1]; // 좌상단 검은색 시작
        int[][] dpW = new int[N + 1][M + 1]; // 좌상단 흰색 시작

        /*
        바꿔야하는 최소 사각형 => 잘못된 개수를 누적
        좌상단 검은색 시작 => 올바른 경우: 행이 홀수일 때, 짝수 열이 흰색 / 행이 짝수일 때 홀수열이 흰색
        좌상단 흰색 시작 => 올바른 경우: 행이 홀수일 때, 짝수 열이 검은색 / 행이 짝수일 때 홀수열이 검은색
        반대 경우(올바른 색이 오지 않은 경우)에 대해 누적합 배열을 만듦
        KxK 그리드에서 구간 누적합을 계산해서 최솟값을 반환
        */

        String[][] graph = new String[N][M];
        for (int i=0; i<N; i++) {
            graph[i] = br.readLine().split("");
        }

        for (int i=1; i<N+1; i++) {
            for (int j=1; j<M+1; j++) {
                if (i % 2 == 1 && j % 2 == 0) {
                    if (graph[i - 1][j - 1].equals("B")) {
                        dpB[i][j] += 1;
                    } else {
                        dpW[i][j] += 1;
                    }
                } else if (i % 2 == 0 && j % 2 == 1) {
                    if (graph[i - 1][j - 1].equals("B")) {
                        dpB[i][j] += 1;
                    } else {
                        dpW[i][j] += 1;
                    }
                } else if (i % 2 == 1 && j % 2 == 1) {
                    if (graph[i - 1][j - 1].equals("W")) {
                        dpB[i][j] += 1;
                    } else {
                        dpW[i][j] += 1;
                    }
                } else {
                    if (graph[i - 1][j - 1].equals("W")) {
                        dpB[i][j] += 1;
                    } else {
                        dpW[i][j] += 1;
                    }
                }
                dpB[i][j] += (dpB[i - 1][j] + dpB[i][j - 1] - dpB[i - 1][j - 1]);
                dpW[i][j] += (dpW[i - 1][j] + dpW[i][j - 1] - dpW[i - 1][j - 1]);
            }
        }

        int ans = 4000001;
        for (int i=N; i>=K; i--) {
            for (int j=M; j>=K; j--) {
                int preSumB = dpB[i][j] - dpB[i - K][j] - dpB[i][j - K] + dpB[i - K][j - K];
                int preSumW = dpW[i][j] - dpW[i - K][j] - dpW[i][j - K] + dpW[i - K][j - K];
                int min_v = Math.min(preSumB, preSumW);
                ans = Math.min(ans, min_v);
            }
        }

        System.out.println(ans);
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] ws = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			for(int j = 1; j <= M; j++) {
				ws[i][j] = ws[i-1][j] + ws[i][j-1] - ws[i-1][j-1];
				char c = str.charAt(j-1);
				if ((i - j) % 2 == 0 && c == 'B') ws[i][j]++;
				if ((i - j) % 2 != 0 && c != 'B') ws[i][j]++;
			}
		}
		int max = 0, min = Integer.MAX_VALUE;
		for(int i = 1; i <= N-K+1; i++) {
			for(int j = 1; j <= M-K+1; j++) {
				int res = ws[i+K-1][j+K-1] - ws[i-1][j+K-1] - ws[i+K-1][j-1] + ws[i-1][j-1];
				if (res < min) min = res;
				if (res > max) max = res;
			}
		}
		System.out.print(Math.min(K*K-max, min));
	}
}
