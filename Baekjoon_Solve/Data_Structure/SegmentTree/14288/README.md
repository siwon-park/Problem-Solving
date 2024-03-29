## [플3] 회사 문화 4 (14288번)

https://www.acmicpc.net/problem/14288

### 문제 유형

자료 구조, 트리, 세그먼트 트리, 느리게 갱신되는 세그먼트 트리, 깊이 우선 탐색

<br>

### 어려웠던 점 / 문제의 핵심

`회사 문화 2 (14268번)`과 `회사 문화 3 (14287번)`을 합친 문제

생각보다 구현 아이디어는 간단하다.

2개의 세그먼트 트리를 만든다. 한 세그먼트 트리는 구간의 합을 저장하고 있고, 한 세그먼트 트리에는 구간의 값만 저장하고 있다. 마찬가지로 lazy 배열 또한 2개 만든다.

- lazy 배열도 2개 만드는 이유는 하나의 lazy 배열만 사용하면 값을 잘못 업데이트할 수 있기 때문이다.
  - 정방향 전달에 대한 결과를 역방향 전달에 반영하거나, 그 반대의 케이스가 나올 수 있다.
  - 즉, 현재 칭찬 방향에서 실제로 어떤 노드에 전달된 값이 없는데도 불구하고, 이전 방향에서 전달된 값이 전달되어 잘못된 연산 결과를 도출하게 된다.

쿼리와 칭찬 방향에 따라 다음과 같이 처리하면 된다.

- 1번 쿼리: 업데이트
  - 칭찬 방향이 정방향(상사 → 부하)인 경우
    - 구간의 값을 저장하고 있는 세그먼트 트리를 갱신한다
    - 구간 [i, last[i]]를 업데이트
  - 칭찬 방향이 역방향(부하 → 상사)인 경우
    - 구간의 합을 저장하고 있는 세그먼트 트리를 갱신한다
    - 구간[i, i]를 업데이트
- 2번 쿼리: 구간의 값, 합 계산
  - 1번 세그먼트 트리에서 구간 [i, last[i]]의 합을 반환한다.
  - 2번 세그먼트 트리에서 구간 [i, i]의 값을 반환한다.
  - 두 값을 더한다.
- 3번 쿼리: 칭찬 방향 전환
  - flag 변수를 사용하여 칭찬 방향을 전환하고, 1번 쿼리인 update 쿼리를 날릴 때 사용한다.

함수의 중복 작성을 피하기 위해서 `toggle`변수를 사용하여 1번 세그먼트 트리에 대해 연산할 것인지, 2번 세그먼트 트리에 대해 연산할 것인지를 구별하였다.

또한 `lazy 전달 함수`는 `toggle` 값과 상관 없이 1번 lazy 배열에 값이 있으면 1번 세그먼트 트리의 값을 업데이트하고, 2번 lazy 배열에 값이 있으면 2번 세그먼트 트리의 값을 업데이트하면 된다.

![image](https://github.com/siwon-park/Problem_Solving/assets/93081720/df6af005-a9e5-47d4-b821-2969f0ba4d3e)

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 70764 KB | 780 ms        | O(MlogN)   | O(N * 12)  | 60분      | 3         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

추가 예제

```
# case1 
9 9
-1 1 2 2 1 5 6 6 6
1 5 4
3
1 5 3
2 9
2 7
2 6
2 5
2 1
2 4

# answer1
4
4
4
7
3
0

# case2
9 14
-1 1 2 2 1 5 6 6 6
1 5 4
3
1 5 3
3
1 2 2
3
1 2 4
2 9
2 7
2 6
2 5
2 1
2 4
2 2

# answer2
4
4
4
7
7
2
6
```

