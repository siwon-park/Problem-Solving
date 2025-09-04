import java.io.*;
import java.util.*;

// 학번 (3711번)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int G = Integer.parseInt(br.readLine());
            int[] arr = new int[G];
            for (int j = 0; j < G; j++) arr[j] = Integer.parseInt(br.readLine());
            int m = 0;
            Set<Integer> hashSet = new HashSet<>();
            while (hashSet.size() != G) {
                hashSet.clear();
                m++;
                for (int j = 0; j < G; j++) {
                    hashSet.add(arr[j] % m);
                    if (hashSet.size() != j + 1) break;
                }
            }
            System.out.println(m);
        }
    }
}
