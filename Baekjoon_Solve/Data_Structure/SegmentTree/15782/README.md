## [플2] Calculate! 2 (15782번)

[https://www.acmicpc.net/problem/15782]()

### 문제 유형

자료 구조, 세그먼트 트리, 느리게 갱신되는 세그먼트 트리, 깊이 우선 탐색

<br>

### 어려웠던 점 / 문제의 핵심

`XOR (12844번)`과 `XOR(14245)`번과 비슷한 유형의 문제

기본적으로 세그먼트 트리를 구성하는 것과 lazy배열의 값을 전달하는 방법은 위 두 문제와 유사하나, 주어지는 트리를 오일러 경로로 풀어줘야 한다.

따라서 깊이 우선 탐색을 통해 전위 순회 결과와 해당 노드를 루트로 하는 서브 트리의 마지막 노드 번호를 구한 다음, 전위 순회 순서를 범위로 하여 `XOR`연산 및 업데이트 하면 된다.

단, 여기서 주의할 점이 주어지는 `D`배열의 값은 전위 순회 전 각 노드 번호에 대한 값이기 때문에, 이를 전위 순회했을 때의 순서로 값을 재배치 해줘야 한다. (예제 1번의 답 중 하나가 90이 아니라 91이 나오는 걸 보고 재배치가 필요하다는 것을 알게되었다.)

<br>

### 언어별 풀이 요약

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | --------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |           |               |            |            |           |           |                      |
| Java   | 208356 KB | 1140 ms       | O(MlogN)   | O(N * 4)   | 45분      | 1         | :white_large_square: |
| Kotlin |           |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

