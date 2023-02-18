# 집에 빨리 가고 싶어!(23033번)
##################################################
    # 문제: https://www.acmicpc.net/problem/23033
    # 다익스트라 알고리즘
    # 나는 탄 시간이 12시이므로 0으로 가정하고 해당 값을 기준으로 %w에 따른 결과에 따라 전개를 했는데, 
    # 자꾸 안 풀려서 보니까 수학적 논리가 조금 부족한 듯하다. 기다려야 하는 시간인 r=w-(ts%w)를 발견하는 게 핵심이었음
    # 나는 ts>w이면 r=ts%w로, ts<w이면 r=w-ts로 설정하는 실수를 범했다.
    # ts>w일 때가 잘못된 이유는 예를 들어 ts=12, w=5라고 할 때, ts>w이므로 r=12%5=2로 2시간을 더 기다려야 한다고 결론이 나오지만,
    # 실제로는 다음 열차는 15가 되어야 출발하므로 3시간을 더 기다려야한다. (12이므로 10일 때 열차는 이미 출발한 뒤니까)
##################################################
import sys, heapq
input=sys.stdin.readline
N,M=map(int,input().split())
graph=[[] for i in range(N+1)]
for i in range(M):
    A,B,T,W=map(int,input().split())
    graph[A].append((B,T,W))
INF=sys.maxsize
def dijkstra():
    distance=[INF]*(N+1)
    q=[]
    heapq.heappush(q,(0,1))
    distance[1]=0
    while q:
        ts,cur=heapq.heappop(q)
        if distance[cur]<ts:
            continue
        for nxt,t,w in graph[cur]:
            if ts%w==0:
                nxt_ts=ts+t
                if nxt_ts<distance[nxt]:
                    distance[nxt]=nxt_ts
                    heapq.heappush(q,(nxt_ts,nxt))    
            elif ts%w!=0:
                r=w-(ts%w) 
                nxt_ts=ts+t+r
                if nxt_ts<distance[nxt]:
                    distance[nxt]=nxt_ts
                    heapq.heappush(q,(nxt_ts,nxt))
    return distance
print(dijkstra()[N])                      
