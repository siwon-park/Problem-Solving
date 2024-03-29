## [골5] 압축 (1662번)

https://www.acmicpc.net/problem/1662

### 문제 유형

재귀, 스택

<br>

### 어려웠던 점 / 문제의 핵심

재귀나 스택을 사용해야 한다는 것은 알았지만, 어떻게 계산해야 예외 없이 잘 계산할지 많은 고민을 했던 문제이다.

스택을 이용해서 ")"이 들어오려고 하면 "("이 나올 때까지 스택에서 계속 뽑아서 괄호 안의 문자열 길이를 계산한 다음 "(" 앞에 숫자와 곱하면 되는데

문제는 어떻게 정확하게 길이만을 계산하느냐 였다.

이에 대한 문제의 핵심은 다음과 같았다.

```
"(" 앞의 숫자는 그대로 두고 나머지 숫자는 전부 "1"로 변환
```

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |          |               |            |            |           |           |                    |
| Java   | 14280 KB | 128 ms        | O(N^2)     | O(N)       | 1시간     | 2         | :white_check_mark: |
| Kotlin |          |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```

