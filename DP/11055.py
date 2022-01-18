# 가장 큰 증가 부분 수열(11055번)
#################################################
    # 문제: https://www.acmicpc.net/problem/11055
    # 다이나믹 프로그래밍
    # 가장 긴 증가하는 부분 수열(LCS)을 구하는 코드에서 길이가 아니라 요소의 합을 대상으로 기록해주면 됨
#################################################
import sys
input=sys.stdin.readline
N=int(input())
arr=list(map(int,input().split()))
dp=[0]*N
answer=arr[0]
for i in range(N):
    dp[i]=arr[i]
    for j in range(i):
        if arr[i]>arr[j]:
            dp[i]=max(dp[j]+arr[i],dp[i])
    answer=max(dp[i],answer)
print(answer)
