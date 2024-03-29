## [플5] 선분 그룹 (2162번)

https://www.acmicpc.net/problem/2162

### 문제 유형

자료 구조, 기하학, 분리 집합, 선분 교차 판정

<br>

### 어려웠던 점 / 문제의 핵심

문제 자체는 `선분 교차 판정`하는 방법을 정확하게 알고 있다는 가정 하에 어려운 문제는 아니다.

오히려 `선분 교차 판정`하는 방법을 찾는 게 더 어려운 문제이다. (정확하게 선분 교차 판정하는 방법은 따로 정리함)

특히, 두 선분이 같은 선상에 있을 때 교차를 판별하기 위해 대소비교를 하는 부분이 어렵다.

풀이 자체도 간단한데, N * (N - 1)번 순회하여 서로 다른 두 선분이 교차하는지 판별한 뒤에, 교차한다면 `find`함수로 부모가 같은지 확인 후 부모가 같지 않다면 `union`하여 병합하면 끝난다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |          |               |            |            |           |           |                    |
| Java   | 19968 KB | 360 ms        | O(N ^ 2)   | O(N)       | 80분      | 5         | :white_check_mark: |
| Kotlin |          |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```

