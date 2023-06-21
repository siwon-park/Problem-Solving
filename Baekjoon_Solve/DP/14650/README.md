## [실2] 걷다보니 신천역 삼 (Small) (14650번)

https://www.acmicpc.net/problem/14650

### 문제 유형

DP

<br>

### 어려웠던 점 / 문제의 핵심

숫자 0, 1, 2만 가지고 3의 배수를 만들어야 한다.

문제를 풀 수 있는 핵심은 3으로 나눴을 때의 나머지이다. 어떤 수를 3으로 나누면 나머지는 0, 1, 2이 나올 수 밖에 없다.

N자리 수를 만들기 위해서는 N - 1자리 수의 앞 또는 뒤에 0, 1, 2울 붙여야 한다. (단, 앞에 0을 붙이는 건 제외)

그런데 사실 앞과 뒤를 둘 다 고려할 필요가 없는게 2 뒤에 1을 붙이는 것과 1 앞에 2를 붙이는 것의 결과는 같기 때문에 사실상 뒤에 붙이는 것만 고려하면 된다.

점화식은 다음 그림과 같다.

![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/88680ed6-548e-4e81-b273-f8ada48254ad)

- N자리 수가 3의 배수인 경우
  - N - 1자리 수가 3의 배수인 경우에 0을 붙임
  - N - 1자리 수를 나눴을 때 나머지가 1인 경우에 2를 붙임
  - N - 1자리 수를 나눴을 때 나머지가 2인 경우에 1을 붙임
- N자리 수를 나눴을 때 나머지가 1인 경우
  - N - 1자리 수가 3의 배수인 경우에 1을 붙임
  - N - 1자리 수를 나눴을 때 나머지가 1인 경우에 0을 붙임
  - N - 1자리 수를 나눴을 때 나머지가 2인 경우에 2를 붙임
- N자리 수를 나눴을 때 나머지가 2인 경우
  - N - 1자리 수가 3의 배수인 경우에 2을 붙임
  - N - 1자리 수를 나눴을 때 나머지가 1인 경우에 1을 붙임
  - N - 1자리 수를 나눴을 때 나머지가 2인 경우에 0를 붙임

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python | 31256 KB | 40 ms         | O(N)       | O(N)       | 30분      | 1         | :white_large_square: |
| Java   |          |               |            |            |           |           |                      |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```
