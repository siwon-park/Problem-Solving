## [골4] 드래곤 앤 던전 (16434번)

[https://www.acmicpc.net/problem/16434]()

### 문제 유형

구현, 이분 탐색

<br>

### 어려웠던 점 / 문제의 핵심

문제에 나와있는 내용을 이분 탐색으로 탐색할 수 있게끔 구현하면 된다.

용사가 현재 공격력으로 몬스터를 공격해서 몬스터의 체력을 0으로 만들려면 `(몬스터의 체력 / 현재 공격력)` 값의 올림한 횟수만큼 공격을 해야하고, 

그 후 용사의 체력은 `(공격 횟수 - 1) * 몬스터의 공격력` 값만큼 감소된다. `올림한 다음 1을 빼주는 이유는 몬스터의 체력 / 현재 공격력이 나누어 떨어지는 경우가 있기 때문`이다.

<br>

### 언어별 풀이 요약

| 언어   | 메모리   | 실행 시간(ms) | 시간복잡도 | 공간복잡도 | 풀이 시간 | 시도 횟수 | 해설 참고            |
| ------ | -------- | ------------- | ---------- | ---------- | --------- | --------- | -------------------- |
| Python | 47188 KB | 4140 ms       | O(NlogM)   | O(N)       | 45분      | 2         | :white_large_square: |
| Java   | 53356 KB | 600 ms        | O(NlogM)   | O(N)       | 40분      | 1         | :white_large_square: |
| Kotlin |          |               |            |            |           |           |                      |

<br>

### 예외(테스트) 케이스

```
```

<br>

매우 빠른 파이썬 풀이

```python
import sys
from math import ceil
input = sys.stdin.readline

def main():
    n, atk = map(int, input().rstrip().split())
    minHp = curHp = 0
    for _ in range(n):
        t,a,h = map(int, input().rstrip().split())
        if t == 1:
            nOfAtk = ceil(h / atk) - 1
            curHp -= a * nOfAtk
        elif t == 2:
            minHp = min(minHp, curHp)
            curHp += h
            if curHp > 0: curHp = 0
            atk += a
    print(min(minHp, curHp) * -1 + 1)
if __name__ == '__main__':
    main()
```

