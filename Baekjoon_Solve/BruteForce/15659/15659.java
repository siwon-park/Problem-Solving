import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static void backtracking(int idx, Stack<Integer> stack1, Stack<Integer> stack2) {
        // 조건부 호출 종료
        if (idx == N) {
            int n = stack2.size();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            Stack<Integer> tmpStack1 = (Stack<Integer>) stack1.clone();
            Stack<Integer> tmpStack2 = (Stack<Integer>) stack2.clone();

            while (n-- > 0) {
                arr1[n] = tmpStack1.pop();
                arr2[n] = tmpStack2.pop();
            }
            int ret = tmpStack1.pop();
            for (int i=0; i<stack2.size(); i++) {
                int opt = arr2[i];
                if (opt == 1) {
                    ret += arr1[i];
                } else {
                    ret -= arr1[i];
                }
            }

            MIN = Math.min(MIN, ret);
            MAX = Math.max(MAX, ret);
            return;
        }

        // 곱셈일 경우
        if (operator[2] > 0) {
            operator[2] -= 1;
            // 스택의 마지막 숫자를 뽑아서 곱한 다음 넣음
            int num = stack1.pop();
            stack1.push(num * A[idx]);
            backtracking(idx + 1, stack1, stack2);
            stack1.pop();
            stack1.push(num);
            operator[2] += 1;
        }

        // 나눗셈일 경우
        if (operator[3] > 0) {
            operator[3] -= 1;
            // 스택의 마지막 숫자를 뽑아서 곱한 다음 넣음
            int num = stack1.pop();
            stack1.push(num / A[idx]);
            backtracking(idx + 1, stack1, stack2);
            stack1.pop();
            stack1.push(num);
            operator[3] += 1;
        }
        // 덧셈일 경우
        if (operator[0] > 0) {
            operator[0] -= 1;
            stack1.push(A[idx]);
            stack2.push(1);
            backtracking(idx + 1, stack1, stack2);
            stack1.pop();
            stack2.pop();
            operator[0] += 1;
        }
        // 뺄셈일 경우
        if (operator[1] > 0) {
            operator[1] -= 1;
            stack1.push(A[idx]);
            stack2.push(2);
            backtracking(idx + 1, stack1, stack2);
            stack1.pop();
            stack2.pop();
            operator[1] += 1;
        }
    }

    static int N;
    static int[] A;
    static int[] operator;
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.add(A[0]);
        backtracking(1, stack1, stack2);
        System.out.println(MAX);
        System.out.println(MIN);
    }
}