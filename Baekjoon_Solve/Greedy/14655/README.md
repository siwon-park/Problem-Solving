## [실5] 욱제는 도박쟁이야!! (14655번)

https://www.acmicpc.net/problem/14655

### 문제 유형

그리디

<br>

### 어려웠던 점 / 문제의 핵심

이 문제는 주어지는 모든 숫자의 절대값을 더하면 되는 문제이다.

왜냐하면 "동전 배열의 양 끝에서 벗어나서 양 끝의 동전만 뒤집거나 양 끝의 두 개 동전만 뒤집는 것도 가능하다."라고 한 조건 때문이다.

이 조건 때문에 연속된 3개의 동전을 뒤집는다고 하더라도 동전을 뒤집을 수 있는 횟수에 제한이 없기 때문에 배열의 숫자를 원하는 대로 변경이 가능해진다.

그래서 결국 최댓값 - 최솟값(음수)의 결과가 최대가 되는 경우는 두 동전 배열의 절댓값 합이 된다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   |          |               |            |            |           |           |                      |
| Kotlin | 16100 KB | 120 ms        | O(N)       | O(1)       | 20분      | 1         | :white_large_square: |

<br>

### 예외(테스트) 케이스

```
```

