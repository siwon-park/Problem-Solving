## [골4] 적의 적 (12893번)

[https://www.acmicpc.net/problem/12893]()

### 문제 유형

그래프 이론, 그래프 탐색, 자료 구조, 분리 집합, 이분 그래프

<br>

### 어려웠던 점 / 문제의 핵심

![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/1ff1b95b-62c0-4120-a907-5759056eefca)

주어진 적대 관계를 그래프 연결 관계로 만든 다음에 적대 관계의 적대 관계에 있는 사람들은 우호 관계이기 때문에 `union`으로 우호 관계로 만들어 준다.

그 후 입력으로 주어진 적대 관계를 다시 순회하여 적대 관계인데, 우호 관계 그룹에 속해 있으면 break하고 0을 출력하면 된다.

서로 적대인 관계를 연결하기 위해 graph를 사용하였고 입력으로 주어지는 그대로 한쪽 방향으로만 적대 관계를 연결해도 되는 것이, 어차피 나중에 union하게 되면 양방향으로 성립되기 때문에 상관이 없다.

따라서 적대 관계의 수 M이 100만이기 때문에 N의 최댓값 2000을 고려하더라도 `O(N ^ 3)`보다는 작은 시간 복잡도를 가지게 된다. 

```java
// 적대 관계의 적대 관계에 있는 사람들을 우호 관계로 묶어 줌
for (int i = 1; i < N + 1; i++) {
    HashSet<Integer> enemies = rel.get(i);
    if (rel.isEmpty()) continue;
    for (Integer e : enemies) {
        HashSet<Integer> friends = rel.get(e);
        for (Integer f : friends) union(i, f); // i와 f를 우호 관계로 병합
    }
}
```

#### 보다 효율적인 풀이법

적 테이블을 선언하고 적의 적을 우호 관계로 union하고, 적 테이블을 갱신한다

```java
parent = new int[n + 1];
enemy = new int[n + 1]; // 적 테이블
for (int i = 1; i <= n; i++) parent[i] = i;

while (m-- > 0) {
    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken()),
        b = Integer.parseInt(st.nextToken());

    if (find(a) == find(b)) chk = false;

    union(enemy[a], b); // a의 적과 b를 우호 관계로 union
    union(enemy[b], a); // b의 적과 a를 우호 관계로 union
    enemy[a] = b; // a의 적과 b를 우호 관계로 연결했으니, a의 적은 b가 됨
    enemy[b] = a; // b의 적과 a를 우호 관계로 연결했으니, b의 적은 a가 됨
}
```

<br>

### 언어별 풀이 요약

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도       | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | --------- | ------------- | ---------------- | ---------- | --------- | --------- | -------------------- |
| Python |           |               |                  |            |           |           |                      |
| Java   | 378520 KB | 1072 ms       | O(N ^ 2 + MlogN) | O(N ^ 2)   | 45분      | 2         | :white_large_square: |
| Kotlin |           |               |                  |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

