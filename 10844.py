#쉬운 계단 수(10844번)
##############################################
    # 문제: https://www.acmicpc.net/problem/10844
    # 다이나믹 프로그래밍
    # 계단 수는 서로 인접한 수들 끼리 차이가 1씩 나는 수이므로, 끝이 무슨 숫자로 끝났냐에 따라 개수가 갈림
    # 예를 들어 끝이 0으로 끝났다 → 그 다음에 올 수 있는 숫자는 1밖에 없다.(끝이 9로 끝났을 경우에는 역시 8밖에 없음)
    # 만약 1~8사이의 숫자로 끝났으면, 두 갈래로 가지치기가 된다. 그런데 그렇다고 해서 무조건 *2하는 것은 아니다.
    # 즉, 예를 들어 3으로 끝나는 3자리 계단 수를 만들려면 2자리 계단 수 중 4로 끝난 경우의 수와 2로 끝난 경우의 수를 더 해야한다. (dp[3][3]=dp[2][2]+dp[2][4])
    # dp[n][k]에는 n자리 계단 수 중 끝이 k로 끝난 경우의 수를 담는다. 그리고 마지막 dp[n][10]에는 우리가 원하는 n자리 계단 수의 총 개수를 담는다.
##############################################
import sys
input=sys.stdin.readline
dp=[[0]*11 for i in range(101)]
dp[1]=[0,1,1,1,1,1,1,1,1,1,9]
dp[2]=[1,1,2,2,2,2,2,2,2,1,17]
for i in range(3,101):
    for j in range(1,9):
        dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1]
    dp[i][0]=dp[i-1][1]
    dp[i][9]=dp[i-1][8]        
    dp[i][10]=sum(dp[i][:10])%1000000000
print(dp[int(input())][10])  