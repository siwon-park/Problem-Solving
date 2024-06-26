## [골4] 육각수 (1229번)

https://www.acmicpc.net/problem/1229

### 문제 유형

DP, 배낭 문제

<br>

### 어려웠던 점 / 문제의 핵심

먼저 육각수를 구해야 한다. 육각수를 구하는 점화식은 다음과 같다.

- `six[n] = six[n - 1] + 4n - 3 (단, six[0] = 0)`

이를 통해 계산을 하면 100만 이하의 육각수는 약 707개 존재하는 것을 알 수 있다.

그러나 우리는 708번째 육각수까지 구해준다.

왜냐하면 육각수를 계산한 다음에 `dp[임의의 육각수] = 1`로 만들어줘야 하기 때문이며, 로직상 육각수를 먼저 구한 다음에 dp값을 업데이트하기 때문에 마지막 육각수인 707번째 육각수에 해당하는 dp[707번째 육각수] = 1로 만들어주기 위해서 이다.

그 후에는 일반적인 배낭 문제로 풀이가 가능하다.

- `dp[n] = min(dp[n], dp[n - n이하의 임의의 육각수] + 1)`이다.
- 만약 n - 임의의 육각수가 음수면 break해야 한다. 앞으로는 현재 수보다 더 큰 육각수만 나오기 때문에 굳이 쓸 데 없이 연산할 필요가 없기 때문이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 18260 KB | 1056 ms       | O(NK)      | O(N + K)   | 40분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

