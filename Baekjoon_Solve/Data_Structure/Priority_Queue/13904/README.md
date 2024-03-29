## [골3] 과제 (13904번)

https://www.acmicpc.net/problem/13904

### 문제 유형

자료 구조, 우선순위 큐, 정렬, 그리디

<br>

### 어려웠던 점 / 문제의 핵심

올 초에 풀었을 때보다 코드가 많이 간결해졌다! 확실히 이 때 코드를 보면, Java에 아직 덜 익숙한 게 눈에 보였다.

굳이 쓸 데 없이 연산을 더 하거나 정렬을 간단하게 해도 되는데, Comparable을 구현하여 정렬하고 있었다. 물론 Comparable을 구현하여 compareTo를 Override하는 것을 연습하기 위해서 한 것 같지만, 전체적으로 우선 순위 큐를 사용할 때, peek()을 안 쓰고 poll()한 다음에 확인하여 조건에 맞으면 새로운 요소를 넣고 아니면 다시 원래 요소를 넣는 방식으로 구현하고 있었다.

Python의 경우 우선순위 큐에 peek()이 없어서 그런 방식으로 구현하는 것이 맞는 방법이라 이 방법에 아직도 더 익숙했던 것 같다.

#### 문제 풀이

주어지는 과제별 마감 기한과 점수를 마감 기한이 짧은 순, 과제 점수가 작은 순으로 정렬한다.

그 후 과제 점수가 작은 것이 우선순위가 더 높은 우선순위 큐를 정의한다.

과제 배열을 순회하면서, 현재 과제의 마감 기한이 우선순위 큐의 크기보다 크면 우선순위 큐에 삽입한다. 우선순위 큐의 크기가 의미하는 바는 현재 일자이다. 즉, 모든 과제는 현재 일자 이하로 최대한 많이 끝낼 수 있어야 한다.

예를 들면, 우선순위 큐의 크기가 4인데 현재 과제가 마감 기한이 6, 점수가 5일 경우, 그 과제를 굳이 6일차에 끝낼 필요 없이 5일차에 먼저 일단 끝내는 것이 이득이기 때문에 우선순위 큐에 삽입하는 것이다.

이런 식으로 계속하다가 현재 과제의 마감 기한이 우선 순위 큐의 크기보다 작거나 같으면, 우선순위 큐의 맨 위에 있는 과제의 점수를 확인하여 점수가 현재 과제보다 더 작다면 그 과제를 우선순위 큐에서 뽑고 현재 과제를 넣는다. 아닐 경우 현재 과제를 넣지 않는다.

과제 배열을 날짜 순으로 오름차순 정렬했기 때문에 현재 과제의 마감 기한은 우선순위 큐 안에 있는 과제들의 마감 기한보다 크거나 같다. 따라서 점수만 확인하면 되는 것이고, 우선순위 큐의 크기만큼의 일자 안에 우선순위 큐 안에 있는 과제들을 순서에 관계없이 해결하면 되는 것이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python | 32896 KB | 48 ms         | O(N)       | O(N)       | 40분      | 1         | :white_large_square: |
| Java   | 14692 KB | 152 ms        | O(N)       | O(N)       | 30분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

