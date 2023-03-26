import java.io.*;
import java.util.*;


public class Main {

    static int n, k; // 노드 수, 사촌의 수를 구하는 노드 번호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if (n == 0 && k == 0) break;

            int[] arr = new int[n]; // 순열
            int[] parent = new int[n]; // 부모 배열

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(st.nextToken()); // 순열
                parent[i] = i; // 부모 배열 초기화
                arr[i] = a;
            }

            int last = arr[0]; // 마지막 숫자
            int p = -1; // 부모 번호 => -1부터 시작, 0번 노드에 대해 삽입하기 위함
            int[] level = new int[n]; // 트리의 레벨
            int k_idx = 0; // 사촌을 찾아야할 숫자의 트리 상의 노드 번호
            for (int i = 1; i < n; i++) {
                if (arr[i] == k) k_idx = i;
                if (last + 1 < arr[i]) { // 연속된 숫자가 아니면
                    parent[i] = ++p; // 부모를 증가시키고, 현재 노드의 부모를 기록
                    level[i] = level[p] + 1; // 부모의 레벨 + 1로 기록
                } else { // 연속된 숫자면
                    parent[i] = p; // 현재 노드의 부모를 기록
                    level[i] = level[p] + 1; // 부모의 레벨 + 1로 기록
                }
                last = arr[i];
            }

            // 사촌의 수는 부모의 부모가 같으면서 나와 레벨이 같은 노드임
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (parent[i] == parent[k_idx]) continue; // 부모가 같다면 continue
                if (level[i] == level[k_idx] && parent[parent[i]] == parent[parent[k_idx]]) cnt += 1;
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}