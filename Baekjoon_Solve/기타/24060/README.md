## [실4] 알고리즘 수업 - 병합 정렬 1 (24060번)

https://www.acmicpc.net/problem/24060

### 문제 유형

구현, 정렬, 재귀

<br>

### 어려웠던 점 / 문제의 핵심

값이 실제 배열에 저장되는 순간이 어디인지 파악하는 것이 핵심

임시 배열에 값을 저장 하는 작업이 모두 끝난 다음에

임시 배열의 값을 다시 원본 배열로 옮기는 그 순간이 실제 배열에 값이 저장되는 순간이다.

```java
// merge 메서드 중
for (i = s; i <= e; i++) {
    arr[i] = tmp[i - s]; // 원본 배열에 임시 배열에 기록된 값을 저장
    save ++; // 저장 횟수 카운트 증가
    if (save == K) ans = arr[i];
}
```

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 74140 KB | 652 ms        | O(NlogN)   | O(N)       | 25분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

