#이동하기(11048번)
###################################################
    # 문제: https://www.acmicpc.net/problem/11048
    # 다이나믹 프로그래밍
    # DP 테이블을 graph크기보다 1칸 더 길게 만들고 dp[i][j]에서 i와 j에 대해 1부터 N까지 for 구문을 돌림
    # 이동을 오른쪽, 아래쪽, 대각 3방향 이동이 가능하므로, 점화식은 dp[i][j]=graph[i-1][j-1]+max(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])이다
###################################################
import sys
input=sys.stdin.readline
N,M=map(int,input().split())
graph=[]
for i in range(N):
    graph.append(list(map(int,input().split())))
dp=[[0]*(M+1) for i in range(N+1)]
for i in range(1,N+1):
    for j in range(1,M+1):
        dp[i][j]=graph[i-1][j-1]+max(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])
print(dp[N][M])   
