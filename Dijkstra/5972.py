#택배 배송(5972번)
###########################################
    # 문제: https://www.acmicpc.net/problem/5972
    # 다익스트라 알고리즘
    # 처음 그래프 정보 입력 받을 때 양 방향이므로 서로 바꿔서 두 번 입력 받는 거 빼곤 크게 신경 쓸 것 없는 일반적인 다익스트라 알고리즘 문제
###########################################
import sys, heapq
input=sys.stdin.readline
N,M=map(int,input().split())
INF=int(1e9)
distance=[INF]*(N+1)
graph=[[] for i in range(N+1)]
for i in range(M):
    a,b,c=map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

def dijkstra():
    q=[]
    heapq.heappush(q,(0,1))
    distance[1]=0
    while q:
        dist,cur=heapq.heappop(q)
        if distance[cur]<dist:
            continue
        for nxt,cost in graph[cur]:
            n_dist=dist+cost
            if n_dist<distance[nxt]:
                distance[nxt]=n_dist
                heapq.heappush(q,(n_dist,nxt))
    return distance
    
d=dijkstra()
print(d[N])
