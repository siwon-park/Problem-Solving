# 무한 문자열 (12871번)
###############################################################################
    # 문제: https://www.acmicpc.net/problem/12871
    # 문자열, 구현
    # 최소 공배수를 이용하면 쉽게 풀 수 있다. 두 문자열의 길이를 각각을 붙여나가면서 최소 공배수만큼 늘려준다.
    # 최종적으로 두 문자열의 길이는 최소 공배수이고, 비교했을 때 같으면 1을, 아니면 0을 반환하면 된다.
###############################################################################
import sys, math
input = sys.stdin.readline

s = input().rstrip()
t = input().rstrip()


def check(S, T):
    N = len(S)
    M = len(T)
    gcd = math.gcd(N, M)
    lcm = N * M * gcd
    n = (lcm - N) // N
    m = (lcm - M) // M

    inf_s = S + S * n
    inf_t = T + T * m
    if inf_s == inf_t:
        return 1
    return 0

print(check(s, t))
