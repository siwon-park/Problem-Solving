## [골3] 스크루지 민호 2 (12978번)

https://www.acmicpc.net/problem/12978

### 문제 유형

트리 DP, DFS

<br>

### 어려웠던 점 / 문제의 핵심

`dp[cur][0]`을 `현재 도시에 경찰서를 세우지 않는 경우`, `dp[cur][1]`을 `현재 도시에 경찰서를 세우는 경우`라고 정의하자.

현재 도시에 경찰서를 세우지 않았으면 다음 도시에는 반드시 세워야 한다. 왜냐하면 문제에서 `"모든 도시와 도로를 감시해야 한다"`고 했기 때문에 만약 연속으로 세우지 않는 경우가 있으면 도시는 감시가 가능하겠지만 연속으로 세우지 않은 두 도시 간에 존재하는 도로는 감시할 수 없다.

따라서 `dp[cur][0] += dp[nxt][1]`이다. 

대신, 현재 도시에 경찰서를 세웠다면 다음 도시와 그 도시를 잇는 도로까지 감시 가능하기 때문에 다음 도시에 경찰서를 세우는 경우와 세우지 않는 경우 중 작은 값을 택하면 된다.

따라서 `dp[cur][1] += min(dp[nxt][0], dp[nxt][1])`이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 59296 KB | 528 ms        | O(N)       | O(N)       | 30분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

