# 5 (3165번)
import sys
input = sys.stdin.readline

N, K = map(int, input().rstrip().split())
ans = sys.maxsize


def check(m: int) -> int:
    f_cnt = 0
    num = m
    while num > 0:
        if num % 10 == 5:
            f_cnt += 1
        num //= 10
    return f_cnt


def backtrack(n: int, k: int, flag: bool):
    global ans, N, K
    cnt = check(n)
    if cnt >= K:
        if n > N:
            ans = min(ans, n)
    if k > K:
        return
    r = n % (10 ** (k + 1))
    q = r // (10 ** k)  # 현재 자리수
    if q < 5:  # 현재 자리 수가 5보다 작으면 5로 만듦
        backtrack(n + (5 - q) * (10 ** k), k + 1, True)
    elif q > 5 and flag:  # 현재 자리 수가 5보다 크면 자리수를 1증가시키고 0으로 만듦
        backtrack(n + 10 ** (k + 1) - (q * (10 ** k)), k, False)
    elif q == 5:  # 현재 자리 수가 5면 다음 자리수를 확인
        backtrack(n, k + 1, True)


backtrack(N + 1, 0, True)

print(ans)