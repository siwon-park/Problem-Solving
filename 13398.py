#연속합(13398번)
#################################################
    # 문제: https://www.acmicpc.net/problem/13398
    # 다이나믹 프로그래밍
    # 왜 맞았는지 모르겠다
    # dp1은 연속합1 문제의 알고리즘 그대로 가져왔고,
    # dp2는 연속 배열 중 하나의 요소를 뺀 값들을 저장하는데, dp2[i]=max(dp2[i-1]+arr[i-1],dp1[i-1],dp1[i]) 이게 왜 통과인지 모르겠다...
#################################################
import sys
input=sys.stdin.readline
n=int(input())
dp1,dp2=[0]*(n+1),[0]*(n+1)
arr=list(map(int,input().split()))
dp1[1],dp2[1]=arr[0],arr[0]
answer=dp1[1]
for i in range(2,n+1):
    dp1[i]=arr[i-1]
    if dp1[i-1]+arr[i-1]>dp1[i]:
        dp1[i]=dp1[i-1]+arr[i-1]
    dp2[i]=max(dp2[i-1]+arr[i-1],dp1[i-1],dp1[i])    
    answer=max(answer,dp2[i])   
print(answer)
