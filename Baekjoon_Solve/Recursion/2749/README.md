## [골2] 피보나치 수 3 (2749번)

https://www.acmicpc.net/problem/2749

### 문제 유형

수학, 분할 정복을 이용한 거듭 제곱

<br>

### 어려웠던 점 / 문제의 핵심

[피보나치 수 6 (11444번)](https://www.acmicpc.net/problem/11444) 문제와 MOD값만 다르고 완전히 동일한 문제이다.

분할 정복을 통해 값을 구하기 위한 점화식은 다음과 같다.

- n이 짝수일 때
  - F(n) = F(n / 2) * (F(n / 2) + 2 * F(n / 2 - 1))
- n이 홀수일 때
  - F(n) = F((n + 1) / 2) ^ 2 + F((n + 1) / 2 - 1) ^ 2

MOD 값이 100만으로 작지만 Integer 형의 곱셈이기 때문에 연산 과정에서 Integer의 범위를 벗어날 수도 있다. 따라서 HashMap 및 다른 정수형 변수들을 Long형으로 선언해서 사용해야 한다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |          |               |            |            |           |           |                    |
| Java   | 14376 KB | 132 ms        | O(logN)    | O(logN)    | 40분      | 1         | :white_check_mark: |
| Kotlin |          |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```
