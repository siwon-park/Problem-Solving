## [실3] 수강신청 (13414번)

https://www.acmicpc.net/problem/13414

### 문제 유형

구현, 자료 구조, 집합과 맵

<br>

### 어려웠던 점 / 문제의 핵심

기본적으로 대기열에 들어온 순서를 보장해야 하므로 `LinkedHashSet`을 사용하였다.

이미 대기열에 있는 상태에서 다시 들어오려고 한다면, 대기 목록의 맨 뒤로 밀려나야 하므로 LinkedHashSet에서 삭제한 다음, 다시 삽입한다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 70524 KB | 788 ms        | O(N)       | O(N)       | 15분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

