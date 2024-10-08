## [골4] 절연 구간 최소화 (32197번)

https://www.acmicpc.net/problem/32197

### 문제 유형

그래프 이론, 최단 경로, 다익스트라, 0-1 BFS

<br>

### 어려웠던 점 / 문제의 핵심

0 - 1 BFS로 문제를 해결하였다.

현재 노드에서 다음 노드로 갈 때 급전 방식이 다르면 비용을 1 증가시킨 다음 덱의 맨 뒤에 삽입하고, 급전 방식이 같다면 비용은 그대로인 채 덱의 맨 앞에 삽입하는 방식으로 구현하면 된다.

급전 방식이 같은지, 다른지 유무는 비트 XOR연산을 통해서 처리했다.

- 두 비트가 같다면 XOR 연산의 결과는 0이다.
- 두 비트가 다르면 XOR 연산의 결과는 1이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 76244 KB | 480 ms        | O(M + N)   | O(M + N)   | 30분      | 4         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

