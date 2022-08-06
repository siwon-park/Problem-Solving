#레드 블루 스패닝 트리(4792번)
##############################################################
    # 문제: https://www.acmicpc.net/problem/4792
    # 최소 스패닝 트리(크루스칼 알고리즘)
    # 스패닝 트리의 파란색 간선의 최소 갯수 <= k <= 스패닝 트리의 파란색 간선의 최대 갯수라면, 정확히 k개의 파란색 간선을 가지는 스패닝 트리를 '반드시' 만들 수 있다
##############################################################
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

def MST(n,m,k):
    parent1,parent2=[i for i in range(n+1)],[i for i in range(n+1)]
    edges=[]
    for i in range(m):
        c,f,t=input().split()
        if c=="B":
            c=0
        else:
            c=1    
        edges.append((c,int(f),int(t)))
    edge1,edge2=edges,edges[:]   
    edge1.sort()
    edge2.sort(key=lambda x:-x[0])
    cnt1,cnt2=0,0
    for edge in edge1:
        color,a,b=edge
        if find_parent(parent1,a)!=find_parent(parent1,b):
            union_parent(parent1,a,b)
            if color==0:
                cnt1+=1
    for edge in edge2:
        color,a,b=edge
        if find_parent(parent2,a)!=find_parent(parent2,b):
            union_parent(parent2,a,b)
            if color==0:
                cnt2+=1                                
    if cnt2<=k<=cnt1:
        return 1
    else:
        return 0                
while True:
    n,m,k=map(int,input().split())
    if (n,m,k)==(0,0,0):
        break
    print(MST(n,m,k))   
