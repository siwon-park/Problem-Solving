## [골4] 회전 초밥 (15961번)

[https://www.acmicpc.net/problem/15961]()

### 문제 유형

투 포인터, 슬라이딩 윈도우

<br>

### 어려웠던 점 / 문제의 핵심

`2531`번 문제와 동일한 문제이므로 자세한 내용은 생략한다.

처음에 집합 자료형을 통해 먹을 수 있는 초밥의 종류를 계산하려고 했는데,

생각해보니 이미 중복이 없는 자료형에서 포인터를 옮겼다고 삭제해버리면 현재 구간에 해당 초밥의 종류가 있음에도 삭제하는 경우가 발생하니

카운트 배열을 통해서 먹을 수 있는 초밥의 종류를 계산하였다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | --------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python | 141088 KB | 3556 ms       | O(N + k)   | O(N + k)   | 38분      | 1         | :white_large_square: |
| Java   |           |               |            |            |           |           |                      |
| Kotlin |           |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

