// 어두운 굴다리 (17266번)
//////////////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/17266
  // 이분탐색, 스위핑
  // 이분탐색으로 문제를 풀었다.
  // M + 2 크기의 배열을 선언하고, 0번째 인덱스에는 0, M + 1번째 인덱스에는 N을 넣고,
  // 이분탐색으로 찾고자하는 높이 값을 더하거나 빼서, 자기보다 +-1 인덱스 범위 (+-높이값)을 커버할 수 있는지
  // if-else 조건에 따라서 처리를 해주고, 모두 다 커버 가능할 경우 목표 높이를 줄이고, 그렇지 않을 경우 목표 높이를 높이는 방식을 사용했다.
  // 그런데 스위핑 기법으로 간단하게 풀 수도 있나보다. 가장 빈 공간을 찾는 것을 목표로 스위핑하면 되는 듯하다.
//////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int binarySearch() {
        int h = 0;
        int s = 1;
        int e = N;
        while (s <= e) {
            int mid = (s + e) / 2;
            boolean flag = true;
            for (int i=1; i<M+1; i++) {
                if (i == 1) {
                    if (x[i] - mid > x[i - 1]) {
                        flag = false;
                        break;
                    }
                } if (i == M) {
                    if (x[i] + mid < x[i + 1]) {
                        flag = false;
                        break;
                    }
                } else {
                    if (x[i] - mid > x[i - 1] + mid || x[i] + mid < x[i + 1] - mid) {
                        flag = false;
                        break;
                    }
                }

            }

            if (flag) {
                e = mid - 1;
                h = mid;
            } else {
                s = mid + 1;
            }
        }

        return h;
    }

    static int N;
    static int M;
    static int[] x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        x = new int[M + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<M+1; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        x[0] = 0;
        x[M + 1] = N;

        int ret = binarySearch();
        System.out.println(ret);
        br.close();
    }
}
/////////////////////////////////////////////////////////////////////////////////////
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int tmp = 0;
		for (int i = 0; i < M; i++) {
			int in = Integer.parseInt(st.nextToken());
			if (M == 1) { max = N-in > in ? N-in : in; break; }
			if (i == 0) { max = in > max ? in:max; tmp = in; continue; }
			int gap = in - tmp;
			tmp = in;
			max = gap / 2 + gap % 2 > max ? gap / 2 + gap % 2 : max;
			if (i == M-1) { max = N - in > max ? N - in : max; }
		}
		bw.write(max + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
