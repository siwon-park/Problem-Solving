#의약품 수송(16227번)
######################################################
    # 문제: https://www.acmicpc.net/problem/16227
    # 다익스트라 알고리즘
    # 실수 하나 때문에 제대로된 답을 출력하지 못해서 조금 시간이 걸렸음
    # 34번째 줄에서 우선순위 큐에 삽입할 때, 중간에 cost가 아니고 0 또는 5를 삽입했음. 100이 넘으면 5분 쉬고 0이 된다음에 cost만큼 가는 것이므로 cost를 삽입해야 했었음 
######################################################
import sys, heapq
input=sys.stdin.readline
N,K=map(int,input().split())
INF=sys.maxsize
graph=[[] for i in range(N+2)]
for i in range(K):
    u,v,t=map(int,input().split())
    graph[u].append((v,t))
    graph[v].append((u,t))

def dijkstra():
    distance=[INF]*(N+2)
    q=[]
    heapq.heappush(q,(0,0,0)) # 총 운행거리, 현재 주행거리, 현재 노드
    distance[0]=0
    while q:
        dist,cur_drive,cur=heapq.heappop(q)
        if distance[cur]<dist:
            continue
        for nxt,cost in graph[cur]:
            if cost>100: # 다음 노드까지 가는 cost가 100이상이면 절대 못가므로 continue처리
                continue
            nxt_dist=dist+cost
            if cur_drive+cost>100: # 현재 주행거리+다음 노드까지의 거리가 100보다 크면 현재 노드에서 5분 쉬고 출발해야하므로 +5를 해줘야함
                if nxt_dist+5<distance[nxt]:
                    distance[nxt]=nxt_dist+5
                    heapq.heappush(q,(nxt_dist+5,cost,nxt)) # 5분 쉬고 난 뒤에 현재 운행거리는 0으로 초기화되고, cost만큼 가야 다음 노드까지 가므로 중간 요소로 0+cost삽입
            else:
                if nxt_dist<distance[nxt]:
                    distance[nxt]=nxt_dist
                    heapq.heappush(q,(nxt_dist,cur_drive+cost,nxt))
    return distance[N+1]
    
print(dijkstra())    
