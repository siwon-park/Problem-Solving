#KCM Travel(10217번)
#################################################
    # 문제: https://www.acmicpc.net/problem/10217
    # 다익스트라 알고리즘
    # 제국(10776번) 문제와 동일한 문제이나, 제국은 제한 조건이 (1 ≤ K(뗏목 두께) ≤ 200; 2 ≤ N(노드 수) ≤ 2000)이고
    # 이 문제는 노드 수 N (2 ≤ N ≤ 100), 총 지원비용 M (0 ≤ M ≤ 10,000)이기 때문에 훨씬 더 많은 반복이 필요하고
    # 따라서 제국 문제와 같이 코드를 구현했을 때, 메모리 초과가 남. 그래서 최적화가 필요함
    # 새로운 시간(n_time)이 nxt까지 n_cost를 써서 갈 수 있는 시간(distance[nxt][n_cost])보다 작으면 값을 갱신하는데,
    # 여기서 for 반복 구문을 돌려서 n_cost보다 큰 값에 대해서도
    # 배열에 기록된 최단 시간이 n_time보다 작지 않으면 n_time으로 갱신함
    # 이렇게 하면 if distance[cur][bdgt]<tt: continue 구문을 사용해도 논리적으로 잘못된 것이 없기 때문에 반복을 피해서 메모리 초과를 피할 수 있음
    # 또한 단방향 그래프이므로 유의
#################################################
import sys,heapq
input=sys.stdin.readline
T=int(input())
INF=sys.maxsize

def dijkstra(N):
    answer=INF
    q=[]
    distance=[[INF]*(M+1) for i in range(N+1)]
    distance[1][0]=0
    heapq.heappush(q,(0,0,1,1))
    while q:
        tt,bdgt,cur,last=heapq.heappop(q)
        if distance[cur][bdgt]<tt: # 최적화를 하여 이 구문을 사용하면 굳이 더 확인할 필요 없는 부분에 대해서 생략 가능함
            continue   
        if cur==N:
            return tt
        for nxt,cost,t in graph[cur]:
            if last==nxt:
                continue
            n_cost=bdgt+cost
            if n_cost<=M:
                n_time=tt+t
                if n_time<distance[nxt][n_cost]:
                    for j in range(n_cost+1,M+1): # 최적화) n_cost보다 큰 비용에 대해서도 배열 값이 n_time보다 크면 n_time으로 바꿈 
                        if distance[nxt][j]<=n_time: # 만약 배열의 값이 n_time보다 작거나 같으면 그 이후도 n_time보다 작거나 같으므로 break
                            break
                        distance[nxt][j]=n_time
                    heapq.heappush(q,(n_time,n_cost,nxt,cur))
                    distance[nxt][n_cost]=n_time                
    return "Poor KCM"

for _ in range(T):
    N,M,K=map(int,input().split())
    graph=[[] for i in range(N+1)]
    for i in range(K):
        u,v,c,d=map(int,input().split())
        graph[u].append((v,c,d)) # 유의) 양방향이 아니라 단방향임
    dist=dijkstra(N)
    print(dist)
