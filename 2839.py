#설탕 배달(2839번)
########################################################
    # 문제: https://www.acmicpc.net/problem/2839
    # 다이나믹 프로그래밍
    # dp=[-1]*(N+1)이 아니고 N의 최댓값인 5000을 반영하여, dp=[-1]*5001로 선언. 그래야 input이 4로 들어와도 인덱스 에러가 안 남
    # 3kg, 5kg로 설탕 Xkg 만드는 최소 갯수를 구해야함
    # (n-3)kg을 만들 수 있으면 거기에 1개를 더 해 nkg도 만들 수 있다. 마찬가지로 (n-5)kg을 만들 수 있으면 1개를 더해서 nkg을 만들 수 있다.(dp[n]=dp[n-3]+1, /// dp[n]=dp[n-5]+1))
    # 그리고 5와 3의 배수인 숫자를 만들 때 필요한 최소 갯수는 일단 (n-3)kg와 (n-5)kg를 만들 수 있어야하고,
    # (n-3)kg를 만들 수 있는 경우+1, (n-5)kg을 만들 수 있는 경우+1, (n-3)kg와 (n-5)kg을 만드는 경우의 수 합, 이 3가지를 비교해서 가장 작은 값이다. 
########################################################
import sys
input=sys.stdin.readline
N=int(input())
dp=[-1]*5001
dp[3]=1
dp[5]=1
for i in range(5,N+1):
    if dp[i-3]!=-1:
        dp[i]=dp[i-3]+1
    if dp[i-5]!=-1:
        dp[i]=dp[i-5]+1
    if dp[i-3]!=-1 and dp[i-5]!=-1:
        dp[i]=min(dp[i-3]+1,dp[i-5]+1,dp[i-3]+dp[i-5])
print(dp[N])
