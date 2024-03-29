## [골5] 괄호 제거 (2800번)

https://www.acmicpc.net/problem/2800

### 문제 유형

자료 구조, 문자열, 브루트포스, 스택, 재귀

<br>

### 어려웠던 점 / 문제의 핵심

괄호가 아스키 값이 더 작다

그리고 자기 자신은 출력하면 안 된다.

스택의 개념을 활용해 올바른 괄호쌍의 인덱스를 구한 다음,

해당 괄호쌍의 부분 집합을 재귀적으로 구성하면서 괄호쌍의 인덱스에 해당하는 내용을 방문 처리하여 해당 위치의 문자열은 이어 붙지지 않도록 한다.

완성된 문자열을 사전순으로 빠른 순서대로 출력하면 된다. 이를 위해 TreeSet을 사용하였다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 28156 KB | 320 ms        | O(N^2)     | O(N)       | 35분      | 2         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

