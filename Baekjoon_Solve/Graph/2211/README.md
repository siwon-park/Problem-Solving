## [골2] 네트워크 복구 (2211번)

[https://www.acmicpc.net/problem/2211]()

### 문제 유형

그래프 이론, 그래프 탐색, 다익스트라, 최단 경로, 경로 역추적

<br>

### 어려웠던 점 / 문제의 핵심

다익스트라 최단 경로의 경로들을 중복 없이 찾는 문제이다.

처음에 MST라고 생각했는데, MST는 정답이 아닐 수도 있다는 것을 알았다.

왜냐하면 문제에서 `"네트워크를 복구했을 때, 슈퍼 컴퓨터가 다른 컴퓨터와 통신하는 최소 시간이 원래 네트워크 상에서의 걸리는 최소 시간보다 커져서는 안 된다."`고 되어있는데, 이를 잘 생각해보면 MST를 구성했을 때는 1번이 기준이 되지 않는 경우도 있다.

즉 MST를 구성하면 네트워크 상의 총 경로는 최솟값이면서 최소 경로 수이겠지만, 1번 컴퓨터(슈퍼 컴퓨터)에서 다른 임의의 노드로 가는 최단 경로가 최솟값임을 보장하지 못한다.

따라서 1번 노드에서 출발하는 다익스트라를 통해서 1번 노드에서 각 노드까지의 최단 거리와 경로를 기록한다. 그 후 각 노드에서 경로를 역추적하여 1번까지의 경로를 찾되, 중복없이 찾으면 된다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도   | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ------------ | ---------- | --------- | --------- | -------------------- |
| Python |          |               |              |            |           |           |                      |
| Java   | 91860 KB | 656 ms        | O(MlogN + N) | O(M + N)   | 50분      | 1         | :white_large_square: |
| Kotlin |          |               |              |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

