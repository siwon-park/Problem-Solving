## [플5] 대기업 승범이네 (17831번)

[https://www.acmicpc.net/problem/17831]()

### 문제 유형

트리, 트리 DP

<br>

### 어려웠던 점 / 문제의 핵심

`dp[cur][0]`을 cur이 멘토-멘티 관계가 아닐 때(멘티가 아닐 때) 시너지의 최댓값이라고 정의하고,

`dp[cur][1]`을 cur이 멘토-멘티 관계에 있을 때(멘티일 때) 시너지의 최댓값이라 정의하자.

그러면 `dp[cur][0] += max(dp[nxt][0], dp[nxt][1])`이다. 왜냐하면 현재 자신이 멘티가 아니기 때문에 자식이 멘티이거나 멘티가 아닌 두 가지 상태가 존재하기 때문이다. 따라서 nxt가 멘토 관계에 있지 않는 경우와 멘토 관계에 있는 경우 중 최댓값을 택하면 된다.

문제는 자신이 멘티인 경우인 `dp[cur][1]`인데, 자신이 멘티이기 때문에 자식 중 하나와 멘토-멘티 관계를 맺어야 한다.

따라서 일단 자식 nxt가 멘티인 경우인 `dp[nxt][1]`을 누적 계산한다.

그 후 자식 중 하나와 멘토-멘티 관계를 형성하여 시너지 값을 계산하고, 해당 nxt 멘티인 상태의 최댓값을 저장하고 있는 `dp[nxt][1]`을 뺀 다음 nxt가 멘티가 아닌 상태의 최댓값인 `dp[nxt][0]`을 더해준다.

이렇게 구한 값 중 최댓값이 `dp[cur][1]`이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 94884 KB | 1844 ms       | O(N)       | O(N)       | 50분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

