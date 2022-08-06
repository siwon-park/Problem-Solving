#고속철도 설계하기(1833번)
####################################################
    # 문제: https://www.acmicpc.net/problem/1833
    # 최소 스패닝 트리(크루스칼 알고리즘)
    # 문제에서 "그림에 나타나지 않은 비용은 1000이라고 하자"는 말이 있고 그림에서 1000이라고 표현된 노드끼리 연결된 것이 안 보여서
    # "비용이 1000이면 서로 연결할 수 있는 간선이 없다"로 해석해버리는 실수를 범함. 그림에만 없을 뿐, 1000도 엄연한 비용이었음
    # 또한 입력으로 받은 비용이 음수일 때, union_parent를 했는데, 이 때 해당 노드의 부모노드를 0번 노드이다 parent[i]=0는 식으로 지정하면 안 됨
    # 왜냐하면 예를 들어 1-3이 연결되어 있고, 2-4가 연결되어 있는 상태에서 4 노드의 부모노드를 0번 노드로 지정해버리면
    # 현재 연결되지 않은 2-3을 연결하는 간선이 있는데 find_parent를 했을 때, 실제론 연결이 안 돼있음에도 불구하고 0번 노드를 공통 부모 노드로 갖기 때문
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
result=0
parent=[i for i in range(N+1)]
for i in range(N):
    info=list(map(int,input().split()))
    for j in range(i+1,N):
        if info[j]>0:
            edges.append((info[j],i+1,j+1))
        elif info[j]<0:
            result+=-info[j]
            union_parent(parent,i+1,j+1) # 반드시 union_parent로 해야함. parent[i+1]=0, parent[j+1]=0으로 하면 잘못된 논리임
edges.sort()
n_inst=0
n_inst_lst=[]
for edge in edges:
    cost,a,b=edge
    if find_parent(parent,a)!=find_parent(parent,b):
        union_parent(parent,a,b)
        result+=cost
        n_inst+=1
        n_inst_lst.append((a,b))
print(result,n_inst)
for n_insts in n_inst_lst:
    print(*n_insts)        
