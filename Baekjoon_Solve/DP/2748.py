# 피보나치 수2(2748번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/2748
    # 다이나믹 프로그래밍
    # 피보나치 수열을 출력하는 문제이다. 메모이제이션으로 해결하였음
########################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

memo = [0] * 91
memo[1] = 1

def dfs(k):
    if k == 0 or k == 1:
        return memo[k]
    if memo[k]:
        return memo[k]
    memo[k] = dfs(k - 1) + dfs(k - 2)
    return memo[k]

dfs(90)

print(memo[int(input())])
