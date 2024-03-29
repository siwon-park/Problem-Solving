## [실3] 게임 (1072번)

https://www.acmicpc.net/problem/1072

### 문제 유형

수학, 이분탐색

<br>

### 어려웠던 점 / 문제의 핵심

`((Y + a) * 100) // (X + a)`의 값이 `Z`보다 큰 `a`를 찾는 문제이다.

이는 브루트포스를 사용하게 되면 `X`의 범위가 최대 10억이고 `Y <= X`이기 때문에 제한 시간 안에 찾기 힘들다.

따라서 이분 탐색을 통해서 찾아야 한다.

그럼 `a`의 탐색 범위를 몇으로 해야 할까?

절대 `Z`가 변하지 않는 경우부터 살펴보자. `X == Y`인 경우이다.

절대 변하지 않는다고 했기 때문에 `a`에 `X`를 대입해도 변하지 않아야 한다. 이를 방정식으로 풀면 `2Y = X + Y`가 되고, `X = Y`가 된다.

우리는 여기서 잠정적으로 `a`의 최솟값을 `1 ~ X`로 결론 지을 수 있다.

만약 X = 1, Y = 0인 경우를 생각해보자. 이 때 지금 Z = 0인데, 여기에 더할 수 있는 최소 자연수인 1을 더하면 X = 2, Y = 1로 Z = 50이 된다.

그런데 X = 1이기 때문에 우리는 넣을 수 있는 수 `a`의 최대 범위를 X까지라고 잠정 결론 지을 수 있다.

1 이상 X 이하의 구간에서 Z값이 변하지 않는다면, X를 초과하는 범위에서도 Z값이 변하지 않는다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python | 31256 KB | 40 ms         | O(logX)    | O(1)       | 15분      | 1         | :white_large_square: |
| Java   |          |               |            |            |           |           |                      |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

