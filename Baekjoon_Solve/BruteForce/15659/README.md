## [골3] 연산자 끼워넣기(3) (15659번)

https://www.acmicpc.net/problem/15659

### 문제 유형

자료 구조, 브루트포스, 백트랙킹, 스택

<br>

### 어려웠던 점 / 문제의 핵심

#### java

풀이가 효율적인 풀이는 아니지만, 문제를 푸는 핵심 로직은 다음과 같다.

백트랙킹과 스택으로 풀었다.

스택1에는 숫자를, 스택2에는 연산자를 넣는다.

현재 연산자가 곱셈이나 나눗셈이면, 스택1의 마지막 숫자를 뽑아서 바로 계산한 다음, 다시 스택1에 넣는다.

그게 아니라면 스택1에 그냥 숫자만 넣고, 스택2에 현재 연산자를 넣는다.

백트랙킹의 종료 조건에 도달하면

스택의 가장 처음에서부터 끝까지 순차적으로 덧셈, 뺄셈에 대해 연산하여 최솟값, 최댓값을 비교한다.

이 풀이가 효율적인 풀이는 아닌 이유가 일단 스택을 2개나 사용하여 메모리를 더 많이 사용했고,

마지막에 stack을 클론하여 사용하면서, 순차적인 계산을 위해 크기가 N인 배열을 하나 더 선언했기 때문에

속도와 공간면에서 모두 비효율적인 풀이이다.

#### 효율적인 풀이

```java
// idx: 인덱스, sum: 현재까지 계산한 값, prev: 이전 값
// 이전 값의 경우 곱셈, 나눗셈이 연속된다면 연산 결과를 계속 누적하고
// 덧셈, 뺄셈이 나오면 이전 값에 기록된 값을 현재까지 계산한 값에 더하고, 이전 값은 현재 값으로 변경한다.
// 뺄셈은 음수 계산을 위해 음수 부호(-)를 붙여준다.
static void backtrack(int idx, int sum, int prev) {
    if (idx == n) {
        max = Math.max(max, sum + prev);
        min = Math.min(min, sum + prev);
        return;
    }

    for (int i = 0; i < 4; i++) {
        if (cals[i] == 0) continue;
        cals[i]--;
        switch(i) {
            case 0: 
                calculation(idx + 1, sum + prev, nums[idx]);
                break;
            case 1:
                calculation(idx + 1, sum + prev, -nums[idx]);
                break;
            case 2:
                calculation(idx + 1, sum, prev * nums[idx]);
                break;
            case 3:
                calculation(idx + 1, sum, prev / nums[idx]);
                break;
        }
        cals[i]++;
    }
}

backtrack(1, 0, nums[0]); // 인덱스 1번부터 출발, 현재 계산한 값: 0, 이전 값: 인덱스 0번의 값
```

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python |          |               |            |            |           |           |                      |
| Java   | 27500 KB | 240 ms        | O(N!)      | O(N)       | 30분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

