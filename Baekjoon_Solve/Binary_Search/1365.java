// 꼬인 전깃줄 (1365번)
/*
  문제: https://www.acmicpc.net/problem/1365
  이분탐색(가장 긴 증가하는 부분 수열)
  가장 긴 증가하는 부분 수열을 만들기 위해 원래 숫자가 있던 인덱스에서 숫자를 교체한 횟수를 찾는 문제이다.
  이 문제가 가장 긴 증가하는 부분 수열 문제라는 것을 알았는데, lowerbound로 구현해야함에도 upperbound로 구현하는 실수를 하고 있었다.
  파이썬으로 구현했다면 리스트가 가변적이고 인덱스에 바로 접근/수정이 가능해서 쉽게 풀 수 있었는데 자바는 어떤 자료형을 사용하는게 적절한지 몰라서 헤맸다.
  특히, 처음에 ArrayList로 구현했다가 특정 인덱스에 있는 숫자를 교체할 수 없다는 것을 알고 배열을 사용해야 한다는 것을 알았는데
  문제는 어떻게 사용해야하는지 몰랐다. 사실 조금만 더 생각했어도 배열로 사용하는 방법을 알아낼 수 있었는데, 그냥 이전에 풀었던 비슷한 문제에서 자바 풀이를 참고했다.
  내가 처음에 배열로 접근하지 않은 이유는 배열을 N의 크기로 초기화하면 0이라는 숫자가 들어가서
  가장 긴 증가하는 부분 수열을 만드는데 방해가 될 것이라 생각했기 때문이었는데, 이는 내 착각이었다.
  문제에 0의 존재가 없었고, 파이썬에서 풀었을 때는 -1이라는 가장 끝 인덱스만 고려했기 때문에
  가장 끝 인덱스만 사용해야한다고 착각했다.
  가장 끝의 숫자를 가지고 따지는 것이 아니라 인덱스를 가지고 해당 위치에 있는 숫자와 대소 비교를 통해서 이분탐색을 해서 가장 긴 증가하는 부분 수열을 만드는 것이다.
  원래 들어가야할 인덱스 위치에 0이 있으면 무조건 들어갈 수 있다는 의미이므로 넣는다. 그리고 인덱스를 증가시킨다.
  증가한 현재 인덱스 위치에는 숫자가 들어가 있는데 해당 위치에 숫자를 넣으려할 때 들어오려는 숫자가 더 작으면 이분탐색을 통해 올바른 위치를 찾아준다.
  그리고 위치를 찾으면 교체하는 것이므로 cnt += 1을 하여 문제에서 원하는 답을 찾을 수 있도록 교체 횟수를 증가시켜준다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int lowerBound(int[] A, int s, int e, int target) {
        int idx = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (target <= A[mid]) { // target >= A[mid] => upperbound
                e = mid - 1; // s = mid + 1;
                idx = mid;
            } else {
                s = mid + 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int idx = 0;
        for (int i=1; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (arr[idx] < num) {
                arr[++idx] = num;
            } else {
                int indx = lowerBound(arr, 0, idx, num);
                arr[indx] = num;
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }
}
