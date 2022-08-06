# 제국(10776번)
##########################################################
    # 문제: https://www.acmicpc.net/problem/10776
    # 다익스트라 알고리즘
    # 첫번째 시도: 메모리 초과(뗏목 깎이는 크기가 K이하면 큐에 삽입하게 해서 큐에 너무 많이 요소가 들어갔었음)
    # K의 범위가 작은 것을 이용(1 ≤ K ≤ 200), 2차원의 최단거리 배열을 만듦 → distance[nxt][K]: K만큼 깎이고 nxt까지 가는데 걸린 최소 시간
##########################################################
import sys, heapq
input=sys.stdin.readline

K,N,M=map(int,input().split())
INF=sys.maxsize
graph=[[] for i in range(N+1)]
for i in range(M):
    A,B,t,h=map(int,input().split())
    graph[A].append((B,t,h))
    graph[B].append((A,t,h))
S,E=map(int,input().split())

def dijkstra(S):
    q=[]
    heapq.heappush(q,(0,0,S,S))
    distance=[[INF for j in range(K+1)] for i in range(N+1)]
    distance[S][0]=0
    while q:
        t,h,cur,last=heapq.heappop(q)
        if cur==E:
            return t
        for nxt,nxt_t,nxt_h in graph[cur]:
            if last==nxt:
                continue
            th=h+nxt_h
            if th<K:
                tt=t+nxt_t
                if tt<distance[nxt][th]:
                    heapq.heappush(q,(tt,th,nxt,cur))
                    distance[nxt][th]=tt
    return -1        

print(dijkstra(S))
