## [플5] 중앙값 (1572번)

https://www.acmicpc.net/problem/1572

### 문제 유형

자료 구조, 세그먼트 트리, 이분 탐색

<br>

### 어려웠던 점 / 문제의 핵심

#### (1) 잘못된 접근

최솟값, 중앙값, 최댓값을 저장한 세그먼트 트리를 활용하려 했으나, 주어지는 배열이 정렬된 상태가 아니기 때문에 이 3개의 값만으로는 3개의 값이 아닌 다른 값들이 중앙값이 되는 경우가 있을 수도 있기 때문에 문제를 풀 수 없다.

#### (2) 올바른 접근

빈도수 누적 합 세그먼트 트리 + 이분 탐색으로 중앙값을 찾는 것이 핵심이다.

정렬되어 있지 않은 배열에서 이분 탐색의 사용은 불가하지만, 0부터 65563까지의 숫자가 등장한 빈도수를 배열에 저장하여 이를 이용한다면 이분 탐색이 가능해진다.

중앙값은 크기 M인 배열의 (M + 1) / 2인 위치이기 때문에 등장한 숫자의 빈도수 누적합이 적어도 (M + 1) / 2개 이상으로 만들 수 있는 빈도수 배열 상의 최소 인덱스에 해당하는 숫자가 중앙값이 된다.

 N개의 숫자가 주어지지만, 세그먼트 트리 상의 구간은 [0, 65563]이 된다. 크기가 K인 부분 수열을 슬라이딩 윈도우처럼 구간을 옮겨가며 빈도수를 누적 / 갱신하여 값을 저장하고 이분 탐색을 통해서 중앙값을 찾으면 된다.

※ 펜윅 트리 풀이법

- 크기가 최대 65565 (= 65563 + 2)인 tree 배열을 선언한다.
  - 내부적으로 인덱스를 1부터 쓰기 위함이면서 입력으로 들어오는 숫자의 최솟값이 0이기 때문에 tree[1] = 0을 사용하기 위함이다.
  - 따라서 내부적으로 계산할 때 입력 받은 숫자를 펜윅 트리상의 인덱스로 그대로 쓰면 안 되고 +1씩 해줘야 한다.
- 배열 상 최초 K개의 부분 수열에 대해 각 부분 수열의 값을 펜윅 트리상의 인덱스로 사용하여 펜윅 트리의 값을 +1씩 업데이트 해준다.
- 최초 K개의 부분 수열에 대한 중앙값을 이분 탐색을 통해서 계산한다.
- 크기가 K인 구간을 유지하면서 중앙값을 찾는다. (슬라이딩 윈도우)
  - 첫 번째 K개의 구간에 대해서는 이미 계산을 마쳤기 때문에 두 번째 구간부터 계산을 해야 하는데, 이 때 첫 번째 K개의 구간에 가장 앞에 있는 값에 대한 인덱스에 -1을 업데이트 해주고, 가장 마지막에 있는 값의 다음 값을 인덱스로 사용하여 +1을 업데이트 해준다.
  - i = 1부터 시작하여, arr[i] + 1인 인덱스에 대해  -1을 업데이트 해주고, arr[i + K] + 1인 인덱스에 대해 +1을 업데이트해주면 K개의 구간을 유지하는 셈이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |          |               |            |            |           |           |                    |
| Java   | 31444 KB | 324 ms        | O(NlogN)   | O(N)       | 70분      | 2         | :white_check_mark: |
| Kotlin |          |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```
