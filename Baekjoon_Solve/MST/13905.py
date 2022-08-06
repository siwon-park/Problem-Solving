#세부(13905번)
#####################################################
    # 문제: https://www.acmicpc.net/problem/13905
    # 최소 스패닝 트리(크루스칼 알고리즘)
    # 예외 처리: 연결 그래프가 아니여서 s에서 e로 도달할 수 없는 경우 0을 출력해야함
    # 최대 간선으로 최소 스패닝 트리를 구성하면서 그래프에 연결정보를 담고, s에서 너비 우선 탐색(BFS)을 하여 e까지 들고 갈 수 있는 금빼빼로의 최대 갯수를 구하였음
    # 처음에 연결 그래프가 아닐 경우 즉, parent[e]!=1 일 경우, 0을 출력하게 했으나 25%?에서 틀렸다고 나와서, 그냥 BFS를 다 돌고 나왔을 때, cost_table[e]==INF면 0을 출력하게 함
#####################################################
import sys
from collections import deque
input=sys.stdin.readline

def find_parent(parent,x):
    if parent[x]!=x:
        parent[x]=find_parent(parent,parent[x])
    return parent[x]

def union_parent(parent,a,b):
    a,b=find_parent(parent,a),find_parent(parent,b)
    if a<b:
        parent[b]=a
    else:
        parent[a]=b    

N,M=map(int,input().split())
s,e=map(int,input().split())
edges=[]
for i in range(M):
    h1,h2,k=map(int,input().split())
    edges.append((k,h1,h2))
edges.sort(key=lambda x:-x[0])

parent=[i for i in range(N+1)]
graph=[[] for i in range(N+1)]
for edge in edges:
    cost,a,b=edge
    if find_parent(parent,a)!=find_parent(parent,b):
        union_parent(parent,a,b)
        graph[a].append((b,cost))
        graph[b].append((a,cost))
INF=int(1e9)
visited=[False]*(N+1)
q=deque([(INF,s)]) # 처음에는 금빼빼로를 무한개 들고 갈 수 있다고 가정
cost_table=[INF]*(N+1)
visited[s]=True
while q:
    cur_cost,cur=q.popleft()
    for nxt,nxt_cost in graph[cur]:
        if not visited[nxt]:
            cost_table[nxt]=min(cur_cost,nxt_cost) # 다음 위치로 갈 때는 다리의 무게(k)까지 밖에 못들고 가므로 min함수 적용
            q.append((cost_table[nxt],nxt))
            visited[nxt]=True
if cost_table[e]==INF:
    print(0)
else:
    print(cost_table[e])          
