## [골1] 인터넷 설치 (1800번)

https://www.acmicpc.net/problem/1800

### 문제 유형

그래프 이론, 다익스트라, 이분 탐색, 매개 변수 탐색

<br>

### 어려웠던 점 / 문제의 핵심

매개 변수 탐색(이분 탐색)을 통해서 `특정 금액 이상의 비용을 K번 이하로 공짜 연결을 받아 N번까지 탐색할 수 있는 비용 중 가장 작은 비용`을 찾으면 된다.

#### 내가 했던 방법

2차원의 최단 거리 테이블을 만들었다. `distance[i][k]` => i번 노드로 k번 공짜 연결을 통해 갈 수 있는 최단 거리

처음 풀이는 `3224ms`로 엄청나게 느린 풀이었다.

#### 최적화

목표 노드인 N번 노드에 도달하고 나면 다익스트라 함수 호출을 종료하니 `1400ms`로 줄일 수 있었다.

#### 모범답안 + 최적화

풀이가 빠른 답을 보니, 나처럼 2차원의 최단 거리 테이블을 만든 것이 아니라, 1차원의 최단 거리 테이블을 만들고, 방문 노드에 대한 최대 비용을 기록한 것이 아니라 공짜로 연결 받은 횟수를 기록하였다.

```python
for nxt, cost in graph[cur]:
    if cost > max_pay:
        if k + 1 < distance[nxt]: # 다음 비용이 max_pay보다 크고 공짜 횟수가 K보다 작으면
            distance[nxt] = k + 1
            heapq.heappush(pq, (k + 1, nxt))
    elif k < distance[nxt]:
        distance[nxt] = k
        heapq.heappush(pq, (k, nxt))
```

또한 if-elif 구문 분기 처리가 핵심이다.

만약 `if cost > max_pay and if k + 1 < distance[nxt]`와 `elif`로 분기처리 한다면, 첫 번째 조건을 만족하지 않으면 무조건 elif 구문을 탐색하게 되고 elif 구문을 만족한다면 최소 횟수를 갱신하게 된다.

이 경우 문제가 되는 것이 cost가 무조건 max_pay 이하라고 해서 nxt로 가는데 사용하는 최소 횟수를 갱신하게 되면, `더 낮은 비용 + 조금 더 많은 k 횟수로 nxt에 갈 수 있음에도 불구하고 nxt로 가는 최단 거리 테이블을 갱신하지 못하게 된다.`

우리가 찾고자 하는 핵심은 더 낮은 비용인데, 그것을 찾는 과정에서 공짜로 연결 받은 횟수인 k를 이용하는 것일 뿐, 최소 k를 찾는 것이 아니다. 따라서 분기 처리를 위의 코드처럼 해줘야 올바른 답을 찾을 수 있다. (이렇게 분기처리 하는 것은 2차원의 최단 거리 테이블을 만든 것과 유사한 효과를 가져올 수 있다.)

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python | 37420 KB | 1400 ms       | O(PlogN)   | O(P)       | 45분      | 1         | :white_large_square: |
| Java   |          |               |            |            |           |           |                      |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

