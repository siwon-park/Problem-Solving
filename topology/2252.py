# 줄 세우기(2252번)
#################################################
    # 문제: https://www.acmicpc.net/problem/2252
    # 위상 정렬(topology sort)
#################################################
import sys
from collections import deque
input=sys.stdin.readline
N,M=map(int,input().split())
indegree=[0]*(N+1)
graph=[[] for i in range(N+1)]

for i in range(M):
    A,B=map(int,input().split())
    graph[A].append(B)
    indegree[B]+=1

def topology_sort():
    result=[]
    q=deque()
    for i in range(1,N+1):
        if indegree[i]==0:
            q.append(i)
    while q:
        now=q.popleft()
        result.append(now)
        for nxt in graph[now]:
            indegree[nxt]-=1
            if indegree[nxt]==0:
                q.append(nxt)
    return result
ans=topology_sort()
print(*ans)                        
