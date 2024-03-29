## [플1] 독서실카펫 (2601번)

https://www.acmicpc.net/problem/2601

### 문제 유형

자료 구조, 세그먼트 트리, 스위핑, 느리게 갱신되는 세그먼트 트리

<br>

### 어려웠던 점 / 문제의 핵심

#### 주의점

> 이 문제는 현재 잘못된 데이터가 들어오는 문제이다.

입력 데이터가 들어와야 함에도 불구하고 들어오지 않아서 문제가 생기고 있는데, Java는 NullPointerException, Python은 ValueError가 발생할 것이다.

다음과 같이 입력 데이터가 들어와야 함에도 불구하고 들어오지 않는 경우에 대한 예외 처리를 해주면 통과할 수 있다.

```java
ArrayList<int[]> inputs = new ArrayList<>();
int c1, r2, c2, r1; // 왼쪽 상단 꼭짓점, 오른쪽 하단 꼭짓점
for (int i = 0; i < M; i++) {
    try {
        st = new StringTokenizer(br.readLine());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        inputs.add(new int[] {c1, r2, c2, r1});
    } catch (Exception e) {
        inputs.add(inputs.get(i - 1));
    }
}
```

#### 세그먼트 트리 + 스위핑

2차원의 배열 세그먼트 트리를 공부하기 위해 푼 문제이지만, 스위핑 + 세그먼트 트리로 풀 수 있는 문제이다.

한 변의 길이가 `k`인 정사각형이 (x1, y2) x (x2, y1)의 사각형을 덮으려면

- x - k <= x1 < x2 <= x
- y - k <= y1 < y2 <= y

를 만족해야 한다. 이를 다시 x와 y에 대해 각 각 정리하면

- `x2 <= x <= x1 + k`
- `y2 <= y <= y1 + k`

를 만족하면 된다.

![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/f8e011f1-badf-4100-b2f4-f32c8303b9c8)

이제 y축에 대한 구간 합 세그먼트 트리를 만들고 x에 대해 스위핑을 하면서 값을 업데이트 하면 된다.

오른쪽 그림에서 노란색으로 색칠된 부분에 x, y가 위치하면 얼룩 사각형을 커버할 수 있다. (녹색, 청색 정사각형 참고)

따라서 `x2`를 만났을 때 구간 `[y2, y1 + k]`에 `1`을 누적해준다.

그리고 `x1 + k`를 지나면 즉, `x1 + k + 1`을 만나면 구간 `[y2, y1 + k]`의 값에 `-1`을 누적해준다.

`누적 합`을 구하는 개념과 같다고 보면 된다.

#### 중요한 점

스위핑을 하기 위해 단순히 x좌표에 대해서만 정렬하면 안 된다. 우리가 구하고자 하는 값은 정사각형이 커버할 수 있는 사각형의 최댓값이기 때문에 구간에 1을 업데이트 했을 때의 구간 최댓값을 구해야 한다.

만약 x좌표에 대해서만 정렬한다면, 동일한 x에 대해 어떤 구간에 [1, -1, 1, -1, 1, -1] 이런 식으로 구간 합이 업데이트 될 경우 카펫이 커버할 수 있는 얼룩의 최댓값은 3개임에도 불구하고 구간 합의 최종 결과는 0이기 때문에 0을 출력하게 된다.

따라서 x 좌표가 빠르고, 값이 1인 것에 대해서 우선적으로 갱신 쿼리를 날려 값을 얻는 방식으로 스위핑을 해야 한다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |          |               |            |            |           |           |                    |
| Java   | 97352 KB | 820 ms        | O(MlogN)   | O(N * 4)   | 65분      | 6         | :white_check_mark: |
| Kotlin |          |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```

