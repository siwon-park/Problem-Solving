## [다5] 벽 (10070번)

https://www.acmicpc.net/problem/10070

### 문제 유형

자료 구조, 세그먼트 트리, 느리게 갱신되는 세그먼트 트리

<br>

### 어려웠던 점 / 문제의 핵심

op 값이 1일 때는 max 연산을, 2일 때는 min 연산을 해야 한다.

세그먼트 트리에는 구간의 lower bound와 upper bound를 저장한다.

BufferedWriter를 쓰니 메모리 초과가 나서 StringBuilder를 사용했다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | --------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |           |               |            |            |           |           |                    |
| Java   | 522872 KB | 1648 ms       | O(NlogN)   | O(N * 4)   | 200분     | 3         | :white_check_mark: |
| Kotlin |           |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```

