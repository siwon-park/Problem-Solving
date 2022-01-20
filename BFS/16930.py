# 달리기(16930번)
######################################################
    # 문제: https://www.acmicpc.net/problem/16930
    # BFS
    # 논리상으로는 어려운 문제가 아닌데, 시간초과 때문에 난이도가 있는 것으로 판별되는듯한 문제였음
    # 나 역시 97%에서 계속 시간초과가 났었음(break 구문을 2개나 넣었음에도 불구하고 시간초과 판정)
    # q에 삽입하는 조건을 바꾸니까 가까스로 턱걸이로 통과할 수 있었다.
    # 단순히 not visited일 때만 q에 삽입하는 것이 아니라, 특정 조건일 경우 break하고 그게 아닐 경우에 삽입하는 방법으로 바꾸니까 통과하였음
######################################################
import sys
from collections import deque
input=sys.stdin.readline
N,M,K=map(int,input().split())
board=[]
for i in range(N):
    board.append(list(input().rstrip()))
y1,x1,y2,x2=map(lambda x: int(x)-1,input().split())
visited=[[-1]*M for i in range(N)]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]

def bfs():
    q=deque([(0,y1,x1)])
    visited[y1][x1]=0
    while q:
        cnt,y,x=q.popleft()
        if (y,x)==(y2,x2):
            return cnt
        for dy,dx in dydx:
            for k in range(1,K+1):
                ny,nx=y+dy*k,x+dx*k
                if 0<=ny<N and 0<=nx<M:
                    if board[ny][nx]==".":
                        ############################################# (기존 코드: if not visited[ny][nx]: q.append(~~~)였음)
                        if visited[ny][nx]!=-1 and visited[ny][nx]<=visited[y][x]: # -1이 아니면서(이미 방문했으면서), 이동하고자 하는 칸에 기록된 값이 현재 칸보다 작거나 같으면 
                            break                                                  # 더 이상 진행할 필요 없으니 break(왜냐면 그 이후의 칸의 값도 현재 칸보다 작거나 같기 때문)
                        if visited[ny][nx]!=-1: # 이미 방문했다면 큐에 삽입할 필요가 없으니 무시
                            continue
                        #############################################
                        q.append((cnt+1,ny,nx))
                        visited[ny][nx]=visited[y][x]+1
                    else:
                        break
                else:
                    break    
    return -1

print(bfs())  
