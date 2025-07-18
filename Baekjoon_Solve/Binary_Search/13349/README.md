## [골4] Millionaire Madness (13349번)

https://www.acmicpc.net/problem/13349

### 문제 유형

그래프 이론, 그래프 탐색, 이분 탐색, 최단 경로, 다익스트라

<br>

### 어려웠던 점 / 문제의 핵심

이 문제는 다익스트라로 풀 수 있고, 이분 탐색(매개 변수 탐색)으로 풀 수도 있다.

다익스트라로 푸는 방법이 생각이 안 떠올라서 매개 변수 탐색 + BFS로 풀었다.

각 노드 간 이동을 할 때 현재 높이가 다음 이동할 위치의 높이보다 크면 사다리가 필요 없지만, 작을 경우에는 그 차이만큼의 높이를 가진 사다리가 필요하다.

매개 변수 탐색 + BFS를 통해서 (0, 0)에서 (N - 1, M - 1)로 가는데 필요한 사다리의 최대 높이의 최솟값을 찾으면 된다.

현재 사용할 수 있는 사다리의 최대 높이를 이분 탐색으로 찾고, (0, 0)에서 (N - 1, M - 1)까지 탐색이 가능한지 체크해본다. 만약 도달 가능할 경우에는 최대 높이를 조금 더 줄여서 탐색을 해보고, 도달 불가능할 경우에는 최대 높이를 늘리는 방향으로 탐색하여 찾는다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도   | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | --------- | ------------- | ------------ | ---------- | --------- | --------- | -------------------- |
| Python |           |               |              |            |           |           |                      |
| Java   | 309264 KB | 1008 ms       | O(logH * MN) | O(MN)      | 20분      | 1         | :white_large_square: |
| Kotlin |           |               |              |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

