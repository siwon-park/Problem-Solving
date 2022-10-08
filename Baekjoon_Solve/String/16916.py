# 부분 문자열(16916번)
#############################################################################
    # 문제: https://www.acmicpc.net/problem/16916
    # 문자열
    # kmp인줄 알았는데, 풀고나서 보니 브론즈 문제였고 2줄로도 해결되는 문제였다.
    # if P in S로 그냥 바로 해결되는 걸 어렵게 kmp로 풀고 있었다... ㅠㅠ
#############################################################################
import sys
input = sys.stdin.readline

S = input().rstrip()
P = input().rstrip()
N, M = len(S), len(P)

def find_fail(p):
    fail = [0] * M
    j = 0

    for i in range(1, M):
        while j > 0 and p[i] != p[j]:
            j = fail[j - 1]
        if p[i] == p[j]:
            j += 1
            fail[i] = j

    return fail

def kmp(t, p):
    fail = find_fail(p)
    j = 0
    ret = []

    for i in range(N):
        while j > 0 and t[i] != p[j]:
            j = fail[j - 1]
        if t[i] == p[j]:
            if j == M - 1:
                ret.append(i - M - 1)
                j = fail[j]
            else:
                j += 1

    return ret

print(1 if kmp(S, P) else 0)
