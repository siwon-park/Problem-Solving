# 이항 계수 2(11051번)
######################################################################
    # 문제: https://www.acmicpc.net/problem/11051
    # 다이나믹 프로그래밍
    # 조합의 재귀적 성질을 이용해서 풀 수 있는 문제이다.
    # DFS 메모이제이션으로 구현해보았다.
    # 그런데 풀고나서 보니까 아주 간단하게 점화식을 구현한 사람들이 있었다.
    # dp[0] = 1
    # for i in range(1, N + 1):
    #   dp[i] = dp[i - 1] * i
    # print(dp[N] // (dp[N - K] * dp[K]) % 10007)
    # 팩토리얼을 활용하여 조합으로 구현하니까 엄청나게 빠르다. 1차원인 것도 한 몫한 것 같다.
######################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def dfs(n, k):
    if k == 1:
        memo[n][k] = n % 10007
        return memo[n][k]
    if k == 0:
        memo[n][k] = 1
        return 1
    if memo[n][k]:
        return memo[n][k]
    left, right = 0, 0
    if n >= k and n - 1 > 0 and k - 1 >= 0:
        left = dfs(n-1, k)
        right = dfs(n-1, k-1)
    memo[n][k] = (left + right) % 10007
    return memo[n][k]

N, K = map(int, input().split())
memo = [[0]*(N+1) for _ in range(N+1)]
dfs(N, K)
print(memo[N][K])
