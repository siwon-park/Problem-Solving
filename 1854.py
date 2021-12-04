#K번째 최단경로 찾기(1854번)
#############################################
    # 문제: https://www.acmicpc.net/problem/1854
    # python3 14%시간초과, pypy3 4844ms 통과 → 코드 개선 필요
    # 다익스트라 알고리즘
    # 일반적인 다익스트라 알고리즘은 최단 거리 테이블에 이미 최단 경로가 기록되어 있다면 중복을 무시하지만, 이 문제의 경우 K번째 최단 거리를 찾아야하므로,
    # 중복을 포함해서 탐색을 해야한다.
    # 풀이의 핵심은 원래 우선순위 큐가 있고, 우선순위 큐로 구성된 2차원의 최단 거리 테이블을 선언하는 것이다.
    # 원래의 우선순위 큐는 최소힙으로 처리하고, 최단 거리 테이블의 우선순위 큐는 최대힙으로 처리한다.
    # 최단거리 배열의 우선 순위 큐의 길이가 k 이하면, 원본 우선 순위 큐에 해당 길이와 다음 위치를 넣고, 최단거리 배열의 우선순위 큐에는 해당 거리값을 최대힙으로 처리한다.
    # 만약 최단거리 배열의 우선 순위 큐 길이가 k 이면, 해당 큐에서 값을 뽑아 현재의 거리와 비교하여 현재 거리가 더 작으면 그 값을 최대 힙으로 푸시한다.
    # 최종적으로 만약 최단 거리 테이블 안의 배열 길이가 k 이하면 -1을 출력하고, k 이면 힙팝을 하여 출력한다.
#############################################
import sys,heapq
input=sys.stdin.readline
n,m,k=map(int,input().split())
distance=[[] for i in range(n+1)]
graph=[[] for i in range(n+1)]  
for i in range(m):
    a,b,c=map(int,input().split())
    graph[a].append((b,c))
q=[]
heapq.heappush(q,(0,1)) # 우선 순위 큐에 (현재 거리, 현재 위치)를 push
heapq.heappush(distance[1],0) # 현재 위치의 최단거리 테이블에 0을 push (왜냐면 i에서 i로 가는 첫번째 최단 거리는 항상 0이므로)
len_dist=[0]*(n+1) # 최단거리 테이블 안의 배열의 길이를 기록하기 위한 배열
len_dist[1]=1 # 현재 1번 최단거리 테이블 안에 0을 넣었으니까 길이는 1임
while q:
    dist,cur=heapq.heappop(q)
    for nxt,cost in graph[cur]:
        d=dist+cost
        if len_dist[nxt]<k: # 다음 위치의 최단 거리 테이블 길이가 k 이하면,
            heapq.heappush(q,(d,nxt)) # 우선 순위 큐에 새로운 거리를 삽입(최소 힙)
            heapq.heappush(distance[nxt],-d) # 다음 위치의 최단 거리 테이블에 새로운 거리의 음수 값을 삽입(최대 힙)
            len_dist[nxt]+=1
        else: # 만약 다음 위치의 최단 거리 테이블의 길이가 k 이면,
            tmp_d=-heapq.heappop(distance[nxt]) #일단, 최댓값을 뽑고
            if d<tmp_d: # 새로운 거리와 뽑은 값을 비교하여 새로운 거리가 더 작으면 그 값을 우선 순위 큐에 삽입한다.
                heapq.heappush(distance[nxt],-d)
                heapq.heappush(q,(d,nxt))
            else:
                heapq.heappush(distance[nxt],-tmp_d) # 아니라면 다시 삽입                
for i in range(1,n+1):
    if len_dist[i]<k:
        print(-1)
    else:
        print(-heapq.heappop(distance[i])) # i번째 최단거리 테이블의 길이는 무조건 k이므로 최댓값을 뽑으면 그게 k번째 최단 경로인 셈이다.
