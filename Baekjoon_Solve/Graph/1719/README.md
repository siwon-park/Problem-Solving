## [골3] 택배 (1719번)

https://www.acmicpc.net/problem/1719

### 문제 유형

그래프 이론, 다익스트라, 플로이드-워셜

<br>

### 어려웠던 점 / 문제의 핵심

문제를 제대로 읽지 않았음 => 최단 거리 비용을 구하는 문제인 줄 알았으나

`최단 거리 비용으로 가기 위해 가장 처음으로 방문해야 하는 노드`를 출력해야하는 문제

플로이드-워셜로 문제를 풀었는데, 플로이드-워셜에서 경로 역추적을 하는 방법을 어떻게 하는지 생각이 안 났다.

핵심은 `path[a][b] = k`, a에서 b로 가는데 k를 경유한다.

이를 풀면 `a -> k -> b`이므로 경로 역추적을 위해서는 `a -> ... -> k1 -> k -> b`가 이루어져야 하므로

`a -> k1 -> k`가 되기 위해서는 `path[a][k] = k1`가 되어야 한다.  즉,  `path[a][b] != 0`인 동안 b에 k를 넣어야 한다.

#### java

```java
int findPath(int s, int e) {
    while(path[s][e] != 0) {
        int k = path[s][e];
        e = k;
    }
    return e;
}

// System.out.println(findPaht(s, e));
```

#### python

```python
def find_path(s,e):
    if path[s][e]==0:
        return []
    w=path[s][e]
    return find_path(s,w)+[w]+find_path(w,e)

# print(find_path[0])
```

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |          |               |            |            |           |           |                    |
| Java   | 23156 KB | 432 ms        | O(N^3)     | O(N^2)     | 37분      | 1         | :white_check_mark: |
| Kotlin |          |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```

