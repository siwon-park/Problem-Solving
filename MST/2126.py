#지진(2126번)
##################################################
    # 문제: https://www.acmicpc.net/problem/2126
    # 최소 스패닝 트리(크루스칼 알고리즘), 파라메트릭 서치
    # 시간당 비용 효율의 최대를 찾아야함. 따라서 비용, 시간이 작은 것을 골라야하는데, 일반적인 정렬을 실시하면 찾을 수 없음
    # 효율(k)= (F-(총비용))/총 시간 인데, 해당 산식을 F에 대해 정리하면 F= 효율*(총)시간+(총)비용이다
    # 즉, 효율*(총)시간+(총)비용이 최저가 되게 하는 효율값을 찾으면 된다.
    # 일반적인 파라메트릭 서치로 계산하면 while s<=e가 되면 탈출하게되나, 이 문제의 경우 무한 루프가 발생할 수도 있다.
    # 왜냐하면 보통 s나 e를 옮길 때, m+1 혹은 m-1을 하나 소숫점을 염두해 둬야하므로 +-1을 할 수 없다. s=m, e=m으로 해야한다.
    # 따라서 last라는 변수를 두고 m값이 이전(last)과 같다면 break를 하여 탈출하게끔 했음
##################################################
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

N,M,F=map(int,input().split())
edges=[]
for _ in range(M):
    i,j,c,t=map(int,input().split())
    edges.append((t,c,i,j))

def find_most(m):    
    edges.sort(key=lambda x: m*x[0]+x[1])  
    effc=0
    parent=[i for i in range(N+1)]
    for edge in edges:
        t,c,a,b=edge
        if find_parent(parent,a)!=find_parent(parent,b):
            union_parent(parent,a,b)
            effc+=m*t+c
    return F-effc

s,e=0,int(1e9)
last=0
while s<=e:
    m=(s+e)/2
    result=find_most(m)
    if last==m:
        print(format(last,".4f"))
        break
    if result>=0:
        s=m
    else:
        e=m
    last=m    
