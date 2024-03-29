## [골3] 성곽 (2234번)

https://www.acmicpc.net/problem/2234

### 문제 유형

그래프 이론, 그래프 탐색, BFS, 비트마스킹

<br>

### 어려웠던 점 / 문제의 핵심

구해야 하는 것들은 다음과 같은 의미를 가지고 있다.

- 성에 있는 방의 개수 = `연결 컴포넌트의 개수`
- 가장 넓은 방의 넓이 = `연결 컴포넌트 중 가장 큰 연결 컴포넌트의 크기`
- 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기 = `인접한 연결 컴포넌트를 1개까지 포함한 최대 넓이`

![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/8b83cd23-dba0-4347-bb2e-64198f07a5c7)

벽에 대한 정보가 하나의 정수로 주어지고, 서쪽에 벽이 있을 때는 1을, 북쪽에 벽이 있을 때는 2를, 동쪽에 벽이 있을 때는 4를, 남쪽에 벽이 있을 때는 8을 더한 값이 주어진다.

따라서 0 ~ 15의 값이 정수로 주어지고 이를 비트로 나타내면 다음과  같이 표현할 수 있다.

![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/46885089-4746-4b42-b586-e0e2fb8ba538)

0 <= k < 4를 만족하는 k에 대해 `1 << k`와 해당 정수의 비트 AND 연산을 통해 나온 값이 `0`이라면 해당 방향은 벽이 없어서 지나갈 수 있다는 의미이기 때문에 탐색을 진행한다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python | 34272 KB | 112 ms        | O(MN)      | O(MN)      | 40분      | 1         | :white_large_square: |
| Java   |          |               |            |            |           |           |                      |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

