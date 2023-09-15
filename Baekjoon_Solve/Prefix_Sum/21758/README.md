## [골5] 꿀 따기 (21758번)

https://www.acmicpc.net/problem/21758

### 문제 유형

그리디 알고리즘, 누적 합, 애드혹

<br>

### 어려웠던 점 / 문제의 핵심

누적합 배열을 만들고, 3가지 케이스에 대해서 최댓값 중 가장 큰 값을 구하면 된다.

이 때, 주의할 점은 `벌이 있는 칸은 계산하면 안 된다는 것`과 `두 벌의 위치는 다르다`는 것이다.

- 1번이 꿀통일 경우, i와 N이 벌이다.
  - `prefix[N - 1] + prefix[i - 1] - arr[i]`
  - 단, i == N이어선 안 된다.

![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/8b523003-1052-42c3-a8c4-c7836dc4df3c)

- i번이 꿀통일 경우, 1과 N이 벌이다. 
  - `prefix[N - 1] - prefix[i - 1] + prefix[i] - prefix[1]`

![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/9458097d-0ca2-45e1-8b0d-5eb5a19dde4a)

- N번이 꿀통일 경우, 1과 i가 벌이다.
  - `prefix[N] - arr[1] - arr[i] + prefix[N] - prefix[i]`
  - 단, i == 1이거나 i == N이면 안 된다.

![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/e38bb149-85e4-4b48-a793-b3a76926d659)

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 25332 KB | 316 ms        | O(N)       | O(N)       | 60분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

