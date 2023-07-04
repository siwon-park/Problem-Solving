## [플4] LRH 식물 (2934번)

https://www.acmicpc.net/problem/2934

### 문제 유형

자료 구조, 세그먼트 트리, 느리게 갱신되는 세그먼트 트리

<br>

### 어려웠던 점 / 문제의 핵심

꽃이 피기 위해선 어떤 식물의 줄기와 다른 식물의 줄기가 아닌 곳에서 만나는 접점이어야 한다.

따라서 식물을 심을 때, 구간 `[L + 1, R - 1]`에만 `1`씩 업데이트 하고

구간 `[L, L]`의 값과 구간 `[R, R]`의 값의 합을 출력하면 꽃의 개수를 알 수 있다.

(아래 그림에서 진하게 색칠된 곳이 실제로 업데이트 되는 구간이고, 반투명하게 색칠된 곳이 해당 지점의 개수를 구하는 것이다.)

그러나 매일 새롭게 피는 꽃의 개수를 구해야 하기 때문에 미리 이전에 구간 `[L, L]`과 구간 `[R, R]`에 피어있는 꽃의 합을 저장해뒀다가, 현재 구한 꽃의 합에서 저장한 값을 빼주면 된다.

![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/6c697191-9d64-4861-9ad4-1a39bd69e425)

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 46416 KB | 692 ms        | O(NlogM)   | O(N * 4)   | 75분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```
