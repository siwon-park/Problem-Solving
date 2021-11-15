#욕심쟁이 판다(1937번)
#######################################
    # DFS+DP 이용
    # 19번째 줄에 dp[y][x]가 0이 아니면 dp[y][x]를 return하는 것이 포인트였다.
    # 이게 없다면, dp[y][x]에 값이 기록되어 있음에도 불구하고, dfs를 일단 안 될 때까지 계속 돌아야하는 쓸데 없는 반복이 발생한다.
    # dp[y][x]를 y,x에서 출발했을 때 살 수 있는 최대 일수라고 생각해보면 편하다.
    # 어떤 미지의 좌표에서 출발해서 왔는데, 다음 좌표가 y,x라고 해보자, 그런데 y,x에는 이미 그곳에서 출발했을 때부터 살 수 있는 일자가 기록되어 있다.
    # 그럼 현재 y,x에 도착한 상태에서 탐색을 더 진행해야할까? 아니다. 그냥 y,x에 기록된 값을 리턴하여 미지의 좌표에서 살 수 있는 날짜에 +를 해주면 끝이다.
    # 예를 들어, (0,0)에서 dfs를 돌렸더니 (0,0)에서 출발했을 때 최대 살 수 있는 일자가 4였다고 가정해보자.
    # 4 0 0
    # 0 0 0
    # 0 0 0
    # 만약 (1,0)에서 출발했는데, (0,0)에 있는 대나무 값이 (1,0)에 있는 대나무 값보다 크면 그쪽으로 갈 수 있다. 그런데 (0,0)에 도착했을 때, 또 dfs를 돌려야 할 필요가 있을까?
    # 왜냐하면 여기서 탐색해봤자 최대 살 수 있는 일 수는 4일이기 때문에 그냥 4를 반환하고 탐색을 종료하면 된다. 그러면 (1,0)에는 5가 기록된다.
    # 그럼 또 어떤 좌표에서 출발했을 때, (1,0)에 도착했다면 거기에 기록된 5를 그냥 쓰면 되는 것이다.
#######################################
import sys
sys.setrecursionlimit(10000)
input=sys.stdin.readline
n=int(input())
board=[]
for i in range(n):
    board.append(list(map(int,input().split())))
result=[]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
dp=[[0]*n for i in range(n)]
def dfs(y,x):  
    if dp[y][x]==0:
        dp[y][x]=1
    else:
        return dp[y][x]    
    for dy,dx in dydx:
        ny,nx=y+dy,x+dx
        if 0<=ny<n and 0<=nx<n:
            if board[ny][nx]>board[y][x]:
                tmp=1
                tmp+=dfs(ny,nx)
                dp[y][x]=max(dp[y][x],tmp)      
    return dp[y][x]   
max_live=0          
for i in range(n):
    for j in range(n):
        max_live=max(max_live,dfs(i,j))
print(max_live)
