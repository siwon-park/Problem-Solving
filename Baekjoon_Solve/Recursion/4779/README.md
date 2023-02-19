## [실3] 칸토어 집합 (4779번)

https://www.acmicpc.net/problem/4779

### 문제 유형

분할 정복, 재귀

<br>

### 어려웠던 점 / 문제의 핵심

문자열을 삼등분하여 문자열의 길이가 1이 될 때까지 분할정복을 계속하는 것이 문제의 핵심이다.

이 때 재귀 함수의 반환 값을 String으로 하니 메모리 초과 판정을 받았다.

미리 크기가 3^N인 char형의 배열을 선언하고 배열의 모든 값을 '-'로 초기화 한 뒤에 가운데 공백만 처리해줬더니 통과할 수 있었다.

메모리 초과가 난 이유는 다음과 같다.

함수의 리턴값으로 문자열을 반환하면 새로운 값을 생성하는 것과 같다. 즉, `new String()`으로 새롭게 생성한 것이다. String은 Reference-Type(참조형)으로 stack 공간에 주소값이, heap 공간에 실제 값이 쌓인다.

값이 같더라도 매번 heap 영역에 새로운 값이 쌓이게 되므로 메모리 초과가 발생할 수 밖에 없다.

하지만 미리 크기가 3^N인 배열을 선언하고 매번 초기화해서 사용하면 해당 배열은 stack 영역에 한 개만 차지하고 있으므로, 메모리 초과가 나지 않는다.

```java
// 메모리 초과 재귀 함수
static String recur(int n) {
    if (n == 1) {
        return "-";
    }
    String ret1 = recur(n / 3);
    String ret2 = concat(" ", n / 3);
    String ret3 = recur(n / 3);
    return ret1 + ret2 + ret3;
}

// 메모리 초과 X 재귀 함수
static void recur(int s, int n) { // s: 시작점, n: 문자열의 길이
    if (n == 1) {
        return;
    }
    int nxtSize = n / 3;
    for (int i=s + nxtSize; i<s + 2 * nxtSize; i++) {
        arr[i] = ' ';
    }
    recur(s, nxtSize);
    recur(s + 2 * nxtSize, nxtSize);
}
```

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고          |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | ------------------ |
| Python |          |               |            |            |           |           |                    |
| Java   | 18636 KB | 292 ms        | O(3^N)     | O(3^N)     | 30분      | 2         | :white_check_mark: |
| Kotlin |          |               |            |            |           |           |                    |

<br>

### 예외(테스트) 케이스

```
```

