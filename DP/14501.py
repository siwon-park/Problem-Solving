#퇴사(14501번)
#########################################
    # 문제: https://www.acmicpc.net/problem/14501
    # 다이나믹 프로그래밍
    # 역시 다이나믹 프로그래밍은 아직 익숙하지 못한 듯하다....
    # dp[i]를 i까지 얻을 수 있는 최대 이익이라고 가정한 것은 똑같았는데, 나는 문제를 푸는데 좀 많이 헤멨다.
    # 왜냐하면 i를 1부터 출발하여 N까지 순행으로 하려다보니, 고려해야하는 부분이 많이 생겨 헷갈리기 시작했고 원하는 대로 답도 안 나왔다.
    # 다른 사람의 힌트를 참고해보니 역순으로 진행하니 오히려 간단했다.
#########################################
import sys
input=sys.stdin.readline
N=int(input())
dp=[0]*(N+1)
T,P=[],[]
for i in range(N):
    t,p=map(int,input().split())
    T.append(t)
    P.append(p)
max_profit=0    
for i in range(N-1,-1,-1):
    if i+T[i]<=N:
        dp[i]=max(dp[i+T[i]]+P[i], max_profit)
        max_profit=dp[i]
    else:
        dp[i]=max_profit
print(max_profit)  
