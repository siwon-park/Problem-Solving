## [골5] 암호코드 (2011번)

https://www.acmicpc.net/problem/2011

### 문제 유형

DP

<br>

### 어려웠던 점 / 문제의 핵심

문제 풀이를 떠올리기 어려운 문제는 아닌데, 반례가 많아서 유의해야 한다.

점화식 자체는 간단하다.

`dp[i] += dp[i - 1] % MOD` 그리고 만약에 `i - 1번 숫자`와 `i번 숫자`를 이었을 때, `26이하`라면 `dp[i] += dp[i - 2] % MOD`

단, 여기서 이제 주의해야 할 것이 예외이다.

초깃값을 어떻게 설정할지와 조건문을 추가해야 한다.

- dp[0]은 무조건 1이다. dp[i - 2]를 계산할 때 사용하기 위함이다.
- `첫 번째 숫자가 0보다 커야만 dp[1] = 1`이다.
- 지금 이어 붙이는 i번째 숫자가 0이라면 경우의 수로 추가할 수 없다.
- 또한 i - 1번째 숫자와 i번째 숫자를 이어 붙였을 때, `i - 1번째 숫자가 0`이거나 `이어 붙인 숫자가 26보다 크다면` 경우의 수로 추가할 수 없다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 14376 KB | 132 ms        | O(N)       | O(N)       | 80분      | 2         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
0
# ans: 0

30
# ans: 0

230
# ans: 0

25
# ans: 2

20
# ans: 1
```
