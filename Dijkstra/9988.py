# Roadblock(9988번)
#################################################
    # 문제: https://www.acmicpc.net/problem/9988
    # 다익스트라 알고리즘
    # 몇 번 시도했다가 틀려서, 타 풀이를 통해 힌트를 참고했다. 생각 안 해본 접근법은 아닌데, 시간초과가 날 줄 알고 시도 안 해본 방법이 정답이었다.
    # 내 풀이는 일단 다익스트라 알고리즘을 통해 최단 거리와 최단 경로를 찾았고, 해당 최단 경로 중에서 가장 길이가 긴 것에 대해서 2배를 해준 다음
    # 다시 다익스트라 알고리즘을 돌려서 나온 최단 거리값에서 이전의 최단 거리 값을 빼주는 방법으로 접근하였다. 하지만 이 방법은 18%정도? 에서 틀렸습니다였다.
    # 정답 풀이는, 내가 생각은 했지만 시간초과가 날 것이라 생각했던 접근 법이었는데, 바로 최단 경로에 대해서 하나 하나씩 그 거리를 2배로 하여 다익스트라를 다 돌려보는 것이었다.
    # 하지만, 내 생각과는 달리 잘 통과됐다.
#################################################
import sys, heapq
input=sys.stdin.readline
N,M=map(int,input().split())
INF=sys.maxsize
graph=[[] for i in range(N+1)]
for i in range(M):
    A,B,C=map(int,input().split())
    graph[A].append((B,C))
    graph[B].append((A,C))

path=[i for i in range(N+1)] # 최단 거리 경로를 기록하기 위한 배열
path[1]=0 # 출발지에서는 0으로 기록

def dijkstra(a,b):
    distance=[INF]*(N+1)
    q=[]
    heapq.heappush(q,(0,1))
    distance[1]=0
    while q:
        d,cur=heapq.heappop(q)
        if distance[cur]<d:
            continue
        for nxt,cost in graph[cur]:
            if (cur,nxt)==(a,b) or (cur,nxt)==(b,a): # cur와 nxt가 최단 경로에 있는 두 노드이면, 해당 거리를 2배로 한다.
                cost=cost*2
            nxt_cost=d+cost
            if nxt_cost<distance[nxt]:
                distance[nxt]=nxt_cost
                heapq.heappush(q,(nxt_cost,nxt))
                if check: # check를 통해 처음 다익스트라를 돌릴 때만, 최단 거리 경로를 기록하게 해놓음
                    path[nxt]=cur # cur 다음으로 nxt에 갔다는 의미
    return distance

check=True # check는 처음에 True, 최단 거리 경로를 기록하기 위한 버튼인셈
cur_short_path=dijkstra(0,0)[N] # 제일 처음 다익스트라 알고리즘을 돌릴 땐, 인자를 0,0으로 준다. 어차피 cur과 nxt가 둘 다 0,0인 경우는 절대 안 나오니까 일반적인 최단 경로를 찾는다.
check=False # check를 False로 변경하여 이후에 다익스트라를 돌릴 땐, 최단 거리 경로를 기록하지 않게 한다.
ans=0
for i in range(2,len(path)):
    a,b=i,path[i]
    nxt_short_path=dijkstra(a,b)[N]
    ans=max(nxt_short_path-cur_short_path,ans)
print(ans)
