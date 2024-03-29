## [골2] 스크루지 민호 (12896번)

https://www.acmicpc.net/problem/12896

### 문제 유형

그래프 이론, 그래프 탐색, 트리, DFS

<br>

### 어려웠던 점 / 문제의 핵심

트리의 지름을 구할 수 있느냐가 핵심인 문제.

처음에 문제에서 이동 거리 중 최대가 최소가 되는 지점이 최적의 소방서 위치라고 해서 매개 변수 탐색 문제인줄 알았는데 아니었다.

왜냐하면 단순히 문제에서 원하는 최적의 이동 거리를 찾는 것에서 끝나지 않기 때문이다. 최적의 이동거리를 찾으려면 결국 최적의 노드를 찾아야 한다. 그런데 최적의 노드는 매개 변수 탐색으로 찾을 수 없고 완전 탐색을 해야한다.

간선의 개수가 N - 1개이기 때문에 조금만 잘 생각해보면 답을 찾을 수 있다.

주어진 트리를 최대한 길게 펼치면 가장 긴 특정 두 노드 사이의 거리를 찾을 수 있을 것이다. 이를 트리의 지름이라 하고, 어떤 노드에서 출발해서 다른 한 노드로 이동했을 때의 누적 거리 중 가장 큰 값이다.

간선의 수가 N - 1이라는 것은 어떤 노드에서 다른 노드로 가는 경로가 유일하다는 것과 같기 때문에 이동 거리 중 최대가 최소가 되는 지점은 결국 트리의 지름에서 지름의 절반(내림)을 뺀 값과 같다.

DFS로 트리의 지름을 구하기 위해서는 특정 노드에서 출발해서 다른 모든 노드까지의 누적 이동 거리를 구한 다음에, 구한 누적 이동 거리 중 가장 큰 값을 가진 노드를 구한다.

이를 가장 먼 노드1이라고 하고, 가장 먼 노드1에서 DFS 탐색을 통해 똑같이 다른 모든 노드까지의 누적 이동 거리를 구한다. 여기서 구한 누적 이동 거리 중 가장 큰 값이 바로 트리의 지름이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 59360 KB | 584 ms        | O(N)       | O(N)       | 50분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

