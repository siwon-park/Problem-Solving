# 줄세우기(2631번)
#################################################
    # 문제: https://www.acmicpc.net/problem/2631
    # 다이나믹 프로그래밍
    # 가장 긴 증가하는 부분 수열(LIS)의 길이를 구해서 N에서 그 LIS의 길이를 빼주면 됨
#################################################
import sys
input=sys.stdin.readline
N=int(input())
arr=[]
for i in range(N):
    arr.append(int(input().rstrip()))
dp=[0]*N
answer=1
for i in range(N):
    dp[i]=1
    for j in range(i):
        if arr[j]<arr[i]:
            dp[i]=max(dp[j]+1,dp[i])
    answer=max(dp[i],answer)
print(N-answer)
