import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            hashMap.computeIfPresent(arr[i], (k, v) -> v + 1);
            hashMap.putIfAbsent(arr[i], 1);
            hashSet.add(arr[i]);
        }

        Arrays.sort(arr);
        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (i == j) continue;
                int a = arr[i] - arr[j];
                if (hashSet.contains(a)) {
                    // 부합하지 않는 조건일 경우 continue
                    if (a == arr[j] && hashMap.get(a) < 2) continue;
                    if (a == arr[i] && hashMap.get(a) <= 2) continue;
                    cnt += 1;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}