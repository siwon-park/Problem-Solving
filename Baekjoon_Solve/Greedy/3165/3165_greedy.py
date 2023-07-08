# 5 (3165번)
import sys
input = sys.stdin.readline

N, K = map(int, input().rstrip().split())


def check(m: int) -> int:
    n = m
    five_cnt = 0
    while n > 0:
        if n % 10 == 5:
            five_cnt += 1
        n //= 10
    return five_cnt


M = N + 1
i = 0
while True:
    cnt = check(M)
    if cnt >= K and M > N:
        break
    r = M % (10 ** (i + 1))
    q = r // (10 ** i)
    if q < 5:  # 5보다 작음
        M += (5 - q) * (10 ** i)  # 5로 만듦
        i += 1
    elif q > 5:  # 5보다 큼
        M -= q * (10 ** i)  # 0으로 만들고
        M += 10 ** (i + 1)  # 다음 자리수를 1증가 시킴
    else:
        i += 1

print(M)
