## [골2] 합이 0인 네 정수 (7453번)

https://www.acmicpc.net/problem/7453

### 문제 유형

이분 탐색, 정렬, 투 포인터, 밋 인더 미들

<br>

### 어려웠던 점 / 문제의 핵심

A[a], B[b], C[c], D[d]의 합이 0인 (a, b, c, d) 쌍의 개수를 구해야 하는 아주 간단한 문제이다.

두 배열 쌍의 합을 저장한 배열 2개를 만들고 이분 탐색 lowerBound, upperBound로 합이 0이 되는 경우를 찾아서 값을 더해주는 방식으로 풀려고 했다.

#### 처음 시도했던 것

전체적인 문제 접근법은 맞았지만, 아주 크게 실수할 뻔했다.

AB, CD 두 배열의 쌍의 합을 구하고, 새로운 두 배열에 대해서만 이분 탐색을 해주면 끝나는 문제였지만, 처음에 (AB, CD), (AC, BD), (AD, BC) 이렇게 3개의 쌍에 대해 모두 탐색하려고 하였다.

하지만, 사실 위에서 말했던 것처럼 어느 한 쌍에 대해서만 이분 탐색을 진행하면 된다.

저렇게 계산하는 것은 같은 내용의 계산을 결국 3번씩 하는 것이다.

왜냐하면 네 수의 `합`이기 때문에 `(A + B) + (C + D) = K`일 경우 `(A + C) + (B + D) = K`로 덧셈의 교환 법칙이 성립하기 때문이다.

따라서 각각 두 쌍의 배열에 대해 두 배열 간 합의 결과를 저장한 N ^ 2 크기의 배열 2개를 만들고, 이분 탐색을 통해 어느 한쪽의 값을 `K`라 할 때, 다른 상대편 배열에 `-K`의 값이 존재하는지 찾아서 그러한 경우의 수를 모두 더하면 된다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도             | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | --------- | ------------- | ---------------------- | ---------- | --------- | --------- | -------------------- |
| Python |           |               |                        |            |           |           |                      |
| Java   | 166196 KB | 5952 ms       | O(N ^ 2 * log (N ^ 2)) | O(2 * N^2) | 40분      | 1         | :white_large_square: |
| Kotlin |           |               |                        |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```
