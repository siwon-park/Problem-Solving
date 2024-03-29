## [골5] Coins (3067번)

https://www.acmicpc.net/problem/3067

### 문제 유형

다이나믹 프로그래밍, 배낭 문제

<br>

### 어려웠던 점 / 문제의 핵심

처음에 2차원의 배열로 dp 배열을 선언해서 헤맸다.

사실 어떻게 보면 문제에서는 M원만 만들면 되므로 몇 종류를 썼는지는 크게 상관 없다. 따라서 1차원의 dp배열로도 충분하다.

2 중 for 문을 활용해서 먼저 처음에는 동전 종류에 대해서, 중첩 for 문에는 금액에 대해서 반복한다.

주어진 동전 1개만으로도 해당 금액을 만들 수 있는 경우도 있으므로 dp[coin[n]] += 1을 해주는 것을 잊지 말아야 한다. 

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |          |               |            |            |           |           |                    |
| Java   | 16352 KB | 168 ms        | O(NM)      | O(M)       | 40분      | 1         | :white_check_mark: |
| Kotlin |          |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

DP 배열을 M + 1로 크기를 설정할 경우 N개의 동전 중 M보다 클 경우 인덱스 에러가 발생한다.

```
1
1 10000
2
400
```

