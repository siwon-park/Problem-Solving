#비밀 모임(13424번)
#################################################
    # 문제: https://www.acmicpc.net/problem/13424
    # 다익스트라 알고리즘
    # 각 친구들의 위치에 대해서 최단 거리 테이블을 구한 뒤, 각 인덱스 끼리 최단 거리 테이블의 요소를 더해서 최솟값이 나오는 가장 작은 방의 번호를 출력하면 됨
#################################################
import sys, heapq
input=sys.stdin.readline
T=int(input())
INF=sys.maxsize

def dijkstra(S):
    distance=[INF]*(N+1)
    q=[]
    heapq.heappush(q,(0,S))
    distance[S]=0
    while q:
        dist,cur=heapq.heappop(q)
        if distance[cur]<dist:
            continue
        for nxt,cost in graph[cur]:
            nxt_dist=dist+cost
            if nxt_dist<distance[nxt]:
                distance[nxt]=nxt_dist
                heapq.heappush(q,(nxt_dist,nxt))                    
    return distance    
    
for _ in range(T):
    N,M=map(int,input().split())
    graph=[[] for _ in range(N+1)]
    for _ in range(M):
        a,b,c=map(int,input().split())
        graph[a].append((b,c))
        graph[b].append((a,c))
    K=int(input())
    friends=list(map(int,input().split()))
    sd=[0 for i in range(N+1)]
    sd[0]=INF
    for fn in friends:
        fd=dijkstra(fn)
        for i in range(1,N+1):
            sd[i]+=fd[i]
    room_no=0
    d=INF
    for i in range(1,N+1):
        if sd[i]<d:
            room_no=i
            d=sd[i]
    print(room_no)       

