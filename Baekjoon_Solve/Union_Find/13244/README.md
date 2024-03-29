## [골4] Tree (13244번)

https://www.acmicpc.net/problem/13244

### 문제 유형

자료 구조, 그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색, 분리 집합

<br>

### 어려웠던 점 / 문제의 핵심

union-find로 사이클 여부를 판별하고, 부모 테이블을 순회하여 연결 컴포넌트의 개수가 1개인지만 확인하면 된다. 정석대로 한다면 트리의 간선 수가 노드의 수 - 1인지도 확인하는 과정이 추가되어야 하지만 간선 수가 노드의 수 이상이면 이미 사이클이 발생하는 상태이기 때문에 union-find로도 충분히 검증이 가능하다. 

union-find를 통한 검증 과정을 통과하면 결국 한 노드에서 다른 노드로 가는 경로가 1개임이 보장되고, 모든 노드가 연결되어 있음을 확인할 수 있으므로 트리라고 할 수 있다. 그게 아니면 무조건 그래프이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 18588 KB | 184 ms        | O(MlogN)   | O(N)       | 35분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

