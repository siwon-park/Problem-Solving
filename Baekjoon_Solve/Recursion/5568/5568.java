import java.io.*;
import java.util.HashSet;

public class Main {

    static void backtrack(int k, int bit, String num) {
        if (k == K) {
            hashSet.add(num);
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((bit & (1 << i)) == 0) {
                backtrack(k + 1, bit | (1 << i), num + arr[i]);
            }
        }
    }

    static int N, K; // 카드의 수, 선택하는 수
    static HashSet<String> hashSet;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new String[N];
        hashSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        backtrack(0, 0, "");

        System.out.println(hashSet.size());
    }
}