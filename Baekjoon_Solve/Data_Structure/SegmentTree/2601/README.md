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

