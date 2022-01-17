# 줄세우기(2631번)
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
