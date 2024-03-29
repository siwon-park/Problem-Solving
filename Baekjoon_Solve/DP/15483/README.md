## [골3] 최소 편집 (15483번)

https://www.acmicpc.net/problem/15483

### 문제 유형

DP

<br>

### 어려웠던 점 / 문제의 핵심

문제를 풀기 위해 많이 고민했고 끄적였지만, 그냥 처음에 왠지 점화식이 이럴 것 같다고 생각했던 것이 올바른 점화식이었다.

c1 == c2이면, 즉 두 문자열에서 현재 두 문자가 같으면 lcs를 갱신해야 하므로 `dp[i - 1][j - 1]`의 위치를 참조하는데, lcs를 구한다고 하면 `dp[i - 1][j - 1] + 1`이지만, 지금은 최소 편집을 계산해야 한다.

현재 두 문자가 같으므로 삽입, 삭제, 교체를 할 필요가 없다. 따라서 `dp[i - 1][j - 1]`에 있는 값을 그대로 가져오면 된다.

하지만 c1 != c2일 때는 현재 두 문자가 다르기 때문에 삽입 또는 삭제, 교체 중 하나를 선택해야 한다. 

따라서 `dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]`에 기록된 값 중 최솟값을 구해서 += 1을 해주면 된다. 

- `dp[i - 1][j - 1]`을 선택하면 '교체'이고, `dp[i - 1][j]와 dp[i][j - 1]`은 i와 j에 따라서 달라지긴 하지만 '삽입' 또는 '삭제'이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 19236 KB | 192 ms        | O(MN)      | O(MN)      | 80분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

