# 회장뽑기(2660번)
######################################################
    # 문제: https://www.acmicpc.net/problem/2660
    # 플로이드-워셜 알고리즘
    # 문제를 비효율적으로 푼 줄 알고 시간이 많이 걸릴 줄 알았으나, 84ms여서 엄청 비효율적으로 풀진 않았다.
    # 문제에 점수를 매기는 방법이 나와있지만, 이를 해석하면 회원의 점수는 다른 회원까지 가는데 걸리는 거리 중 가장 큰 거리가 그 회원의 점수가 된다.
    # 따라서 BFS로 각 노드별 탐색 시 visited 배열을 선언하고 다른 노드까지의 최대 거리를 산정하거나, 플로이드 워셜 알고리즘을 사용하거나 하면된다.
######################################################
import sys
input=sys.stdin.readline

N=int(input())
INF=sys.maxsize
graph=[[INF]*(N+1) for i in range(N+1)]
for i in range(1,N+1):
    graph[i][i]=0
while True:
    a,b=map(int,input().split())
    if (a,b)==(-1,-1):
        break
    graph[a][b]=1
    graph[b][a]=1

for k in range(1,N+1):
    for a in range(1,N+1):
        for b in range(1,N+1):
            dist=graph[a][k]+graph[k][b]
            if dist<graph[a][b]:
                graph[a][b]=dist

result=[]
for i in range(1,N+1):
    max_score=0
    for j in range(1,N+1):
        if max_score<graph[i][j]:
            max_score=graph[i][j]
    result.append((i,max_score)) # result 배열에는 (회원 번호, 점수)를 추가한다.
result.sort(key=lambda x:x[1]) # 점수를 기준으로 오름차순 정렬한다.

min_score=result[0][1] 
cnt=0
cand=[]
for i in range(N):
    if result[i][1]!=min_score:
        break
    else:
        cnt+=1
        cand.append(result[i][0])
print(min_score,cnt)
print(*cand)
