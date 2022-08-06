#창영이와 퇴근(22116번)
###########################################
    # 문제: https://www.acmicpc.net/problem/22116
    # 다익스트라 알고리즘
    # 최단 거리 테이블에는 그동안 지나오는 경사의 최댓값의 최소를 갱신하여 넣는 개념임
###########################################
import sys,heapq
input=sys.stdin.readline
N=int(input())
board=[]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
for i in range(N):
    board.append(list(map(int,input().split())))
INF=sys.maxsize
def dijkstra():
    q=[]
    distance=[[INF]*(N) for i in range(N)]
    distance[0][0]=0
    heapq.heappush(q,(0,0,0))
    while q:
        dist,y,x=heapq.heappop(q)
        if distance[y][x]<dist:
            continue
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<N:
                nxt_dist=max(dist,abs(board[ny][nx]-board[y][x]))
                if nxt_dist<distance[ny][nx]:
                    distance[ny][nx]=nxt_dist
                    heapq.heappush(q,(nxt_dist,ny,nx))
    return distance
print(dijkstra()[N-1][N-1]) 
