## [골5] 퇴사 2 (15486번)

https://www.acmicpc.net/problem/15486

### 문제 유형

DP

<br>

### 어려웠던 점 / 문제의 핵심

점화식과 DP 테이블 정의를 찾기 힘든 문제였다.

#### 실수했던 점

`dp[n]`을 `n`일까지 일했을 때의 최대 금액이라고 정의했다.

그러나 각 일자별로 상담 기간이라는 개념이 존재하기 때문에 이러한 테이블 정의는 옳지 못하다.

또한 최대 수익을 구하기 위해서는 개별 수익 P가 양수이기 때문에 기간 안에 무조건 많이 일하면 일 할 수록 혹은 많은 금액을 가지고 있는 상담을 할 수록 이득이다.

#### 올바른 풀이

`dp[n]`은 `n`일부터 마지막까지 일했을 때 얻을 수 있는 최대 금액이다.

따라서 dp[n]을 구하기 위해서는 N부터 역순으로 탐색해야 한다.

또한 상담 기간 `T`는 1 이상의 양수이기 때문에 dp[N]은 구해봤자 의미가 없다. 어차피 N + 1일에는 퇴사를 하기 때문에  N일에는 절대 일을 할 수 없기 때문이다.

따라서 N - 1부터 역순하여 dp[0]을 찾으면 그게 정답이다. 이를 위해 현재 시점까지의 최댓값을 구해놓고 최댓값과 점화식을 비교하는 방식을 사용하여 n일부터 마지막까지 일했을 때 얻을 수 있는 최대 금액을 구하면 된다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | --------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |           |               |            |            |           |           |                    |
| Java   | 345508 KB | 852 ms        | O(N)       | O(N)       | 100분     | 1         | :white_check_mark: |
| Kotlin |           |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```

