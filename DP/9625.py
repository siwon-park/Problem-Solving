# BABBA(9625번)
###################################################
    # 문제: https://www.acmicpc.net/problem/9625
    # DP(다이나믹 프로그래밍)
    # 버튼을 눌렀을 때, 모든 A는 B로, B는 BA로 바뀌므로, 다음 A의 갯수는 현재 B의 갯수와 같고, 다음 B의 갯수는 현재 A의 갯수와 B의 갯수의 합이다.
    # 따라서 점화식은 dp[i]=[dp[i-1][1], dp[i-1][0]+dp[i-1][1]]이다.
###################################################
import sys
input=sys.stdin.readline
K=int(input())
dp=[[0,0] for i in range(K+1)]
dp[0],dp[1]=[1,0],[0,1]
for i in range(2,K+1):
    dp[i]=[dp[i-1][1], dp[i-1][0]+dp[i-1][1]]
print(*dp[K])
