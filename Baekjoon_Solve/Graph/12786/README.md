## [골4] INHA SUIT (12786번)

https://www.acmicpc.net/problem/12786

### 문제 유형

그래프 이론, 그래프 탐색, 0-1 BFS, 다익스트라, DP

<br>

### 어려웠던 점 / 문제의 핵심

0-1 BFS로 풀었다.

다음 나무의 구멍 높이가 O, A, B, C 기능을 사용해서 이동이 가능한 높이일 경우에는 덱(deque)의 맨 앞에 삽입한다.

그게 아니라 T 기능을 사용하여 원하는 높이의 구멍으로 이동을 해야 한다면  현재까지 사용한 T 기능 사용 횟수를 1 증가시키고 덱의 맨 뒤에 삽입한다.

방문 배열은 3차원으로 만들어준다. `visited[나무번호][높이][T 기능 사용 횟수]`

문제가 조금 더 명확했으면 좋았을 것 같다. 왜냐하면 처음에 문제를 다 읽고 나서 다시 뒤로도 이동이 가능하다고 생각하여 지그재그로 갈 수 있는 경우도 있다고 생각했기 때문이다.

하지만 무조건 앞으로 가는 것만 가능한 것 같다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 18252 KB | 156 ms        | O(NK)      | O(NK)      | 60분      | 2         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

