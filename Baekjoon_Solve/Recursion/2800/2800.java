import java.io.*;
import java.util.*;


public class Main {

    static class Pair {
        int idx1;
        int idx2;
        Pair(int idx1, int idx2) {
            this.idx1 = idx1;
            this.idx2 = idx2;
        }
    }

    static void combine(int k, int m) { // 부분집합 구하기
        if (k == m) {
            String s = "";
            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;
                s += S.charAt(i) + "";
            }
            ret.add(s);
            return;
        }
        // 현재 요소를 선택함
        Pair pair = hashMap.get(k + 1);
        visited[pair.idx1] = true;
        visited[pair.idx2] = true;
        combine(k + 1, m);

        // 현재 요소를 선택하지 않음
        visited[pair.idx1] = false;
        visited[pair.idx2] = false;
        combine(k + 1, m);
    }

    static String S;
    static int N;
    static boolean[] visited;
    static TreeSet<String> ret = new TreeSet<>();
    static HashMap<Integer, Pair> hashMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        N = S.length();
        visited = new boolean[N];

        int sn = 0; // 괄호 쌍의 번호
        hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            if (c == '(') { // 여는 괄호면
                stack.add(i);
            } else if (c == ')') { // 닫는 괄호면
                hashMap.put(++sn, new Pair(stack.pop(), i));
            }
        }

        int M = hashMap.size();
        combine(0, M);
        ret.remove(S);

        for (String res : ret) System.out.println(res);
    }
}