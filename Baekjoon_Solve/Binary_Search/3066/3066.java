import java.io.*;


public class Main {

    /*
    * upperBound나 lowerBound 함수 구현할 때, Java는 LIS의 길이를 매개 변수로 넣어야 함을 잊지 말자
    * */
    static int upperBound(int[] arr, int target, int len) {
        int s = 0;
        int e = len;
        int idx = e + 1;
        while (s <= e) {
            int mid = (s + e) >> 1;
            if (arr[mid] >= target) {
                e = mid - 1;
                idx = mid;
            } else {
                s = mid + 1;
            }
        }
        return idx;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine()); // 배열의 길이
            int[] k = new int[N]; // 배열
            for (int i = 0; i < N; i++) {
                k[i] = Integer.parseInt(br.readLine());
            }

            int[] lis = new int[N]; // 가장 긴 증가하는 부분 수열(LIS)
            lis[0] = k[0];
            int l = 1; // LIS의 길이
            for (int i = 1; i < N; i++) {
                if (lis[l - 1] < k[i]) { // LIS의 마지막 요소가 k[i]보다 작다면
                    lis[l++] = k[i]; // LIS의 마지막 요소를 k[i]으로 하고, LIS의 길이를 증가시킨다.
                } else { // 그게 아니라면
                    int idx = upperBound(lis, k[i], l - 1); // LIS에서 k[i]가 들어갈 곳을 찾는다.
                    lis[idx] = Math.min(k[i], lis[idx]); // 찾은 인덱스에 k[i]를 넣는다.
                }
            }
            bw.write(l + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}