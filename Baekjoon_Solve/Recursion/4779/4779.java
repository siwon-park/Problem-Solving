import java.io.*;


public class Main {

    /*
     * 문자열을 삼등분하여 문자열의 길이가 1이 될 때까지 분할정복을 계속함
     * */
    static void recur(int s, int n) { // s: 시작점, n: 문자열의 길이
        if (n == 1) {
            return;
        }
        int nxtSize = n / 3;
        for (int i=s + nxtSize; i<s + 2 * nxtSize; i++) {
            arr[i] = ' ';
        }
        recur(s, nxtSize);
        recur(s + 2 * nxtSize, nxtSize);
    }

    /*
     * 3의 제곱수를 구하는 함수
     * */
    static int pow(int n) {
        int ret = 1;
        for (int i=0; i<n; i++) {
            ret *= 3;
        }
        return ret;
    }

    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = "";
        while ((S = br.readLine()) != null) { // EOF 처리
            int N = Integer.parseInt(S);
            int number = pow(N);
            // 미리 배열을 만들어 놓고 빈 공간 채우기
            arr = new char[number];
            for (int i=0; i<number; i++) {
                arr[i] = '-';
            }
            recur(0, number);
            for (int i=0; i<number; i++) {
                bw.write(arr[i]);
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}