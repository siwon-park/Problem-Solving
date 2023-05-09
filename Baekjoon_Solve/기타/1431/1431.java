// 시리얼 번호 (1431번)
import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int m = line.length(); // 문자열의 길이
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if ('A' <= line.charAt(j) && line.charAt(j) <= 'Z') continue;
                else sum += Integer.parseInt(line.charAt(j) + "");
            }

            pairs[i] = new Pair(line, m, sum);
        }

        Arrays.sort(pairs, (o1, o2) -> {
            if (o1.len > o2.len) return 1;
            else if (o1.len < o2.len) return -1;
            else {
                if (o1.sum > o2.sum) return 1;
                else if (o1.sum < o2.sum) return -1;
                return o1.serialNumber.compareTo(o2.serialNumber);
            }
        });

        for (Pair pair : pairs) {
            bw.write(pair.serialNumber + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

class Pair {
    String serialNumber;
    int len; // 길이
    int sum; // 각 자리의 최대 합

    Pair(String serialNumber, int len, int sum) {
        this.serialNumber = serialNumber;
        this.len = len;
        this.sum = sum;
    }
}