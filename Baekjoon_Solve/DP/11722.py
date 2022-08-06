#가장 긴 감소하는 부분 수열(11722번)
##################################################
    # 문제: https://www.acmicpc.net/problem/11722
    # DP(다이나믹 프로그래밍)
    # 가장 긴 증가하는 부분 수열(11053번)과 동일한 논리의 문제
##################################################
import sys
input=sys.stdin.readline
N=int(input())
A=list(map(int,input().split()))
dp=[0]*1000
answer=1
for i in range(N):
    dp[i]=1
    for j in range(i):
        if A[j]>A[i]:
            dp[i]=max(dp[j]+1,dp[i])
    answer=max(answer,dp[i])
print(answer)
