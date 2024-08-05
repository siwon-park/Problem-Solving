## [실1] 출근 (13903번)

[https://www.acmicpc.net/problem/13903]()

### 문제 유형

그래프 이론, 그래프 탐색, BFS

<br>

### 어려웠던 점 / 문제의 핵심

BFS 핵심 성질을 묻는 문제이다.

첫 번째 행에 있는 1이 쓰여진 칸에서 출발하여 1인 칸끼리만 이동할 수 있다.

그런데 첫 번째 행에 있는 1이 쓰여진 칸 각각에 대해서 BFS를 돌리면 시간초과가 난다. 그 이유는 굳이 쓸 데 없이 계속 탐색을 하기 때문이다.

BFS는 FIFO이기 때문에 가장 먼저 들어간 원소가 가장 빨리 나온다. 그리고 이 문제에서 간선의 가중치는 1로 모두 동일하다. 따라서 가장 먼저 마지막 행에 도착하면 그 값이 정답이 된다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | --------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |           |               |            |            |           |           |                      |
| Java   | 126160 KB | 620 ms        | O(RC)      | O(RC)      | 35분      | 4         | :white_large_square: |
| Kotlin |           |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```
