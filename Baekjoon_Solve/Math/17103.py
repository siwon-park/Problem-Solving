# 골드바흐 파티션(17103번)
"""
    문제: https://www.acmicpc.net/problem/17103
    소수, 에라토스테네스의 체
    에라토스테네스의 체를 통해 소수인지 체크하고, 소수인 숫자만 따로 리스트에 담는다.
    그 다음 N에 대해 소수 i에 대해 N - i가 소수인지 체크하여 경우의 수를 증가시키면 된다.
"""
import sys
input = sys.stdin.readline

is_prime = [True] * 1000001
is_prime[1] = False
prime_lst = []
for i in range(2, 1000001):
    if is_prime[i]:
        j = 2
        while i * j <= 1000000:
            is_prime[i * j] = False
            j += 1
        prime_lst.append(i)

T = int(input())
for _ in range(T):
    N = int(input())
    cnt = 0
    for i in prime_lst:
        if i > N // 2:
            break
        if is_prime[N - i]:
            cnt += 1
    print(cnt)
