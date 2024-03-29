## [골5] k개 사과 트리 노드만으로 배를 최대로 수확하기 (25977번)

https://www.acmicpc.net/problem/25977

### 문제 유형

그래프 이론, 그래프 탐색, 브루트포스, 트리, 비트마스킹, BFS

<br>

### 어려웠던 점 / 문제의 핵심

k개 트리 노드에서 사과 최대로 수확하기 (25691번)과 유사한 문제이다.

다만, 차이가 있다면 이번에는 사과가 있는 노드는 최대 k번 방문하되, 배를 최대한 모으는 문제이다.

분기 처리 로직만 추가해주면 풀이에 크게 차이가 없다.

노드에 사과와 배도 없는 경우가 있음을 유의해야 한다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도     | 공간복잡도     | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | -------------- | -------------- | --------- | --------- | -------------------- |
| Python |          |               |                |                |           |           |                      |
| Java   | 32848 KB | 252 ms        | O(N * (2 ^ N)) | O(N * (2 ^ N)) | 40분      | 2         | :white_large_square: |
| Kotlin |          |               |                |                |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

