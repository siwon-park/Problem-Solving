#그래프와 MST(16202번)
#################################################
    # 문제: https://www.acmicpc.net/problem/16202
    # 최소 스패닝 트리(크루스칼 알고리즘)
    # 최소 스패닝 트리리의 비용을 찾는 함수를 만들고, 최대 K번을 돌림
    # K번 돌리면서 매번 맨 앞에 있는 간선을 빼야하므로, 큐로 구현하였고, K번 이하에서 최소 스패닝 트리의 비용이 0이 나왔다면 break를 하여 종료함
#################################################
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

N,M,K=map(int,input().split())

edges=[]
for i in range(M):
    x,y=map(int,input().split())
    edges.append((i+1,x,y))
edges.sort()

def find_mst_cost(q,k):
    result=0
    parent=[i for i in range(N+1)]
    while q:    
        cost,a,b=q.popleft()
        if find_parent(parent,a)!=find_parent(parent,b):
            union_parent(parent,a,b)
            result+=cost
    for i in range(1,N+1):
        find_parent(parent,i)
        if parent[i]!=1:
            return 0        
    return result

score_board=[0 for i in range(K)]

for k in range(1,K+1):
    edge_que=deque(edges)
    mst_cost=find_mst_cost(edge_que,k)
    if mst_cost==0:
        break
    else:
        score_board[k-1]=mst_cost
    edges.pop(0)
print(*score_board)        
