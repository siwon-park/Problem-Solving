## [골4] LCS3 (1958번)

https://www.acmicpc.net/problem/1958

### 문제 유형

DP

<br>

### 어려웠던 점 / 문제의 핵심

DP 문제를 풀 때, 점화식이 아니라 DP 테이블을 정의하는 게 더 중요하다는 것을 보여준 문제.

문자열이 3개이기 때문에 3차원을 사용하는 것까진 쉽게 생각할 수 있다. 그럼 점화식은? 분명히 2개의 문자열에 대한 LCS를 구하는 것과는 다를텐데라는 생각이 들 것이다.

그런데 만약 문자열 2개를 가지고 푸는 LCS에서 점화식부터 찾지 않고 DP 테이블부터 정의했다면 이 문제의 정답도 바로 나왔을 것이다.

문자열 2개를 가지고 LCS를 구할 때, DP 테이블은 `"(i, j)일 때 LCS의 길이"`라고 정의하면

- `(i, j)`에서 두 문자가 일치했을 땐, `(i - 1, j - 1)일 때 LCS의 길이 + 1`이다.
- 만약 (i, j)에서 두 문자가 일치하지 않았을 때는 i를 i - 1로 옮겨보거나,  j를 j - 1로 옮겼을 때의 위치에서 두 문자가 일치할 수도 있으니  (i, j)에서 두 문자가 일치하지 않았다면 `(i - 1, j)`와 `(i, j - 1)` 중 더 큰 값을 취한다.

결론적으로 DP 테이블의 정의에 따라 점화식이 세워진 것이다.

문자열이 3개일 때도 큰 차이가 없다. `dp[i][j][k]`를 `"(i, j, k)일 때의 LCS의 길이"`라고 정의한다면,

- 마찬가지로 특정 위치에서 3개의 문자가 일치한다면, 각 위치에서 -1을 했을 때의 위치 조합의 LCS에 + 1을 하면 되고,
- 셋 중 하나 이상 일치하지 않는다면, `8개` 중 `(i - 1, j - 1, k - 1)`과 구해야 하는 값인 `(i, j, k)`일 때를 제외한 나머지 `6개의 위치 조합에 대한 LCS값 중 최댓값`을 취하면 된다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 20776 KB | 224 ms        | O(100^3)   | O(100^3)   | 60분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

