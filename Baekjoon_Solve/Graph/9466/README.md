## [골3] 텀 프로젝트 (9466번)

[https://www.acmicpc.net/problem/9466]()

### 문제 유형

그래프 이론, 그래프 탐색, 깊이 우선 탐색

<br>

### 어려웠던 점 / 문제의 핵심

사이클을 이루는 노드의 수를 세면 되는 문제이다.

그런데 중요한 점은 사이클을 판별하고 그 안에 속한 노드의 수를 어떻게 세느냐를 효율적으로 설계하는 게 가장 중요한 문제이다.

만약에 사이클에 속한 노드만 찾기 위해 `dfs`를 사용하여 `출발지 노드와 탐색 도중 나온 노드가 같다면` 사이클이라 판별 후 종료하게 한다면 한 가지 큰 문제가 생기는데, 노드를 중복 방문하게 되어 결국에는 `O(N ^ 2)`의 시간이 걸리게 된다.

그 이유는 정확히 사이클인 관계만을 찾기 위해 탐색하다 보니 그렇다. 예를 들면,

- 1번 노드 탐색: 탐색 경로`1 → 2 → 3 → 4 → 5 → 2` 인 경우
  - "원하는 사이클은 정확히 `2 → 3 → 4 → 5 → 2`인데, `1`이 포함되어 있잖아? 정확한 사이클이 아니야"
- 2번 노드 탐색: 탐색 경로 `2 → 3 → 4 → 5 → 2`인 경우
  - "어! 정확히 우리가 원하는 사이클 관계야 출발 노드와 마지막 도착 노드가 같아!"
- 하지만 이 과정에서 우리는 2, 3, 4, 5번 노드를 2번 탐색했다. 
  - 정확한 사이클 관계를 찾기 위해 매번 방문 배열을 초기화한다거나, 다시 백트랙킹하는 과정이 추가되어야만 2번 노드부터 출발하는 경로를 탐색할 수 있다.
- 따라서 만약 최악의 경우라면 `O(N ^ 2)`이 걸릴 수 밖에 없다.

####  올바른 접근법

`O(N)`의 탐색으로 문제를 해결해야 한다.

따라서 `dfs` 탐색을 하되, 사이클 관계에 있는 노드만 정확히 카운트 해줘야 한다.

이를 위해서는 사이클에 속하는 노드를 카운트했는지 확인하는 배열이 추가적으로 필요하다.

- 만약 사이클임이 확인되면, 현재의 `다음 노드가 사이클 노드로 카운트 되었는지 확인`한다.
  - 사이클에 속하는 노드의 개수(전역 변수) += 1을 한다. 이는 사이클에 속하는 자기 자신을 카운트한 것이다.
  - 그리고 `현재 노드 != 다음 노드`인 동안 사이클 관계에 있는 노드로 이동하면서 사이클에 속하는 노드의 개수를 += 1해준다.



[아래 내용은 dfs 구현에 따른 차이가 있음]

- dfs를 빠져나가기 전에 사이클 카운트 유무와 상관 없이 사이클 노드로 카운트되었음을 `true`로 바꿔준다.
  - 이는 탐색할 필요가 없는 곳을 탐색하지 않게 하여 무한 루프를 방지하기 위함이다.
  - 이 과정을 단순히 다음 노드가 사이클 노드로 카운트되지 않았을 때만 `true`로 체크하게 된다면
    - `1 → 3`, `3 → 3`, `2 → 1`인 관계에서 `1`번 노드를 dfs 탐색하면서 3번에 대해서만 배열에 `true`로 체크하게 되어 `2`번 노드에서 출발했을 때, `1`번 노드가 사이클 노드로 카운트되지 않았으니 방문하게 되고 `3`번을 방문하는 순간 무한 루프를 돌게 된다.
- 위의 로직이 이해가 안 간다면, 사이클을 카운트할 때 사이클 체크 유무를 `true`로 체크하고 매번 사이클 체크 유무를 조건으로 추가하여 확인하는 과정을 넣거나 다른 조건들을 추가하여 중복 방문이라던지, 방문할 필요가 없는데 방문하는 경우를 제거하면 된다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | --------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |           |               |            |            |           |           |                    |
| Java   | 306656 KB | 1212 ms       | O(NT)      | O(N)       | 60분      | 1         | :white_check_mark: |
| Kotlin |           |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```

