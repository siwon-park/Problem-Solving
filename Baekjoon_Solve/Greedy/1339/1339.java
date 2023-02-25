import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;


public class Main {

    static int pow(int n) {
        int ret = 1;
        for (int i = 0; i < n; i++) {
            ret *= 10;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 단어의 개수
        // 특정 알파벳이 n의 자리에서 많이 등장했으면 더 높은 숫자를 부여해서 계산함
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String words = br.readLine();
            int M = words.length();
            for (int j = 0; j < M; j++) {
                char word = words.charAt(j);
                int n = M - j - 1;
                hashMap.computeIfPresent(word, (k, v) -> v += pow(n));
                hashMap.putIfAbsent(word, pow(n));
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (char key : hashMap.keySet()) {
            int val = hashMap.get(key);
            arrayList.add(val);
        }
        arrayList.sort(Comparator.reverseOrder()); // 역순 정렬
        
        int ans = 0; // 많이 나온 수에 9부터 0까지 숫자를 차례대로 곱해서 ans에 합산함
        int n = 9;
        for (Integer i : arrayList) {
            ans += i * (n--);
        }
        System.out.println(ans);
    }
}