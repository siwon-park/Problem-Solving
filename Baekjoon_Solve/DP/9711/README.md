## [실3] 피보나치 (9711번)

https://www.acmicpc.net/problem/9711

### 문제 유형

수학, DP

<br>

### 어려웠던 점 / 문제의 핵심

파이썬의 경우 숫자 범위에 제약이 없어서 쉽게 풀 수 있지만, 자바의 경우에는 다른 방식으로 풀어야 할 것 같다.

1만 번째 피보나치 수는 Long형도 가볍게 넘기기 때문에 수학적으로 접근해야 한다.

- 다른 언어로 푼 풀이를 보니까 행렬과 행렬 곱셈을 활용하여 구하고 있었다.

```java
private static long getFibo(long n) {
    if (n == 0 && R == 1) return 0;
    long[][] base = { { 1, 0 }, { 0, 1 } };
    long[][] fibo = { { 1, 1 }, { 1, 0 } };
    while (n > 0) {
        if (n % 2 == 1)
            base = getPow(base, fibo);
        fibo = getPow(fibo, fibo);
        n /= 2;
    }
    return base[0][0];
}

private static long[][] getPow(long[][] a, long[][] b) {
    long[][] arr = new long[2][2];
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                arr[i][j] += (a[i][k] * b[k][j]) % R;
                arr[i][j] %= R;
            }
        }
    }
    return arr;
}
```



<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python | 35052 KB | 96 ms         | O(NT)      | O(N)       | 25분      | 1         | :white_large_square: |
| Java   |          |               |            |            |           |           |                      |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

