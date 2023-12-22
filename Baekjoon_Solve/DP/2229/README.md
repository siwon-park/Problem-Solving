## [골5] 조 짜기 (2229번)

https://www.acmicpc.net/problem/2229

### 문제 유형

DP

<br>

### 어려웠던 점 / 문제의 핵심

DP 테이블을 다음과 같이 정의한다. `dp[i]`는 `i까지의 조가 잘 짜여진 정도의 최댓값`

그러면 `dp[i]`를 구하기 위해서는 `1이상 i이하의 구간 j`를 탐색하여 `(j ~ i 구간의 최댓값 - 최솟값) + dp[j - 1]`의 최댓값을 구하면 된다.

2중 for문을 사용하되, 한쪽은 정방향이고 한쪽은 역방향을 사용해야 한다는 점이 특이한 DP 문제였다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |          |               |            |            |           |           |                    |
| Java   | 14844 KB | 172 ms        | O(N^2)     | O(N)       | 45분      | 1         | :white_check_mark: |
| Kotlin |          |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```
