## [실1] 버섯 농장 (27737번)

https://www.acmicpc.net/problem/27737

### 문제 유형

그래프 이론, 그래프 탐색, 너비 우선 탐색, 수학

<br>

### 어려웠던 점 / 문제의 핵심

포자를 하나 심으면 최대 k배, 즉 k를 곱한 칸 수만큼 퍼질 수 있기 때문에 결국에는 버섯을 심을 수 있는 연결 컴포넌트에 포함된 영역의 크기를 구하는 것이 핵심이다.

영역의 크기를 구했을 때 k로 나눠 떨어진다면 k로 나눈 몫을 더하고, 나누어 떨어지지 않는다면 k로 나눈 몫 + 1을 더해준다.

최종적으로 `포자를 1개 이상 사용했고`, 사용한 포자의 개수가 M을 초과하지 않는다면 버섯을 심을 수 있다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 15652 KB | 148 ms        | O(N^2)     | O(N^2)     | 30분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```
