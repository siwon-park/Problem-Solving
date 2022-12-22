# 개업 (13910번)
"""
    문제: https://www.acmicpc.net/problem/13910
    DP
    도저히 못 풀겠어서 다른 사람의 풀이를 참조했더니, 내가 또 문제를 제대로 안 읽고 넘어간 부분이 있었다. 어쩐지 생각보다 어렵다 했다.
    "해빈이는 양손잡이여서 동시에 두 개의 웍(중국 냄비)을 사용하여 요리할 수 있다." -> 최대 2개의 웍만 사용 가능하다는 조건을 못봤다.
    즉, 이렇게 될 경우 점화식은 dp[n] = min(dp[n], dp[n - i] + 1)이 된다.
    풀이법은, 일단 주어진 M개의 웍에 대해 1 ~ 2개의 조합으로 가능한 수에 대해 dp[m] = 1로 기록한다.
    동시에, 가능한 조합을 저장한다.
    1부터 N + 1까지 for 반복 구문을 돌면서 가능한 조합에 대해서 dp[n] = min(dp[n], dp[n - i] + 1)의 점화식을 적용한다.
    이때, n - i >= 0이면서 INF 값이 아니어야 한다.
"""
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
W = list(map(int, input().split()))
INF = int(1e9)
dp = [INF] * (N + 1)
dp[0] = 0
comb = set()
for i in range(M):
    dp[W[i]] = 1
    comb.add(W[i])
    for j in range(i + 1, M):
        if W[i] + W[j] <= N:
            dp[W[i] + W[j]] = 1
            comb.add(W[i] + W[j])

for i in range(1, N + 1):
    for w in comb:
        if w > i:
            continue
        if dp[i - w] != INF:
            dp[i] = min(dp[i], dp[i - w] + 1)

print(-1 if dp[N] >= INF else dp[N])
