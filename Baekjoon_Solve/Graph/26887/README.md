## [골3] Skridskor (26887번)

https://www.acmicpc.net/problem/26887

### 문제 유형

그래프 이론, 그래프 탐색, BFS, 다익스트라, 0 - 1 BFS

<br>

### 어려웠던 점 / 문제의 핵심

어렵지 않은 문제였는데, 집중도 안 되고 천천히 푸는 바람에 오래 걸렸다.

(0,0) 에서 출발해서 (?, C + 1)까지 가는데 최소 회전 수를 구하는 문제이다. 회전은 계속해서 가다가 벽을 만났을 때만 회전한다.

회전을 할 때는 90도 양방향으로 회전 가능하다.

따라서 이 문제는 다익스트라 혹은 0 - 1 BFS로 푸는데, 다음 위치가 벽일 경우에는 방향을 양방향으로 90도 꺾어서 갈 수 있는지 체크한 다음 진행하면 된다. 0 - 1 BFS로 풀 경우에는 계속해서 덱 앞에 넣다가, 벽을 만나서 방향을 꺾으면 덱의 맨 뒤로 넣는 방식으로 구현하면 된다.

방문 배열을 3차원으로 선언해야 문제를 풀 수 있다. 왜냐하면 회전하면서 빙 둘러서 왔던 위치에 도달할 수 있는 경우도 있는데, 2차원의 배열로 최단 거리 기록만 한다면 이를 체크할 수 없기 때문이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 15168 KB | 124 ms        | O(MN)      | O(MN)      | 70분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

