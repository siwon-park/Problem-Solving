#학교 탐방하기(13418번)
#################################################
    # 문제: https://www.acmicpc.net/problem/13418
    # 최소 스패닝 트리(크루스칼 알고리즘)
    # 오르막은 0, 내리막은 1로 주어지므로, 최악의 경로는 오르막을 최대한 많이 오르는 경우이고, 최상의 경로는 내리막을 최대한 많이 이용해서 가는 경우이다.
    # 간선과 부모 노드 테이블을 각 각 2개 선언하고, 하나는 오르막 우선으로 정렬하고, 하나는 내리막 우선으로 정렬한다.
    # 노드의 부모를 확인하여 서로 부모 노드가 다르면 연결하고, 그 때의 길이 0이면 count+=1을 하여 오르막에 대해서 카운트하고, 총 카운트 수의 제곱을 반환하는 함수를 만듦
    # 최악의 경로 우선에 대해서 함수를 돌린 결과에서 최상의 경로 우선에 대해서 함수를 돌린 결과를 뺀 값을 출력함
#################################################
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

incline_edges,decline_edges=[],[]
for i in range(M+1):
    a,b,c=map(int,input().split())
    incline_edges.append((c,a,b))
    decline_edges.append((c,a,b))
incline_edges.sort()
decline_edges.sort(key=lambda x: -x[0]) 

in_parent,de_parent=[i for i in range(N+1)],[i for i in range(N+1)]

def fatigue(edges,parent):
    count=0
    for edge in edges:
        state,a,b=edge
        if find_parent(parent,a)!=find_parent(parent,b):
            union_parent(parent,a,b)
            if state==0:
                count+=1
    return count**2

print(fatigue(incline_edges,in_parent)-fatigue(decline_edges,de_parent))                
