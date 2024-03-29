## [골1] Gaaaaaaaaaarden (18809번)

https://www.acmicpc.net/problem/18809

### 문제 유형

구현, 시뮬레이션, 그래프 이론, 그래프 탐색, 브루트포스, BFS

<br>

### 어려웠던 점 / 문제의 핵심

#### 잘못된 시도

- 전체 땅 중 배양액을 뿌릴 수 있는 땅의 조합을 찾음
- 찾은 땅의 조합 중, 빨강(R) 또는 초록(G)에 대해 뿌릴 수 있는 조합을 찾고, 조합의 나머지에는 반대색을 칠함
- BFS + 시뮬레이션

이 풀이는 틀린 로직은 아니지만 복잡하기도 하고 시간 초과가 예상되는 풀이다.

#### 올바른 시도

- 전체 땅 중 배양액을 뿌릴 수 있는 땅의 조합을 백트랙킹으로 찾는다.
  - 현재 위치에 빨강(R)을 뿌릴 수 있으면 뿌린다.
  - (백트랙킹 후) 현재 위치에 초록(G)을 뿌릴 수 있으면 뿌린다.
- BFS + 시뮬레이션

#### 어려웠던 점

문제에서 요구하는 조건에 맞게 BFS 함수를 구현하는 부분이 조금 어려웠다.

특히나, 주의할 점이 하나 있었는데

- 현재 `t`시간에 `서로 다른 두 배양액이 마주보고 있는 상태`라면 다음 시간인 `t + 1`에는 꽃이 피지 않는다.
- 꽃이 피기 위해서는 서로 다른 두 배양액이 `t + 1`시간에 같은 곳으로 이동해서 만나야 한다.

이를 구현하기 위해 일단 `현재 사용 중인 큐`와 `다음에 사용할 큐`로 2개의 큐로 구분하였다.

- 기본적으로 `현재 사용 중인 큐`의 크기만큼 순회한다.
- 배양액이 다음 이동할 위치가 호수(`0`)가 아니면 `다음에 사용할 큐`에 삽입한다. (큐에 모은 뒤 한 번에 처리함)
- `현재 사용 중인 큐`가 비었으면 이제 `다음 사용에 사용할 큐`에 대해 처리한다.
  - `다음에 사용할 큐`에서 요소들을 뽑아서 다음 이동할 위치가 호수가 아닐 경우에 원래 있었던 배양액의 색을 기록하고, `현재 사용 중인 큐`에 삽입한다.
  - 다음 위치에 배양액이 기록되어 있는데, 반대 배양액일 경우 해당 위치를 `0`으로 만들고, `만들 수 있는 꽃의 개수를 += 1해준다.`
- `현재 사용 중인 큐`가 비어있지 않는 동안 위의 과정을 반복한다.
  - 단, `다음에 사용할 큐`에서 요소를 뽑아서 순차 처리하는 과정에 있어서 나중에 반대 배양액이 들어와서 꽃이 필 위치였는데, 현재 배양액을 기록하고 `현재 사용 중인 큐`에 삽입하는 경우가 있기 때문에
  - `현재 사용 중인 큐`에서 요소를 뽑았을 때 해당 요소의 위치에 기록된 값이 `0`이면 `continue`하여 예외 처리를 해준다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도           | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | --------- | ------------- | -------------------- | ---------- | --------- | --------- | -------------------- |
| Python |           |               |                      |            |           |           |                      |
| Java   | 305524 KB | 1168 ms       | O(MN + (R + G) * MN) | O(MN)      | 180분     | 1         | :white_large_square: |
| Kotlin |           |               |                      |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

