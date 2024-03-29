## [골5] 가희와 프로세스 1 (21773번)

https://www.acmicpc.net/problem/21773

### 문제 유형

자료 구조, 우선순위 큐

<br>

### 어려웠던 점 / 문제의 핵심

아이디가 ids인 프로세스를 선택하는 문제인줄 알았는데, 일반적인 기초 우선순위 큐를 활용하는 문제였다.

다른 모든 프로세스의 우선순위를 1증가시킨다는 의미는 현재 프로세스의 우선순위를 1감소시키는 것과 같다.

T > 0 && 우선순위 큐가 비어있지 않은 동안 반복하여 문제에서 주어진 우선순위에 따라 현재 실행시킬 프로세스를 뽑으면 된다.

우선순위 큐에서 프로세스를 뽑았을 때, 실행 시간도 감소시켜줘야 한다. 만약 감소시킨 실행시간이 0보다 크면 다시 스케줄러(우선순위 큐)에 넣는다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 81732 KB | 1464 ms       | O(T)       | O(N)       | 25분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

