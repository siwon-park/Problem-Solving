## [골2] 뉴스 전하기 (1135번)

https://www.acmicpc.net/problem/1135

### 문제 유형

트리 DP, 정렬, 그리디

<br>

### 어려웠던 점 / 문제의 핵심

`dp[cur]`을 `cur번 노드에서 cur의 모든 노드에게 뉴스를 전하는데 드는 최소 시간`이라고 정의하자.

자신의 자식 노드에게 뉴스를 전하려면 뉴스를 전하는데 가장 비용이 많이 드는 노드부터 순차적으로 전달하는 것이 이득이다.

왜냐하면 자식에게 일단 전달하면 그 다음부터는 자식이 자식의 자식에게 전달을 시작하기 때문에 동시에 작업들을 처리 가능하다. 따라서 가장 오래 걸리는 작업을 시작해놓고, 계속 내 할 일을 하는 것이 이득이다.

그런데 이 때 어찌됐건 현재 노드는 자신의 직속 자식에게 뉴스를 전하는 일은 1분에 1번씩 밖에 못하기 때문에 자식의 수를 `m`이라 하면 m번의 지연이 발생하게 된다.

결국에는 지연이 발생하는 것을 포함하여 자신의 모든 자식에게 전파하는데 걸리는 최대 시간을 구해서 dp[cur]에 기록하면 된다.

사실 주어진 예제를 그림으로 그리면서 각 노드가 1분에 동시에 뉴스를 전하는 작업을 하는 것을 직접 해보면 이해가 더 쉽다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 14292 KB | 128 ms        | O(N)       | O(N)       | 45분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```
