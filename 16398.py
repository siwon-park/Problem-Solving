#행성 연결(16398번)
###################################################
    # 문제: https://www.acmicpc.net/problem/16398
    # 최소 스패닝 트리(크루스칼 알고리즘)
    # 처음 풀었을 때 3172ms → 간선의 정보를 받아올 때 중복을 없애니까 1800ms로 단축시킬 수 있었음
    # 간선에 대한 정보를 행렬 상태로 입력 받으므로, i==j일 때를 생략하고, (i,j)와 (j,i) 중 하나에 대한 정보만 받아오게 해야 단축 가능
    # 나머지 부분은 크게 신경 쓸 필요없이 일반적인 최소 스패닝 트리 문제와 풀이가 동일하므로 생략함
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

N=int(input())
parent=[i for i in range(N+1)]
graph=[] 
edges=[]
for i in range(N):
    graph.append(list(map(int,input().split())))
    for j in range(i+1,N): # j를 i+1부터 시작하게 하면, i==j일 경우를 제외하고, (i,j)와 (j,i) 중 1개의 경우만 간선 배열에 넣을 수 있음
        edges.append((graph[i][j],i+1,j+1))
edges.sort()
result=0
for edge in edges:
    cost,a,b=edge
    if find_parent(parent,a)!=find_parent(parent,b):
        union_parent(parent,a,b)
        result+=cost
print(result)        
