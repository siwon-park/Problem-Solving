#떡 돌리기(20007번)
#################################################
    # 문제: https://www.acmicpc.net/problem/20007
    # 다익스트라 알고리즘
    # 문제의 핵심 포인트는 "떡은 한번에 하나씩만 들고 갈 수 있다."와 "하루에 X보다 먼 거리를 걷지 않고 거리가 가까운 집부터 방문한다."이다.
    # 이 두 가지 핵심 포인트만 잘 염두해두면 무난하게 풀 수 있는 문제. 최소 날짜를 구할 때, 로직 부분에서 조금 고민을 하였음.
    # 왕복한다는 개념에 기반하여 최초에 거리를 입력 받을 때, x2를 해주고 최단 거리 테이블을 구함
    # 100% 에서 틀렸습니다 나올 경우 반례) X=2, N=4, 최단 거리 테이블=[2,2,2,0]
#################################################
import sys,heapq
input=sys.stdin.readline
N,M,X,Y=map(int,input().split())
graph=[[] for i in range(N)]
for i in range(M):
    A,B,C=map(int,input().split())
    graph[A].append((B,2*C))
    graph[B].append((A,2*C))
INF=sys.maxsize
def dijkstra(S):
    q=[]
    heapq.heappush(q,(0,S))
    distance=[INF]*N
    distance[S]=0
    while q:
        dist,cur=heapq.heappop(q)
        if distance[cur]<dist:
            continue
        for nxt,cost in graph[cur]:
            nxt_dist=cost+dist
            if nxt_dist<distance[nxt]:
                heapq.heappush(q,(nxt_dist,nxt))
                distance[nxt]=nxt_dist
    return distance

d=dijkstra(Y)

def find_min_day(table):
    table.sort()
    x=X
    day=1
    for i in range(1,N):
        if table[i]>X:
            return -1
        else:
            if x-table[i]>=0:
                x-=table[i]
                if x==0:
                    x=X
                    if i!=N-1:
                        day+=1
            elif x-table[i]<0:
                day+=1
                x=X-table[i]                        
    return day    

print(find_min_day(d))    
