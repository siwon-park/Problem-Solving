# 문제집(1776번)
#########################################################
    # 문제: https://www.acmicpc.net/problem/1766
    # 위상 정렬
    # 처음에 무의식적으로 큐로 구현하려했는데, 번호가 낮은(=쉬운) 문제를 먼저 풀어야 한다고 했으므로 우선순위 큐를 사용했음
    # 위상 정렬 문제는 뭐가 뭐보다 먼저 와야하고, 진입차수를 +1시켜줘야하는 지와 같은 것을 유의해야하 할 듯하다.
#########################################################
import sys,heapq
input=sys.stdin.readline
N,M=map(int,input().split())
graph=[[] for i in range(N+1)]
indegree=[0]*(N+1)
for i in range(M):
    A,B=map(int,input().split()) # A번 문제는 B번 문제보다 먼저 푸는 것이 좋다
    graph[A].append(B) # A: current, B:next
    indegree[B]+=1 # next 차수 +=1

def topology_sort():
    result=[]
    q=[]
    for i in range(1,N+1):
        if indegree[i]==0:
            heapq.heappush(q,i)     
    while q:
        cur=heapq.heappop(q)
        result.append(cur)
        for nxt in graph[cur]:
            indegree[nxt]-=1
            if indegree[nxt]==0:
                heapq.heappush(q,nxt)         
    return result

print(*topology_sort())

