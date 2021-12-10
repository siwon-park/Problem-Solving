#물대기(1368번)
####################################################
    # 문제: https://www.acmicpc.net/problem/1368
    # 최소 스패닝 트리(크루스칼 알고리즘)
    # 최소 비용으로 모든 논에 물을 대야하는데, 그 방법은 직접 논에 물을 파거나, 물을 다른 논으로 대는 것임
    # 즉, 일단 기본 개념은 하나의 논을 파고 모든 논을 연결하는 비용을 구하는 것인데,
    # 여기서 반드시 고려해야할 점은 해당 논에 물을 대는 비용보다 직접 우물을 파는 비용이 더 싸면 직접 파야한다는 것임
    # 따라서 경우에 따라 모든 논이 간선으로 연결되지 않을 수도 있는 셈이다
    # 구현 개념은 간단한데, 0번 노드의 존재를 가정하고, 우물을 직접 파는 경우를 n번 노드와 0번 노드를 연결한다 식으로 생각하면 됨
    # 어떤 케이스든 간에, 일단 최소 1개의 논에 물은 파야하므로, 모두 0번 노드를 부모 노드로 가질 수 밖에 없음
####################################################
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

N=int(input())
edges=[]
for i in range(N):
    c=int(input())
    edges.append((c,0,i+1))
graph=[]
for i in range(N):
    graph.append(list(map(int,input().split())))
    for j in range(i+1,N):
        edges.append((graph[i][j],i+1,j+1))
parent=[i for i in range(N+1)]
edges.sort()
result=0
for edge in edges:
    cost,a,b=edge
    if find_parent(parent,a)!=find_parent(parent,b):
        union_parent(parent,a,b)
        result+=cost           
print(result)        
