## [골3] 소문난 칠공주 (1941번)

https://www.acmicpc.net/problem/1941

### 문제 유형

그래프 이론, 그래프 탐색, 브루트포스, 너비 우선 탐색, 깊이 우선 탐색, 백트랙킹

<br>

### 어려웠던 점 / 문제의 핵심

비트 마스킹을 사용하여 dfs를 bfs처럼 사용하면 최적화된 시간으로 중복 없이 문제를 해결할 수 있다.

```java
for (int i = 0; i < 25; i++) { // 현재 연결 컴포넌트 상의 어떤 위치를 찾음
    if ((bit & (1 << i)) == 0) continue;
    int r = i / 5;
    int c = i % 5;
    for (int k = 0; k < 4; k++) {
        int nr = r + dr[k];
        int nc = c + dc[k];
        int newBit = bit | (1 << (nr * 5 + nc));
        if (nr < 0 || nr > 4 || nc < 0 || nc > 4 || visited[newBit]) continue;
        visited[newBit] = true;
        if (graph[nr].charAt(nc) == 'S') dfs(cnt + 1, sCnt + 1, newBit);
        else dfs(cnt + 1, sCnt, newBit);
    }
}
```

25개의 비트 중 현재 비트와 일치한다면, 현재 연결 컴포넌트 상의 특정 위치이기 때문에

해당 위치에서 dfs 탐색을 하면, 결국에는 현재의 연결 컴포넌트만 기준으로 bfs탐색처럼 하게 된다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python | 32516 KB | 2504 ms       | O(N^2)     | O(N)       | ?         | 1         | :white_large_square: |
| Java   | 47660 KB | 144 ms        | O(N)       | O(N)       | 40분      | 1         | :white_check_mark:   |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

