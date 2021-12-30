#도로(9344번)
#############################################
    # 문제: https://www.acmicpc.net/problem/9344
    # 최소 스패닝 트리(크루스칼 알고리즘)
    # 최소 간선으로 정렬한 뒤에 연결할 때, (a,b)==(p,q)거나 (b,a)==(p,q)면 "YES"를 출력, 아니면 "NO"를 출력하게하면 됨
#############################################
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

T=int(input())
for _ in range(T):
    N,M,p,q=map(int,input().split())
    parent=[i for i in range(N+1)]
    edges=[]
    for _ in range(M):
        u,v,w=map(int,input().split())
        edges.append((w,u,v))
    edges.sort()
    flag=False
    for edge in edges:
        cost,a,b=edge
        if find_parent(parent,a)!=find_parent(parent,b):
            union_parent(parent,a,b)
            if (a,b)==(p,q) or (b,a)==(p,q):
                flag=True
    if flag:
        print("YES")
    else:
        print("NO")
