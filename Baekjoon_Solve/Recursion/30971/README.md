## [실2] 육회비빔밥 (30971번)

https://www.acmicpc.net/problem/30971

### 문제 유형

브루트포스, 백트랙킹

<br>

### 어려웠던 점 / 문제의 핵심

문제를 잘 읽어보면, 매 순간 K 이하의 뻔뻔함을 유지하면서 순열을 구성했을 때의 감칠맛의 최댓값을 구하면 되는 문제이다.

조합이 아니라 순열인 이유는, 감칠맛의 계산식이 Ai-1 *Bi이기 때문에 이전에 선택한 번호가 몇 번인지에 따라서 결과값이 달라질 수 있기 때문이다.

첫 번째 선택한 육회 비빔밥의 감칠맛을 구할 때는 이전에 선택한 값이 없기 때문에 쉬운 계산을 위해서 배열을 N + 1개로 선언한 다음에 0번 인덱스를 활용하면 된다.

- 0번 인덱스에 존재하는 값인 A[0], B[0], C[0]을 전부 0으로 두면,
- 첫 번째 선택했을 때는 눈치를 받지 않는다고 했기 때문에 눈치값이 0이고, 맛의 감칠맛도 0이 된다. (감칠맛은 두 번째부터 계산할 수 있기 때문)

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 14544 KB | 280 ms        | O(N^2)     | O(N)       | 30분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```
