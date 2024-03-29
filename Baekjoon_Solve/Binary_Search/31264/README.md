## [실1] 사격 (31264번)

https://www.acmicpc.net/problem/31264

### 문제 유형

그리디, 이분 탐색, 매개 변수 탐색

<br>

### 어려웠던 점 / 문제의 핵심

매개 변수 탐색을 통해 최적의 최소 시작 사격 점수를 찾는 문제.

표적들을 정렬하고 이분 탐색으로 현재 시작 사격 점수(`mid`)값을 구한 다음에, 그리디하게 맞출 표적을 선택해야 하는 것이 핵심이다.

현재 맞출 수 있는 표적 중 가장 점수가 높은 표적을 선택 가능하며, 동일한 표적을 중복해서 맞출 수 있다고 했으므로, 그리디하게 선택하는 것임을 알 수 있다.

단, 현재 표적을 맞출 수 있다고 해도 해당 표적을 선택하는 것이 항상 최적의 해는 아니다. 현재 사격 실력(`stat`)으로 다음 표적도 맞출 수 있는 경우가 존재하기 때문이다.

맞출 표적을 그리디하게 선택하는 로직을 구현하는 부분에서 틀린 부분이 있어서 많은 시간을 소비했다.

그래서 이분 탐색의 `lowerBound` 개념을 추가적으로 활용했다.

어차피 사격 총 횟수는 `M`으로 상한선이 있고 M번 동안 lowerBound를 통해 현재의 사격 실력으로 맞출 수 있는 N개의 표적 중 최적값을 찾아서 선택하는 방식으로 구현하였다.

- 단, 일반적인 lowerBound는 최적의 삽입 위치가 맨 끝일 경우 N을 반환해야 하지만 이는 현재 스탯과 arr[idx]를 비교할 때 인덱스를 초과하기 때문에 최대 N - 1을 반환해야 한다.
- 만약 `arr[idx] <= stat`이면 arr[idx]를 선택하면 된다. 하지만 아닐 경우에는 idx - 1의 인덱스와 비교를 한 다음에 선택 가능하면 선택하면 된다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도      | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | --------------- | ---------- | --------- | --------- | ------------------ |
| Python |          |               |                 |            |           |           |                    |
| Java   | 29516 KB | 524 ms        | O(logN*(MlogN)) | O(N)       | 150분     | 5         | :white_check_mark: |
| Kotlin |          |               |                 |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```

