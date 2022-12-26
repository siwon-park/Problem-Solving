# 가장 긴 증가하는 부분 수열 (14002번)
"""
    문제: https://www.acmicpc.net/problem/14002
    DP
    가장 긴 증가하는 부분 수열의 길이와 그 때의 부분 수열을 찾아야한다.
    부분 수열의 길이를 구하는 부분은 쉬운데, 부분 수열을 찾는 방법을 잘 몰라서 헤맸다.
    단순히 최대 길이를 갱신해 줄 때만 부분 수열을 갱신한다면
    주어지는 수열이 1 5 6 2 3 4 7과 같이 증가하다가 감소 후 계속해서 더 증가한다면
    정확한 부분 수열을 갱신하지 못하게 된다.
    따라서 부분 수열의 길이를 갱신했을 때의 위치를 따로 방문 배열에 기록한 다음
    최장 부분 수열의 길이일 때의 인덱스부터 시작해서 방문 배열을 재귀적으로 탐색하거나 while 구문으로 특정 조건을 만족할 떄까지 탐색하여
    올바른 가장 긴 부분 수열을 구하면 된다.
    부분 수열을 구하는 로직이 BFS문제나 다익스트라 문제에서 최단 거리 경로를 찾는 것과 다르지 않았다.
    알고 있던 개념이지만 아이디어가 떠오르지 않았다. 개념을 완벽히 이해하지 못해서 사용할 줄 몰랐던 것 같다.
"""
import sys
input = sys.stdin.readline


N = int(input().rstrip())
A = list(map(int, input().split()))

dp = [0] * N
ans = 0
route = [-1] * N
max_idx = 0
for i in range(N):
    dp[i] = 1
    for j in range(i):
        if A[i] > A[j]:
            if dp[i] < dp[j] + 1:
                dp[i] = dp[j] + 1
                route[i] = j
    if ans < dp[i]:
        ans = dp[i]
        max_idx = i

ret = [A[max_idx]]
while route[max_idx] != -1:
    max_idx = route[max_idx]
    ret.append(A[max_idx])

print(ans)
print(*ret[::-1])
