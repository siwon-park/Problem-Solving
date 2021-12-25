#전기가 부족해(10423번)
###################################################
    # 문제: https://www.acmicpc.net/problem/10423
    # 최소 스패닝 트리(크루스칼 알고리즘)
    # 발전소가 있는 도시가 있으므로, 모든 노드를 꼭 간선을 통해서만 연결하지 않아도 됨
    # 발전소가 있는 도시는 0번 노드와 비용 0으로 연결되어 있다고 가정하고, 먼저 연결함
    # 나머지 노드들에 대해서 0번 노드를 부모 노드로 가지지 않은 노드를 최소 비용의 간선으로 연결하면 됨
    # 1368번(물대기) 문제와 23743번(방탈출) 문제와 유사한 문제 
###################################################
import sys
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
parent=[i for i in range(N+1)]
edges=[]
gene=list(map(int,input().split()))
for g in gene:
    parent[g]=0
result=0
for i in range(M):
    u,v,w=map(int,input().split())
    edges.append((w,u,v))
edges.sort()    
for edge in edges:
    cost,a,b=edge
    if find_parent(parent,a)!=find_parent(parent,b):
        union_parent(parent,a,b)
        result+=cost    
print(result)
