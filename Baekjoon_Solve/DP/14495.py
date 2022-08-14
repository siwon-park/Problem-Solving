# 피보나치 비스무리한 수열(14495번)
###############################################################################
    # 문제: https://www.acmicpc.net/problem/14495
    # 다이나믹 프로그래밍
    # 메모이제이션으로 풀어봤다.
    # 처음에 풀었을 때, 답이 예제처럼 안 나와서 살짝 당황했는데, fn = fn-1 + fn-3이었다.
    # 게다가 memo[k] = dfs(k - 1) + dfs(k - 3)으로 함수를 호출해줘야하는데, memo를 더 하고 있어서 답이 나오지 않았더 것이다.
###############################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

memo = [0] * 117

memo[1], memo[2], memo[3] = 1, 1, 1

def dfs(k):
    if memo[k]:
        return memo[k]
    memo[k] = dfs(k - 1) + dfs(k - 3)
    return memo[k]

dfs(116)

print(memo[int(input())])
