# 점화식(13699번)
##################################################
    # 문제: https://www.acmicpc.net/problem/13699
    # 다이나믹 프로그래밍
    # 이미 주어진 문제에 점화식이 나와있으므로, 해당 점화식에 맞춰 풀면 되는 문제
    # 입력으로 주어지는 n이 0도 있으므로, dp[1]=1이라고 설정하면 100%에서 인덱스 에러가 발생함
##################################################
import sys
input=sys.stdin.readline
n=int(input())
dp=[0]*(n+1)
dp[0]=1
for i in range(1,n+1):
    if i%2:
        for j in range(i//2+1):
            dp[i]+=2*dp[j]*dp[i-j-1]
        dp[i]-=dp[i//2]*dp[i//2]
    else:
        for j in range(i//2):
            dp[i]+=2*dp[j]*dp[i-j-1]
print(dp[n])
