#레이저 통신(6087번)
#############################################################
    # 문제: https://www.acmicpc.net/problem/6087
    # 다익스트라 최단거리 알고리즘
    # 우선순위 큐에 (설치한 거울의 수, (원래 방향), (현재 좌표))를 삽입하고 다음 위치로 가는데,
    # 만약 방향을 꺾어서 다음 위치로 갔다면((원래 방향)과 (dy,dx)가 서로 다를 경우), 2차원의 최단거리 배열에
    # 설치한 거울의 수+1을 하고, 그게 아니라면 설치한 거울의 수를 그대로 넣는다.
    # 그런데 중요한 것은 어떤 특정 위치에 도달하는 경우의 수와 거리는 그 전에 어떻게 꺾어서 왔느냐에 따라 달라진다.
    # 따라서 해당 위치의 2차원 최단거리 배열의 값(거울 설치 개수)이 단순히 작을 경우에만 우선순위 큐에 삽입하는 것이 아니라,
    # '작거나 같을 경우'에 삽입 하는 것이 가장 중요하다.
#############################################################
import sys,heapq
input=sys.stdin.readline
W,H=map(int,input().split())
board=[]
c_lst=[]
for i in range(H):
    board.append(list(input().rstrip()))
    for j in range(W):
        if board[i][j]=="C":
            c_lst.append((i,j))
INF=int(1e9)
dydx=[(-1,0),(0,1),(1,0),(0,-1)]
def dijkstra():
    q=[]
    distance=[[INF]*W for i in range(H)]
    heapq.heappush(q,(0,(0,0),(c_lst[0][0],c_lst[0][1]))) # 우선순위 큐에 (설치한 거울의 수, (원래 방향), (현재 좌표)) 순으로 삽입한다
    distance[c_lst[0][0]][c_lst[0][1]]=0 
    while q:
        m_cnt,way,yx=heapq.heappop(q)
        y,x=yx[0],yx[1]
        if distance[y][x]<m_cnt:
            continue
        for dy,dx in dydx:
            ny,nx=y+dy,x+dx
            if 0<=ny<H and 0<=nx<W:
                if board[ny][nx]==".":
                    if way!=(dy,dx) and way!=(0,0): # 원래 방향과 다음 방향이 다를 경우, (단, 원래 방향이 (0,0)이 아닐 경우를 같이 넣어줘야함. 첫 출발에선 방향 꺾임을 고려 X)
                        if m_cnt+1<=distance[ny][nx]: # <이 아니고 <=이어야 함
                            distance[ny][nx]=m_cnt+1
                            heapq.heappush(q,(m_cnt+1,(dy,dx),(ny,nx)))
                    elif way==(dy,dx) or way==(0,0): # 원래 방향과 다음 방향이 같을 경우, (단, 원래 방향이 (0,0)이면, 첫 출발이므로 방향 꺾임이 없는 것과 같다)
                        if m_cnt<=distance[ny][nx]: # <이 아니고 <=이어야 함
                            distance[ny][nx]=m_cnt
                            heapq.heappush(q,(m_cnt,(dy,dx),(ny,nx)))
                elif board[ny][nx]=="C":
                    if way!=(dy,dx):
                        if m_cnt+1<distance[ny][nx]:
                            distance[ny][nx]=m_cnt+1
                    elif way==(dy,dx):
                        if m_cnt<distance[ny][nx]:
                            distance[ny][nx]=m_cnt    
    return distance                        
d=dijkstra()        
print(d[c_lst[1][0]][c_lst[1][1]])       
