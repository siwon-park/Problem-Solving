## [골3] 우주신과의 교감 (1774번)

https://www.acmicpc.net/problem/1774

### 문제 유형

그래프 이론, 최소 스패닝 트리

<br>

### 어려웠던 점 / 문제의 핵심

이미 연결되어 있는 정점을 제외하고 나머지 정점을 연결하여 MST를 구성한다고 했을 때 필요한 정점 간의 거리 합을 소수점 둘째 자리까지 반올림하여 계산하면 된다.

#### 실수했던 점1

연산 과정에서 고통 받았다.

일단, `Math.round(ans * 100) / (double) 100`과 `String.format("%.2f", ans)`는 다르다.

ans = 0.05라고 할 때, 두 코드의 실행 결과는 다르다.

- Math.round(ans * 100) / (double) 100
  - ans * 100 = 500.0 → Math.round() → 500 → / (double) 100 = `0.05`
- String.format("%.2f", ans)
  - `0.10`

#### 실수했던 점2

연산 과정에서 원래의 범위를 벗어날 경우에는 반드시 캐스팅을 해줘야 한다.

```java
// 올바른 코드
static double calDist(int x1, int x2, int y1, int y2) {
    long ret = (long) (x1 - x2) * (x1 - x2) + (long) (y1 - y2) * (y1 - y2);
    return Math.sqrt(ret);
}

// 잘못된 코드 (오버플로우 발생)
static double calDist(int x1, int x2, int y1, int y2) {
    long ret = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    return Math.sqrt(ret);
}
```

결과를 long형으로 선언했다고 해도, 두 번째 코드는 연산 과정에서 오버 플로우가 발생한다.

왜냐하면 int형을 서로 곱했을 때의 결과는 기본적으로 int형에 담는데, x와 y의 범위가 0 ~ 100만이기 때문에 연산 과정에서 int형을 초과하여 오버 플로우가 발생한다.

따라서 long형으로 명시적 캐스팅을 해줘야 한다. 결과만 long형으로 선언한다고 해서 끝나는 게 아니다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도        | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | --------- | ------------- | ----------------- | ---------- | --------- | --------- | -------------------- |
| Python | 109932 KB | 1372 ms       | O((N ^ 2) * logN) | O(N ^ 2)   | 60분      | 3         | :white_large_square: |
| Java   | 45784 KB  | 776 ms        | O((N ^ 2) * logN) | O(N ^ 2)   | 40분      | 4         | :white_large_square: |
| Kotlin |           |               |                   |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

