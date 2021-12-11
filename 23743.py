#방탈출(23743번)
################################################
    # 문제: https://www.acmicpc.net/problem/23743
    # 최소 스패닝 트리(크루스칼 알고리즘)
    # 최솟값으로 (일부) 방들을 연결해서 1곳에 워프를 뚫거나, 어떤 개별적인 방 하나에 워프를 뚫거나 결정하면 됨
    # 1368번 물대기와 흡사한 문제로, 0번 노드의 존재를 이용해서 구현하면 됨
    # 마지막 한줄에 받아오는 정보의 값이 방에 워프를 뚫는데 드는 비용이므로, 해당 비용이 (워프가 뚫려있는) 다른 방과 연결하는 비용보다 싸면, 해당 방에 워프를 뚫어야한다
    # 즉, 0번 노드와 연결을 하는 것이다
################################################
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
N,M=map(int,input().split())
edges=[]
for i in range(M):
    a,b,c=map(int,input().split())
    edges.append((c,a,b))
t_lst=list(map(int,input().split()))
for i,t in enumerate(t_lst):
    edges.append((t,0,i+1))
edges.sort()         
parent=[i for i in range(N+1)]
result=0
for edge in edges:
    cost,a,b=edge
    if find_parent(parent,a)!=find_parent(parent,b):
        union_parent(parent,a,b)
        result+=cost
print(result)
