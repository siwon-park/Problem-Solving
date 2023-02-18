#지각하면 안 돼(12763번)
#################################################
    # 문제: https://www.acmicpc.net/problem/12763
    # 다익스트라 알고리즘
    # 처음 시도는 틀렸습니다 → 해당장소까지 최소 비용일 때만, 큐에 삽입하게 했기 때문.
    # 이게 잘못된 이유는 해당 장소까지 최소 비용으로 갔을 때, 다음 장소까지 시간이 안돼서 못가는 경우가 발생함
    # 그리고 어떤 장소까지 가는데 최소비용은 아닌데, 시간이 될 경우 다음 장소까지 갈 수 있고, 이 경우 다음 장소로 가는 최소 비용이 될 수도 있음
    # 시간초과를 방지하기 위해 큐의 맨마지막 요소는 방금 전 지나왔던 노드의 번호를 넣었음
    # 이렇게 하여 시간과 예산이 충분할 경우, 다음 장소에서 이전 장소로 왔다 갔다 반복하는 낭비를 방지하였음
#################################################
import sys, heapq
input=sys.stdin.readline

N=int(input())
T,M=map(int,input().split())
L=int(input())
graph=[[] for i in range(N+1)]
INF=sys.maxsize
for i in range(L):
    a,b,t,c=map(int,input().split())
    graph[a].append((b,t,c))
    graph[b].append((a,t,c))

def dijkstra():
    q=[]
    heapq.heappush(q,(0,0,1,0)) # 비용, 시간, 현재 노드, 최근 노드
    distance=[INF]*(N+1)
    distance[1]=0
    while q:
        c,t,cur,last=heapq.heappop(q)
        if cur==N:
            return c
        for nxt,nxt_t,nxt_c in graph[cur]:
            if nxt==last: # (1번 이동 후) 만약 다음 노드가 최근 노드라면 그쪽으로 가지 않음. 이미 지나왔으니까
                continue
            took,cost=t+nxt_t,c+nxt_c
            if took<=T and cost<=M: # 현재까지 걸린 시간과 비용이 시간적 여유와 예산 이하면 큐에 삽입
                heapq.heappush(q,(cost,took,nxt,cur))
                if cost<distance[nxt]: # 최단거리 테이블에는 nxt까지 갈 수 있는 최소 비용을 갱신함
                    distance[nxt]=cost
    if distance[N]==INF:
        return -1

print(dijkstra())
