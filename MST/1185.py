#유럽여행(1185번)
#####################################################
    # 문제: https://www.acmicpc.net/problem/1185
    # 최소 스패닝 트리(크루스칼 알고리즘)
    # 처음에 풀다가 이게 왜 최소 스패닝 트리 문제인지 이해가 안 갔고, 여러 시도를 해보았으나 실패하였음
    # 원리는 생각했던 것보단 간단했는데, 나라가 2개(A,B) 있고 간선 1개로 연결되어 있다고 가정했을 때, 
    # A에서 B로 갔다가 다시 A로 돌아오려면 A는 2번 방문, B는 1번, 간선은 2번 이용해야한다. 특정 나라는 2번 이상 방문해야한다.
    # 그래서 이때 비용은 'A방문 비용 + 간선 비용 + B방문 비용 + 간선 비용 (+ A방문 비용)'이다. (마지막 괄호의 A방문 비용은 최종에서 1번 해주면 되므로 괄호로 둠)
    # 즉, 두 나라간 간선의 가중치 값을 'A방문 비용 + 간선 비용*2 + B방문 비용'로 두고 최소 스패닝 트리를 구하면 된다.
    # 최종적으로 최소 스패닝 트리의 비용+각 나라의 출발 비용 1번(첫 또는 마지막 방문 비용) 중 가장 작은 값을 출력하면 된다.
#####################################################
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

N,P=map(int,input().split())
con_cost=[]
for i in range(N):
    con_cost.append(int(input()))
edges=[]
for i in range(P):
    S,E,L=map(int,input().split())
    edges.append((L*2+con_cost[S-1]+con_cost[E-1],S,E))
edges.sort()

def MST():
    parent=[i for i in range(N+1)]
    result=0
    for edge in edges:
        cost,a,b=edge
        if find_parent(parent,a)!=find_parent(parent,b):
            union_parent(parent,a,b)
            result+=cost
    return result 

start_cost=int(1e9)
for i in range(N):
    cost=con_cost[i]
    if cost<start_cost:
        start_cost=cost
print(start_cost+MST())        
