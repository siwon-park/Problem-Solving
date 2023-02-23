import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int N, d, k, c; // 접시 수, 초밥 종류, 연속해서 먹는 수, 쿠폰 번호
    static int[] foods ,counts; // 초밥의 종류 배열, 등장 횟수 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        foods = new int[2 * N];
        counts = new int[d + 1];
        for (int i = 0; i < N; i++) {
            foods[i] = Integer.parseInt(br.readLine());
            foods[i + N] = foods[i];
        }

        int eat = 0; // 먹을 수 있는 초밥의 종류

        for (int i = 0; i < k; i++) {
            if (counts[foods[i]] == 0) { // 처음 등장하는 초밥이면 먹을 수 있는 종류수 추가
                counts[foods[i]] += 1;
                eat += 1;
            } else {
                counts[foods[i]] += 1;
            }
        }

        int s = 0;
        int e = k - 1;
        int curEat = eat;
        eat += counts[c] == 0 ? 1 : 0; // 추가로 현재 먹을 수 있으면 증가
        while (e + 1 < 2 * N) {
            e += 1; // 끝 포인트를 오른쪽으로 옮김
            counts[foods[e]] += 1; // 끝 포인터 위치의 초밥 카운트 수 증가
            curEat += counts[foods[e]] == 1 ? 1 : 0; // 끝 포인터의 초밥 카운트가 1이면 새로운 종류이기 때문에 종류를 추가
            curEat -= counts[foods[s]] == 1 ? 1 : 0; // 시작 포인터의 초밥 카운트가 1이면 시작 포인터를 옮기면 초밥 종류가 줄어듦
            counts[foods[s]] -= 1;
            s += 1; // 시작 포인터를 옮김
            eat = Math.max(eat, curEat + ((counts[c] == 0) ? 1 : 0));
        }
        System.out.println(eat);
    }
}