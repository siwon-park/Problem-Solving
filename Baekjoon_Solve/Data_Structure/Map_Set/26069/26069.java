import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 기록의 수
        boolean[] isRainbowDance = new boolean[2 * N + 1]; // i번 유저가 무지개 춤을 추고 있음
        HashMap<String, Integer> nameHashMap = new HashMap<>();

        StringTokenizer st;
        int n = 0; // 사람의 번호
        int rainbowDancer = 1; // 총총이는 최소 1회 이상 주어지므로, 무지개 춤을 추는 사람은 1명부터 출발함
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            if (!nameHashMap.containsKey(A)) nameHashMap.put(A, n++);
            if (!nameHashMap.containsKey(B)) nameHashMap.put(B, n++);

            // 만약 A가 총총이거나, 무지개 춤을 추는 사람이면
            if (A.equals("ChongChong") || isRainbowDance[nameHashMap.get(A)]) {
                if (!isRainbowDance[nameHashMap.get(B)] && !B.equals("ChongChong")) { // B가 무지개 춤꾼, 총총이 아니면
                    isRainbowDance[nameHashMap.get(B)] = true;
                    rainbowDancer += 1;
                }
            }
            // 만약 B가 총총이거나, 무지개 춤을 추는 사람이면
            if (B.equals("ChongChong") || isRainbowDance[nameHashMap.get(B)]) {
                if (!isRainbowDance[nameHashMap.get(A)] && !A.equals("ChongChong")) { // A가 무지개 춤꾼, 총총이 아니면
                    isRainbowDance[nameHashMap.get(A)] = true;
                    rainbowDancer += 1;
                }
            }
        }
        System.out.println(rainbowDancer);
    }
}