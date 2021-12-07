#전력난(6497번)
####################################################
    # 문제: https://www.acmicpc.net/problem/6497
    # 크루스칼 알고리즘(최소 스패닝 트리)
    # 문제에서 원하는 출력값은 절약할 수 있는 금액을 구하는 것이므로, 입력으로 받는 모든 비용을 더한 값에 최소 비용으로 연결할 수 있는 값을 빼면 된다.
    # 그 외에 유의할 점은 "입력은 여러 개의 테스트 케이스로 구분되어 있다"이고, 입력의 끝은 0이 2개 주어진다고 했으므로, (m,n)==(0,0)이면 종료하고 그게 아니면 계속 루프를 돌면된다.
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

def cal_cost(m,n):
    edges=[]
    total=0 # 모든 노드를 연결했을 때의 총 비용
    for i in range(n):
        x,y,z=map(int,input().split())
        edges.append((z,x,y))
        total+=z
    edges.sort()
    result=0 # 최소 연결 비용
    parent=[i for i in range(m)]
    for edge in edges:
        cost,a,b=edge
        if find_parent(parent,a)!=find_parent(parent,b):
            union_parent(parent,a,b)
            result+=cost
    return total-result # 절약 

while True:
    m,n=map(int,input().split())
    if (m,n)==(0,0):
        break
    print(cal_cost(m,n))
