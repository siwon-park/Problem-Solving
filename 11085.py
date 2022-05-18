# 군사 이동(11085번)
########################################################################################
    # 문제: https://www.acmicpc.net/problem/11085
    # 분리집합(union-find)
    # 문제 이해가 잘 안돼서 시간을 조금 소비했다.
    # 첫 시도는 최소 스패닝 트리를 구성하는 길의 너비 중 가장 큰 너비를 출력하는 줄 알았으나 틀렸습니다를 받았다.
    # 그래서 문제를 다시보니, 최대 스패닝 트리를 구성하는 길의 너비 중 가장 작은 너비인가 싶어서 제출했는데 또 틀렸습니다를 받았다.
    # 생각해보니 굳이 모든 노드를 연결할 필요가 없다는 것을 깨달았다.
    # 그러므로 최대 스패닝 트리를 구성해가면서 c와 v의 부모가 같아지면 break를 하면 되는 것이었다.
    # 예를 들어
    # 3 3
    # 1 2
    # 0 1 1
    # 0 2 2
    # 1 2 100
    # 위와 같은 예시에서 정답은 100을 출력해야한다.
    # 즉, 가장 넓은 너비의 거리를 선택해가면서 두 노드가 연결되었으면 탐색을 중단하면 되는 것이다. 
########################################################################################
import sys
input = sys.stdin.readline

def find_parent(x):
    if parent[x] != x:
        parent[x] = find_parent(parent[x])
    return parent[x]

def union_parent(a, b):
    a, b = find_parent(a), find_parent(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

p, w = map(int, input().split())
c, v = map(int, input().split())

parent = [i for i in range(p)]

edges = []
for _ in range(w):
    ws, we, ww = map(int, input().split())
    edges.append((ww, ws, we))
edges.sort(key=lambda x: -x[0])

result = sys.maxsize
for edge in edges:
    cost, a, b = edge
    if find_parent(a) != find_parent(b):
        union_parent(a, b)
        result = min(result, cost)
        if find_parent(c) == find_parent(v):
            break
print(result)
