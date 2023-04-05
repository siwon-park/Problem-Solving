import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    * leftIn: 중위 순회의 왼쪽, rightIn: 중위 순회의 오른쪽
    * leftPost: 후위 순회의 왼쪽, rightPost: 후위 순회의 오른쪽
    * */
    static void findPreOrder(int leftIn, int rightIn, int leftPost, int rightPost) {
        if (leftIn > rightIn || leftPost > rightPost) return;
        int root = postOrder[rightPost];
        sb.append(root + " ");
        int mid = position[root]; // 중위 순회상 루트의 위치
        findPreOrder(leftIn, mid - 1, leftPost, leftPost - 1 + mid - leftIn);
        findPreOrder(mid + 1, rightIn, leftPost + mid - leftIn, rightPost - 1);
    }

    static int N;
    static int[] inOrder, postOrder, position;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inOrder = new int[N]; // 중위 순회
        postOrder = new int[N]; // 후위 순회
        position = new int[N + 1]; // 중위 순회의 루트 위치

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            postOrder[i] = Integer.parseInt(st2.nextToken());
            position[inOrder[i]] = i;
        }

        sb = new StringBuilder();
        findPreOrder(0, N -1, 0, N - 1);
        System.out.println(sb.toString());
    }
}