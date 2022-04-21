# 수익(4097번)
#################################################################
    # 문제: https://www.acmicpc.net/problem/4097
    # DP
    # 매우 간단한 DP 문제
    # dp[i]의 값은 현재 값(arr[i])과 누적값(dp[i-1])+현재 값 중 큰 값이다.
#################################################################
import sys
input = sys.stdin.readline

INF = sys.maxsize
while True:
    N = int(input())
    if N == 0:
        break
    arr = [int(input()) for _ in range(N)]
    dp = arr[:]
    for i in range(1, N):
        dp[i] = max(dp[i-1] + arr[i], arr[i])
    print(max(dp))
