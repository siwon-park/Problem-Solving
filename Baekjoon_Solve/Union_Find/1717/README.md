## [골4] 집합의 표현 (1717)

https://www.acmicpc.net/problem/1717

### 문제 유형

자료 구조, 분리 집합

<br>

### 어려웠던 점 / 문제의 핵심

0일 경우 union 연산을 통해서 두 원소의 집합을 하나로 합치고

1일 경우 두 원소에 대해 find 연산을 통해 부모가 같은지 확인하고 같다면 "YES"를, 다르다면 "NO"를 출력하면 된다.

union 연산에서 두 집합의 부모의 크기 비교 연산을 없애고 바로 합치게 했는데도 연산 시간에는 아무 영향이 없었다. 

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 54912 KB | 676 ms        | O(MlogN)   | O(N)       | 14분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

