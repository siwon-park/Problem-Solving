## [골3] 바이러스 공격 (31791번)

https://www.acmicpc.net/problem/31791

### 문제 유형

그래프 이론, 그래프 탐색, BFS, 다익스트라, 최단 경로

<br>

### 어려웠던 점 / 문제의 핵심

최대 Tg 시간 동안 바이러스를 퍼뜨렸을 때, 도달할 수 없는 영역들의 좌표를 구하는 문제이다.

바이러스가 더 빨리 퍼진 곳은 탐색하면 안 되기 때문에 다익스트라 알고리즘을 활용한 최단 거리 그래프 문제로 해결할 수 있다.

규칙에 따라 그래프를 탐색할 수 있는 다익스트라 알고리즘을 구현하면 된다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 85832 KB | 1084 ms       | O(NlogN)   | O(MN)      | 40분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```
