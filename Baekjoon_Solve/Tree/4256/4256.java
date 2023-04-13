import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void findPostOrder(int leftIn, int rightIn, int leftPre, int rightPre) {
        if (leftIn > rightIn || leftPre > rightPre) return; // 범위가 초과하면 return
        int root = preOrder[leftPre]; // 루트
        int idx = position[root]; // 중위 순회 상 루트의 위치
        int cnt = idx - leftIn; // 좌측 서브 트리의 개수
        findPostOrder(leftIn, idx - 1, leftPre + 1, leftPre + cnt); // 좌측 서브 트리 탐색
        findPostOrder(idx + 1, rightIn, leftPre + cnt + 1, rightPre); // 우측 서브 트리 탐색
        sb.append(root + " ");
    }

    static int T, n; // 테스트 케이스, 노드의 개수
    static int[] preOrder, inOrder, position;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st, st2;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            preOrder = new int[n]; // 전위 순회
            inOrder = new int[n]; // 중위 순회
            position = new int[n + 1]; // 중위 순회 상 루트의 위치
            sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                preOrder[i] = Integer.parseInt(st.nextToken());
                inOrder[i] = Integer.parseInt(st2.nextToken());
                position[inOrder[i]] = i;
            }
            findPostOrder(0, n - 1, 0, n - 1);
            bw.write(sb + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}