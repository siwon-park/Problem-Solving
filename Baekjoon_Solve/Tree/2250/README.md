## [골2] 트리의 높이와 너비

[https://www.acmicpc.net/problem/2250]()

### 문제 유형

그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색

<br>

### 어려웠던 점 / 문제의 핵심

DFS를 1번 돌려서 가장 끝에 있는 노드를 찾고, 해당 노드를 루트로해서 레벨을 구성하면 2번째 DFS로 돌린 값은 너비가 될 줄 알았는데, 아니었다.

알고보니 주어진 트리를 루트에서부터 `중위 순회`한 순서 간 차이가 트리의 너비가 되는 것이었다.

```java
static void inOrder(int n, int lv) { // 중위 순회
    if (n == -1) return;
    inOrder(tree[n][0], lv + 1);
    MAX_LV = Math.max(MAX_LV, lv);
    maxWeigth[lv] = Math.max(maxWeigth[lv], ++w); // 최댓값 갱신
    minWeigth[lv] = Math.min(minWeigth[lv], w); // 최솟값 갱신
    inOrder(tree[n][1], lv + 1);
}
```

더 중요한 것은 문제의 예시처럼 1번 노드가 루트 노드라는 말이 없으므로, 부모 배열을 만들어서 `루트 노드를 직접 찾아야 한다.`

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 20988 KB | 256 ms        | O(N)       | O(N)       | 60분      | 2         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```
