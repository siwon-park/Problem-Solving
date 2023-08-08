## [골3] 전설의 JBNU (12757번)

https://www.acmicpc.net/problem/12757

### 문제 유형

자료 구조, 이분 탐색, 해시를 사용한 집합과 맵

<br>

### 어려웠던 점 / 문제의 핵심

TreeMap을 사용하면 어렵지 않게 풀 수 있다.

처음에 TreeMap을 안 쓰고 HashMap을 통해 키를 해싱하고, 따로 ArrayList에 키를 담으려고 했는데, 생각해보니 쿼리가 들어올 때마다 lowerBound, upperBound를 하기 위해 정렬을 해줘야 하고 lowerBound와 upperBound를 직접 구현하는 것 + 로직 구현까지 감안하니 코드가 너무 길어질 것 같아서 TreeMap에 구현되어 있는 메서드를 사용했다.

직접 lowerBound와 upperBound를 구현했을 때와 달리 메서드 호출 시 만족하는 키가 없다면 null을 리턴하기 때문에 이를 처리하기 위한 코드가 추가되었다. (물론 직접 lowerBound와 upperBound를 구현했어도 다른 전처리는 필요하다.)

TreeMap 상에서 lowerBound는 `floorKey`이고, upperBound는 `ceilingKey`이다.

메서드에 인자로 받은 key값을 기준으로 lowerBound, upperBound를 실행시킨 결과를 돌려주는데, 만족하는 key가 없으면 null을 리턴한다.

- 참고) `floorEntry`와 `ceilingEntry`의 경우 동작은 같지만 조건을 만족하는 `key:value`쌍을 가진 TreeMap 객체를 반환한다. 보통 value를 빠르게 찾기 위해서 사용한다. `.getValue()`메서드를 호출하면 바로 value를 가져올 수 있다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리    | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | --------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |           |               |            |            |           |           |                      |
| Java   | 100464 KB | 1048 ms       | O(MlogN)   | O(N+M)     | 35분      | 1         | :white_large_square: |
| Kotlin |           |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

