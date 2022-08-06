#Jungle Roads(4650번)
#########################################################
    # 문제: https://www.acmicpc.net/problem/4650
    # 최소 스패닝 트리(크루스칼 알고리즘)
    # 입력에 대한 처리만 잘 하면 어렵지 않은 문제
#########################################################
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

dic=dict()
alpha=" ABCDEFGHIJKLMNOPQRSTUVWXYZ"
for i in range(1,27):
    dic[alpha[i]]=i

while True:
    N=int(input())
    if N==0:
        break
    parent=[i for i in range(N+1)]
    edges=[]
    for _ in range(N-1):
        info=list(input().rstrip().split())
        for i in range(int(info[1])):
            edges.append((int(info[2*i+3]),dic[info[0]],dic[info[2*i+2]]))
    edges.sort()

    result=0
    for edge in edges:
        cost,a,b=edge
        if find_parent(parent,a)!=find_parent(parent,b):
            union_parent(parent,a,b)
            result+=cost
    print(result)        
