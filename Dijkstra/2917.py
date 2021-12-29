#늑대 사냥꾼(2917번)
#################################################
    # 문제: https://www.acmicpc.net/problem/2917
    # 다익스트라 알고리즘, BFS
    # 최대힙을 이용하는 다익스트라 알고리즘
    # 내가 했던 실수 2가지:
    # 1) 각 칸과 나무와의 최소 거리를 담는 배열인 dist_table 배열을 만들 때, 큐를 활용하지 않고, 단순 무식하게 3중 구문으로 구현함(시간 초과의 원인)
    # 2) 다익스트라 함수 구현에서 3차원의 distance 배열을 선언하고 최대힙으로 해당 칸까지 가는 최대 거리와 해당 칸까지 가는 경로 중 최소 값을 저장했는데,
    # 우선 이렇게 굳이 힘들게 3차원 배열까지 구현할 필요 없이, 최대 힙으로 넣었다면, 다음 넣는 것도 최대힙으로 넣어야해서 우선순위 큐에 삽입 전 음수 변환해야하고,
    # 최솟값을 넣게되면, 뽑은 뒤 그것을 양수전환했을 때 누적되는 값을 생각하면 자연스럽게 최댓값일 수밖에 없음. 따라서 굳이 누적값을 매번 저장하는 식으로 구현할 필요가 없었음
    # (어쨌든 최대힙으로 논리적으로 맞게 구성했다고 생각했는데도 틀렸다고 나와서 간단하게 고치고, 바로 오두막 좌표에 도착하는 순간 return하는 방식으로 했더니 통과함)
#################################################
import sys, heapq
from collections import deque
input=sys.stdin.readline
N,M=map(int,input().split())
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
INF=sys.maxsize
board=[]
trees=deque()
dist_table=[[INF]*M for i in range(N)]     
for i in range(N):
    board.append(list(input().rstrip()))
    for j in range(M):
        if board[i][j]=="V":
            sy,sx=i,j
        elif board[i][j]=="+":
            trees.append((i,j))
            dist_table[i][j]=0
        elif board[i][j]=="J":
            ty,tx=i,j
       
def bfs(q):
    while q:
        y,x=q.popleft()
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<M:
                if board[ny][nx]!="+":
                    if dist_table[y][x]+1<dist_table[ny][nx]:
                        dist_table[ny][nx]=dist_table[y][x]+1
                        q.append((ny,nx))
    return                    
bfs(trees)

def dijkstra(sy,sx):
    min_dist=INF
    q=[]
    visited=[[False]*M for i in range(N)]
    heapq.heappush(q,(-dist_table[sy][sx],sy,sx))
    visited[sy][sx]=True
    while q:
        dist,y,x=heapq.heappop(q)
        min_dist=min(min_dist,-dist)
        if (y,x)==(ty,tx):
            return min_dist
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<M:
                if not visited[ny][nx]:
                    visited[ny][nx]=True
                    heapq.heappush(q,(-dist_table[ny][nx],ny,nx))
d=dijkstra(sy,sx)
print(d)
