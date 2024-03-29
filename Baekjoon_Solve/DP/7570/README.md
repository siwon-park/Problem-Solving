## [골3] 줄 세우기 (7570번)

https://www.acmicpc.net/problem/7570

### 문제 유형

그리디, DP

<br>

### 어려웠던 점 / 문제의 핵심

가장 긴 증가하는 `연속` 부분 수열을 구하는 게 핵심이다.

문제 유형에 DP가 있는 것을 보고 가장 긴 증가하는 부분 수열 문제가 아닐까 생각했지만,

가장 긴 증가하는 부분 수열의 경우 숫자를 임의의 위치로 옮길 수 있기 때문에 잘못된 접근법이라는 것을 질문 게시판을 통해 깨달았다.

그리고 조금 더 생각해본 결과 가장 긴 증가하는 `연속` 부분 수열을 구하는 문제였다.

그래서 내가 생각한 것은 각 숫자별 인덱스를 기록하고, `현재 숫자 - 1`의 인덱스보다 `현재 숫자`의 인덱스가 크다면 연속 부분 수열을 구성할 수 있기 때문에 현재 숫자의 길이에 현재 숫자 - 1까지 기록된 길이를 더한다.

최종적으로는 `N - 가장 긴 증가하는 연속 부분 수열 길이의 최댓값`을 구하면 된다.

결국 가장 긴 증가하는 연속 부분 수열들의 숫자 위치는 고정해두고 나머지 숫자만 양 끝으로 옮기는 작업을 하는 것이 매번 이득이고 가장 적게 움직여서 수열을 오름차순으로 만들 수 있는 방법이다.

생각해보니 굳이 이렇게 번거롭게 구할 필요는 없었다. 왜냐하면 숫자는 1 ~ N까지 한 번씩만 등장하기 때문에 `dp[arr[i]] = dp[arr[i] - 1] + 1`로 O(N)으로 풀 수도 있다. (내 풀이의 경우 O(2N)이다)

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |          |               |            |            |           |           |                    |
| Java   | 99132 KB | 512 ms        | O(2N)      | O(3N)      | 45분      | 1         | :white_check_mark: |
| Kotlin |          |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
6
1 2 3 5 6 4
ans: 2
```

