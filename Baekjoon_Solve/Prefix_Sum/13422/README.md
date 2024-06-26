## [골4] 도둑 (13422번)

[문제 링크](https://www.acmicpc.net/problem/13422)

### 문제 유형

누적 합, 투 포인터, 슬라이딩 윈도우

<br>

### 어려웠던 점 / 문제의 핵심

원형의 `N`개의 집에 대해 누적합을 구한 다음에
`연속된 M개의 부분합이 K미만인 경우의 수`를 구하면 된다.

원형이기 때문에 마지막 집에서 M개를 고르는 경우를 포함해야 하므로
`원본 배열의 맨 뒤에 배열의 앞에 있는 M - 1개의 원소를 뒤에 추가`적으로 붙여줘야 한다.

엣지 케이스가 하나 있는데, `N == M`일 경우 어느 지점에서 출발하든 M개를 고를 수 있기 때문에
이 때는 `M개의 누적합이 K 미만`인지만 판단하여 경우의 수를 출력하면 된다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리 | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고 |
| ------ | ------ | ------------- | ---------- | ---------- | --------- | --------- | --------- |
| Python | 50716 KB       | 848 ms              | O(M + N)           |  O(M + N)          | 35분          |     2      |    :white_large_square:       |
| Java   |        |               |            |            |           |           |           |
| Kotlin |        |               |            |            |           |           |           |

<br>

### 예외(테스트) 케이스

```
```
