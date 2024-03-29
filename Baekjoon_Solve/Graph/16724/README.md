## [골3] 피리 부는 사나이 (16724번)

https://www.acmicpc.net/problem/16724

### 문제 유형

자료 구조, 그래프 이론, 그래프 탐색, DFS, 분리 집합

<br>

### 어려웠던 점 / 문제의 핵심

깊이 우선 탐색을 통해서 풀거나 union-find를 통해서도 풀 수 있다.

찾고자 하는 것은 안전 영역의 개수인데, 이는 결국 연결 컴포넌트의 개수(집합의 개수)와 같다.

아래 그림과 같이 음영 처리된 곳은 어디든 각 그룹의 안전 영역이 될 수 있다.

![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/329cc810-e32d-4878-aa16-d0d51e98ea59)

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python | 76216 KB | 860 ms        | O(4*MN)    | O(MN)      | 40분      | 1         | :white_check_mark:   |
| Java   | 67732 KB | 584 ms        | O(MNlogMN) | O(MN)      | 25분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

