## [골4] 암벽 등반 (2412번)

https://www.acmicpc.net/problem/2412

### 문제 유형

자료 구조, 그래프 이론, 그래프 탐색, BFS, 해시를 사용한 집합과 맵, 이분 탐색

<br>

### 어려웠던 점 / 문제의 핵심

문제 유형에 왜 이분 탐색이 있는지는 모르겠다.

문제 자체는 크게 어려운 문제가 아닌데, 최적화를 할 수 있을까에 대해 많이 고민했다.

BFS를 구현하면 되는 문제이기 때문에 어려운 부분은 없었지만, HashSet을 사용할지, HashMap을 사용할지, 아니면 둘 다 사용해야할 지 고민을 좀 했다.

처음에는 2개의 HashSet으로 방문 체크를 하려했으나, 굳이 그럴 필요 없이 Integer를 Key로 가지고, HashSet을 Value로 가지는 HashMap을 선언해서 사용하였다. Key로 사용한 좌표는 x좌표이다.

#### 문제 풀이

- BFS 탐색을 하면서 `|a - x| <= 2` 범위에 있는 값이 Key로 존재하면, y좌표에 대해 `|b - y| <= 2`의 값이 HashSet에 존재하는지 찾는다.
- 존재한다면 큐에 삽입하고, HashSet에서 `|b - y|` 값을 지운다. 
- 큐에서 뽑은 y좌표가 T이면 탐색을 종료하고 현재까지 이동한 횟수를 반환하면 된다. 
- T까지 도달하지 못할 때는 -1을 반환한다. 

최적화 고민을 하면서 더불어 문제 유형에 왜 이분탐색이 있는지는 잘 모르겠다. 뭐 어떻게 하면 이분탐색으로 풀 수 있을 것 같은데 좌표라서 감이 잘 안 온다. 횡으로 왔다 갔다 하다가 y축 상으로 더 높은 곳에 갈 수 있는 경우도 있어서 생각하기  쉽지 않은 것 같다.

<br>

### 언어별 풀이 요약

풀이 로직은 Python3와 Java가 같은데, Python3는 집합 자료형만 사용했고, Java는 둘 다 사용했다. 아마 Python3도 Java처럼 풀었다면, 탐색 과정에서 낭비가 없었을 것 같아 조금 더 빠르게 풀 수 있을 것 같다. Python3는 Pypy3로 제출함.

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | --------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python | 121996 KB | 280 ms        | O(N * 5)   | O(N)       | 60분      | 3         | :white_large_square: |
| Java   | 54316 KB  | 556 ms        | O(N * 5)   | O(N)       | 40분      | 1         | :white_large_square: |
| Kotlin |           |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

