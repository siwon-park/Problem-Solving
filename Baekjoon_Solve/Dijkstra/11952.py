#좀비(11952번)
###################################################################
    # 문제: https://www.acmicpc.net/problem/11952
    # 다익스트라 알고리즘, BFS
    # 다 풀어놓고 42%에서 자꾸 틀려서 미칠뻔했는데, 최단 거리가 int(1e9)보다 커질 수도 있어서 INF 무한대의 초기값을 sys.maxsize로 선언해야했음
    # 먼저 좀비에 점령된 지역을 기준으로 너비 우선 탐색(BFS)을 하여, 위험 지역을 찾고
    # 다익스트라 알고리즘을 통해 N까지 갈 수 있는 최단 비용을 찾는다. 단, 이때 마지막에 나온 N까지의 비용은 N에서의 숙박비를 포함한 것이므로,
    # p값을 빼줘야한다.(N은 위험지역도, 좀비에게 점령 당한 곳도 아니므로 숙박비가 p이다)
###################################################################
import sys,heapq
from collections import deque
input=sys.stdin.readline
INF=sys.maxsize # 최단 거리가 int(1e9)보다 클 수 있어서 sys.maxsize로 선언해야함(42%에서 계속 틀렸음)
N,M,K,S=map(int,input().split())
P,Q=map(int,input().split())
graph=[[] for i in range(N+1)]
zombie=[False]*(N+1)
for i in range(K):
    zombie[int(input())]=True      
for i in range(M):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def find_danger_zone():
    danger_zone=[False]*(N+1)
    for start in range(1,N+1):
        if zombie[start]:
            visited=[False]*(N+1)
            q=deque([(start,0)])
            visited[start]=True
            while q:
                cur,steps=q.popleft()
                if steps>S:
                    continue
                danger_zone[cur]=True
                for nxt in graph[cur]:
                    if not visited[nxt]:
                        q.append((nxt,steps+1))
                        visited[nxt]=True
            danger_zone[start]=False                     
    danger_zone[1],danger_zone[N]=False,False
    return danger_zone    

def dijkstra(danger_zone):
    distance=[INF]*(N+1)
    pq=[]
    distance[1]=0
    heapq.heappush(pq,(0,1))
    while pq:
        tc,cur=heapq.heappop(pq)
        if distance[cur]<tc:
            continue
        for nxt in graph[cur]:
            if zombie[nxt]:
                continue
            if danger_zone[nxt]:
                new_cost=tc+Q
            else:
                new_cost=tc+P    
            if new_cost<distance[nxt]:
                distance[nxt]=new_cost
                heapq.heappush(pq,(new_cost,nxt))                                          
    return distance[N]-P
dgz=find_danger_zone()
print(dijkstra(dgz))    
        
