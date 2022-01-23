# 불!(4179번)
####################################################
    # 문제: https://www.acmicpc.net/problem/4179
    # BFS
    # 그렇게 어려운 문제는 아니지만, 몇 가지를 고려해야할 부분이 있던 문제였다.
    # 1) 불은 1개가 아니다. 여러 개일 수도 있다.
    # 2) 불이 존재하더라도 사방이 벽으로 막히거나 범위 밖이라 불이 못 퍼질 수도 있다.
    # 풀이) 먼저 불이 해당 칸으로 퍼지는 시간 값을 담은 배열을 BFS로 구한다.(spread()함수 이용)
    # 그다음 지훈이를 BFS로 출발시킨다. 단, 지훈이가 해당 칸으로 움직일 수 있는 조건은 board[i][j]=="."이면서, 아직 방문하지 않은 곳이며(not visited[i][j])
    # 지훈이의 시간+1보다 작은 곳이어야 한다.(cnt+1<fire_table[i][j])
    # 계속 탐색하면서 현재 좌표에서 상하좌우 이동했을 때, 범위 밖이면 cnt+1을 반환하면 정답이다. 그러한 조건에 해당하지 않고 큐가 비어버리면 탈출이 불가능하므로 "IMPOSSIBLE"을 반환한다.
    # 불이 퍼진 시간과 지훈이의 시간 차이가 1보다 커야하는 이유는, 두 값의 차이가 1 이하이면
    # 지훈이가 일단 먼저 해당 칸으로 이동하고 나서 불이 해당 칸으로 +1 시간 뒤에 퍼져서 지훈이는 불에 타버린다.
    # 예를 들어) 케이스가 아래와 같다고 할 때, (1,1)에 있는 J가 (0,1), (1,0), (1,2), (2,1)로 이동한다고 치면, +1 시간 뒤에 불이 해당 칸으로 번지게 되므로 탈출이 불가능하다.
    # F.F    0 1 0
    # .J.    1 J 1     => "IMPOSSIBLE"
    # F.F    0 1 0
####################################################
import sys
from collections import deque
input=sys.stdin.readline
R,C=map(int,input().split())
board=[]
INF=sys.maxsize
fq=deque()
fire_table=[[INF]*C for i in range(R)]
for i in range(R):
    board.append(list(input().rstrip()))
    for j in range(C):
        if board[i][j]=="J":
            jy,jx=i,j
            board[i][j]="."
        elif board[i][j]=="F":
            fq.append((i,j))
            fire_table[i][j]=0
            board[i][j]="."
dydx=[(-1,0),(0,1),(1,0),(0,-1)]

def spread():
    while fq:
        y,x=fq.popleft()
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<R and 0<=nx<C:
                if board[ny][nx]==".":
                    if fire_table[y][x]+1<fire_table[ny][nx]:
                        fire_table[ny][nx]=fire_table[y][x]+1
                        fq.append((ny,nx))

def bfs():
    q=deque([(0,jy,jx)])
    visited=[[False]*C for i in range(R)]
    visited[jy][jx]=True
    while q:
        cnt,y,x=q.popleft()
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<R and 0<=nx<C:
                if board[ny][nx]==".":
                    if cnt+1<fire_table[ny][nx]:
                        if not visited[ny][nx]:
                            q.append((cnt+1,ny,nx))
                            visited[ny][nx]=True
            else:
                return cnt+1
    return "IMPOSSIBLE"
    
spread()
print(bfs())
