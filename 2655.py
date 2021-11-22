#미로 만들기(2655번)
###############################################
    # 문제: https://www.acmicpc.net/problem/2665
    # 다익스트라 알고리즘
    # 1261번 알고스팟 문제와 동일한 문제(풀이 생략; 1261.py 참조)
    # 이미 방문했던 흰색 칸을 계속해서 지나는 중복을 피하기 위해선 turned를 활용. turned가 사실상 최단거리를 판별하는 셈임
    # 검은 칸을 뒤집어서 해당 칸을 방문했는데, 현재까지 뒤집은 횟수가 해당 칸을 방문했을 때의 뒤집은 횟수보다 작을 경우에만 우선순위 큐에 삽입
###############################################
import sys, heapq
input=sys.stdin.readline
n=int(input())
board=[]
for i in range(n):
    board.append(list(input().rstrip()))
INF=int(1e9)
distance=[[INF]*n for i in range(n)]
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
def dijkstra():
    q=[]
    heapq.heappush(q,(0,0,0))
    distance[0][0]=0
    while q:
        turned,y,x=heapq.heappop(q)
        if distance[y][x]<turned:
            continue
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<n and 0<=nx<n:
                if board[ny][nx]=="0":
                    T=turned+1
                    if T<distance[ny][nx]:
                        distance[ny][nx]=T
                        heapq.heappush(q,(T,ny,nx))
                else:
                    if turned<distance[ny][nx]: # 흰색 칸을 방문하는 경우, 현재까지 뒤집은 횟수가 방문할 칸에 뒤집은 횟수보다 작으면 우선순위 큐 삽입
                        distance[ny][nx]=turned
                        heapq.heappush(q,(turned,ny,nx))
    return distance
d=dijkstra()
print(d[n-1][n-1])                                               
