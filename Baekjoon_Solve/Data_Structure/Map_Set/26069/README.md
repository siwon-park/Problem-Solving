## [실4] 붙임성 좋은 총총이 (26069번)

https://www.acmicpc.net/problem/26069

### 문제 유형

자료 구조, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵

<br>

### 어려웠던 점 / 문제의 핵심

`Map` 자료형과 배열을 사용해서 A 또는 B가  `"ChongChong"`인지와 어떤 사람이 현재 무지개 춤을 추고 있는지를 확인하여 조건 분기를 통해 확인하여, 무지개 춤을 추고 있는 사람의 수를 갱신하면 된다.

- 만약 A가 총총이거나 무지개 춤꾼이면
  - B가 무지개 춤꾼인지 확인하여 무지개 춤꾼이 아니라면 무지개 춤꾼으로 변경한다.
  - 이 때, B는 총총이 아니어야 한다. 총총은 원래부터 무지개 춤꾼이기 때문이다.
- 만약 B가 총총이거나 무지개 춤꾼이면
  - A가 무지개 춤꾼인지 확인하여 무지개 춤꾼이 아니라면 무지개 춤꾼으로 변경한다.
  - 이 때, A는 총총이 아니어야 한다. 총총은 원래부터 무지개 춤꾼이기 때문이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 14764 KB | 152 ms        | O(N)       | O(N)       | 25분      | 2         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

