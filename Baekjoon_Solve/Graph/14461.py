#소가 길을 건너간 이유7(14461번) 
###########################################################
    # 문제: https://www.acmicpc.net/problem/14461
    # 다익스트라 알고리즘
    # 논리상 틀린 이유가 없는 것 같은데, 자꾸 틀려서 타풀이 참조함(틀린 이유는 여전히 모르겠음)
    # 굳이 꼭 3차원의 배열을 선언할 필요가 없을 것 같은데....?
###########################################################
import sys, heapq
input=sys.stdin.readline

N,T=map(int,input().split())
board=[]
for i in range(N):
    board.append(list(map(int,input().split())))

dydx=[(-1,0),(0,1),(1,0),(0,-1)]
INF=sys.maxsize

def dijkstra():
    q=[]
    heapq.heappush(q,(0,0,0,0))
    visited=[[[False,False,False] for j in range(N)] for i in range(N)]
    while q:
        spnd,cnt,y,x=heapq.heappop(q)
        if visited[y][x][cnt]:
            continue
        visited[y][x][cnt]=True
        if (y,x)==(N-1,N-1):
            return spnd
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<N:
                if cnt==2:
                    heapq.heappush(q,(spnd+T+board[ny][nx],0,ny,nx))
                else:
                    heapq.heappush(q,(spnd+T,cnt+1,ny,nx))
d=dijkstra()
print(d)
