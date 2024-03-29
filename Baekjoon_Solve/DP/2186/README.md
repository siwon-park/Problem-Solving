## [골3] 문자판 (2186번)

https://www.acmicpc.net/problem/2186

### 문제 유형

DP(메모이제이션), DFS, 그래프 탐색, 그래프 이론

<br>

### 어려웠던 점 / 문제의 핵심

메모이제이션 (dp + dfs)

3차원의 메모이제이션 배열을 만든다. 테이블의 정의는 다음과 같다. 

`"(r, c) 위치에서 idx에서 일치하는 문자열의 경우의 수"`

문제에서 주어지는 K의 정의와 그 설명이 상당히 헷갈리게 표현해두었는데, `"1 ~ K칸 만큼 점프할 수 있다"`로 해석하는 것이 보다 올바른 표현인 것 같다. X표시된 위치로 이동할 수 있다고 했으니 말이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |          |               |            |            |           |           |                    |
| Java   | 20836 KB | 532 ms        | O(MNK)     | O(MNK)     | 60분      | 1         | :white_check_mark: |
| Kotlin |          |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```

