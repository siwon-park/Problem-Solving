// 음주 코딩(5676번)
///////////////////////////////////////////////////////////////////////////////////
  // 문제: https://www.acmicpc.net/problem/5676
  // 세그먼트 트리
  // 구간 곱 구하기랑 동일한 문제인데, 차이가 있다.
  // 곱셈을 하다보면 오버플로우가 발생할 수 있어 곱셈의 결과를 담는 것이 아니라 부호를 담아야한다는 것이다.
  // 문제를 분명히 다 풀어놓고 여러 번 틀렸는데, 알고보니 오른쪽 자식 노드 탐색을 위한 2 * node + 1에서 +1을 해주고 있지 않아서
  // 여러 케이스에서 틀린 답을 출력하고 있었다.
///////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class SegmentTree {

        private String[] tree;

        SegmentTree(int n) {
            double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
            long treeNodeCount = Math.round(Math.pow(2, treeHeight));
            tree = new String[Math.toIntExact(treeNodeCount)];
        }

        String init(String[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                String ret1 = init(arr, node * 2, start, mid);
                String ret2 = init(arr, node * 2 + 1, mid + 1, end);
                if (ret1.equals("0") || ret2.equals("0")) {
                    tree[node] = "0";
                } else if (ret1.equals(ret2)) {
                    tree[node] = "+";
                } else {
                    tree[node] = "-";
                }
                return tree[node];
            }
        }

        String mul(int node, int left, int right, int start, int end) {
            if (right < start || end < left) {
                return "+";
            } else if (left <= start && end <= right) {
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                String ret1 = mul(node * 2, left, right, start, mid);
                String ret2 = mul(node * 2 + 1, left, right, mid + 1, end);
                if (ret1.equals("0") || ret2.equals("0")) {
                    return "0";
                } else if (ret1.equals(ret2)) {
                    return "+";
                } else {
                    return "-";
                }
            }
        }

        String update(int node, int start, int end, int index, String changeValue) {
            if (index < start || end < index) {
                return tree[node];
            } else if (index == start && end == index) {
                tree[node] = changeValue;
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                String ret1 = update(node * 2, start, mid, index, changeValue);
                String ret2 = update(node * 2 + 1, mid + 1, end, index, changeValue);
                if (ret1.equals("0") || ret2.equals("0")) {
                    tree[node] = "0";
                } else if (ret1.equals(ret2)) {
                    tree[node] = "+";
                } else {
                    tree[node] = "-";
                }
                return tree[node];
            }
        }
    }

    static int N; // 수열의 크기
    static int K; // 게임 라운드 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String line = br.readLine();
            if (line == null || line.equals("")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            SegmentTree segmentTree = new SegmentTree(N);

            String[] X = br.readLine().split(" ");
            String[] arr = new String[N + 1];
            for (int i=0; i<N; i++) {
                int Xi = Integer.parseInt(X[i]);
                if (Xi > 0) {
                    arr[i + 1] = "+";
                } else if (Xi < 0) {
                    arr[i + 1] = "-";
                } else {
                    arr[i + 1] = "0";
                }
            }

            segmentTree.init(arr, 1, 1, N);

            for (int k=0; k<K; k++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                String order = st2.nextToken();
                int i = Integer.parseInt(st2.nextToken());
                int Vj = Integer.parseInt(st2.nextToken());
                // order가 C이면 값 변경, P이면 곱셈
                if (order.equals("C")) {
                    String V = "";
                    if (Vj > 0) {
                        V = "+";
                    } else if (Vj < 0) {
                        V = "-";
                    } else {
                        V = "0";
                    }
                    segmentTree.update(1, 1, N, i, V);
                } else if (order.equals("P")) {
                    String ret = segmentTree.mul(1, i, Vj, 1, N);
                    bw.write(ret);
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

