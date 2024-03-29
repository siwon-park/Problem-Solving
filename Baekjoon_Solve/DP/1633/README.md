## [골4] 최고의 팀 만들기 (1633번)

[https://www.acmicpc.net/problem/1633]()

### 문제 유형

DP

<br>

### 어려웠던 점 / 문제의 핵심

`dp[i][j][k]`를 `i번째까지 백을 j명, 흑을 k명을 선택했을 때의 최댓값`이라 정의하고 3가지 상태에 대한 DP값을 구하면 된다.

- 현재 백팀을 선택
- 현재 흑팀을 선택
- 현재 백팀, 흑팀 둘 다 선택하지 않음

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도    | 공간복잡도    | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | ------------- | ------------- | --------- | --------- | ------------------ |
| Python | 32140 KB | 160 ms        | O(N * 15 *15) | O(N * 15 *15) | 60분      | 7         | :white_check_mark: |
| Java   |          |               |               |               |           |           |                    |
| Kotlin |          |               |               |               |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```

