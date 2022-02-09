# 데스나이트(16948번)
############################################################
    # 문제: https://www.acmicpc.net/problem/16948
    # 너비 우선 탐색(BFS)
    # 매우 기본적인 BFS 문제
############################################################
import sys
from collections import deque
input=sys.stdin.readline

N=int(input())
r1,c1,r2,c2=map(int,input().split())
dydx=[(-2,-1),(-2,1),(0,-2),(0,2),(2,-1),(2,1)]

q=deque([(0,r1,c1)])
visited=[[False]*N for i in range(N)]

def bfs():
    while q:
        moved,y,x=q.popleft()
        if (y,x)==(r2,c2):
            return moved
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<N and 0<=nx<N:
                if not visited[ny][nx]:
                    q.append((moved+1,ny,nx))
                    visited[ny][nx]=True
    return -1

print(bfs())
