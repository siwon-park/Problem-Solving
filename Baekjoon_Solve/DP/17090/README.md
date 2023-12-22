## [골3] 미로 탈출하기 (17090번)

https://www.acmicpc.net/problem/17090

### 문제 유형

DP, DFS, Union-Find

<br>

### 어려웠던 점 / 문제의 핵심

DP(메모이제이션) 혹은 Union-Find로 문제를 풀 수 있다.

DP 풀이의 경우에는 무한 루프 방지를 위해서 방문 체크의 개념이 들어가야 한다. 밖으로 나갈 수 있다면 함수가 종료되겠지만, 그렇지 않고 `사이클`이 있는 경우에는 값을 return 받지 못한 채 계속해서 사이클을 돌기 때문이다. 

Union-Find의 경우에는 나갈 수 있는 칸에 대해 합병을 해주는 과정을 진행하여 최종적으로 밖으로 나갈 수 있는 집합에 속한 칸의 수를 출력하면 된다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도  | 공간복잡도    | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ----------- | ------------- | --------- | --------- | -------------------- |
| Python | 51252 KB | 756 ms        | O(MN*logMN) | O(MN + logMN) | 25분      | 1         | :white_large_square: |
| Java   | 75072 KB | 352 ms        | O(MN)       | O(MN)         | 20분      | 1         | :white_large_square: |
| Kotlin |          |               |             |               |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```
