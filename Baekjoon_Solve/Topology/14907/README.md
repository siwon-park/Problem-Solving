## [골2] 프로젝트 스케줄링 (14907번)

https://www.acmicpc.net/problem/14907

### 문제 유형

위상 정렬, DP, 그래프 탐색, 그래프 이론

<br>

### 어려웠던 점 / 문제의 핵심

프로젝트를 완성하는데 걸리는 최소 시간은 어떤 작업을 위상정렬로 완수할 수 있을 때 걸리는 최대 시간을 의미한다.

다음 작업을 수행하는데 걸리는 최대 시간은 다음과 같이 계산할 수 있다.

`cur → nxt`를 하는데, `t`시간이 걸린다고 할 때 `time[nxt] = Math.max(time[nxt], time[cur] + t)`이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 14340 KB | 128 ms        | O(N + M)   | O(N + M)   | 35분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

