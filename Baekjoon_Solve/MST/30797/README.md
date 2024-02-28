## [골4] 가희와 여행가요 (30797번)

https://www.acmicpc.net/problem/30797

### 문제 유형

그래프 이론, 최소 스패닝 트리

<br>

### 어려웠던 점 / 문제의 핵심

주어지는 연결 정보를 비용이 작은 순, 시간이 작은 순으로 정렬한다. 그 후 최소 스패닝 트리를 구성하면 된다.

비용의 경우 누적이기 때문에 int형을 초과할 수 있어 long형으로 선언한다.

시간의 경우 최소 스패닝 트리가 구성되는 시간을 구해야 하는데, 이는 각 지점을 연결할 때 현재 시간 중 최대 시간을 선택하면 된다.

최대 시간으로 택해야 하는 이유는 비용이 작은 순을 우선으로 정렬했기 때문에 시간의 순서는 오름차순이 아니다. 따라서 현재 시간이 항상 최적 시간이 아닐 수도 있다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | --------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |           |               |            |            |           |           |                      |
| Java   | 121296 KB | 1252 ms       | O(QlogN)   | O(N)       | 40분      | 1         | :white_large_square: |
| Kotlin |           |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```
