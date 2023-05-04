// 음악 프로그램 (2623번)
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M; // 기수의 수, 보조 PD의 수
    static int[] indegree; // 진입 차수 배열
    static ArrayList<ArrayList<Integer>> graph; // 그래프

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());

        int P;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken()); // PD가 선택한 개수
            int[] arr = new int[P];
            for (int j = 0; j < P; j++) arr[j] = Integer.parseInt(st.nextToken());
            if (P >= 2) { // 2이상인 것에 대해서만 기록 -> 1일 경우 어차피 진입차수에 영향 없음
                for (int j = 1; j < P; j++) { // 배열의 맨 앞도 역시나 진입 차수는 기본적으로 0임
                    indegree[arr[j]] += 1;
                    graph.get(arr[j - 1]).add(arr[j]);
                }
            }
        }

        // 진입 차수가 0인 숫자를 큐에 삽입
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        int cnt = 0; // N개의 순서를 정할 수 있음
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt += 1;
            bw.write(cur + "\n");
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int nxt = graph.get(cur).get(i);
                indegree[nxt] -= 1;
                if (indegree[nxt] == 0) queue.add(nxt);
            }
        }

        if (cnt == N) { // 순서를 정할 수 있을 때만 그 순서를 출력함
            bw.flush();
        } else {
            System.out.println(0);
        }
        bw.close();
        br.close();
    }
}