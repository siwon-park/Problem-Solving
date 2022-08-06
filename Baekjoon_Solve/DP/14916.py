#거스름돈(14916번)
##################################################
    # 문제: https://www.acmicpc.net/problem/14916
    # DP(다이나믹 프로그래밍)
    # i-5원을 만들 수 있으면 i원도 만들 수 있고, i-2원을 만들 수 있으면 i원도 만들 수 있음
    # i-5과 i-2원도 만들 수 있으면 둘 중 더 작은 값으로 쓰는 값에서 1을 더하면 i원을 만들 수 있음
##################################################
import sys
input=sys.stdin.readline
n=int(input())
dp=[-1]*100001
dp[2],dp[4],dp[5]=1,2,1
for i in range(6,n+1):
    if dp[i-5]!=-1:
        dp[i]=dp[i-5]+1
    if dp[i-2]!=-1:
        dp[i]=dp[i-2]+1
    if dp[i-5]!=-1 and dp[i-2]!=-1:
        dp[i]=min(dp[i-5],dp[i-2])+1
print(dp[n])
