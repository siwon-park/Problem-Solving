import sys
input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a, b = find_parent(parent, a), find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def cal_cost(m, n):
    edges = []
    total = 0
    for i in range(n):
        x, y, z = map(int, input().split())
        edges.append((z, x, y))
        total += z
    edges.sort()
    result = 0
    parent = [i for i in range(m)]
    cnt = 0
    for edge in edges:
        cost, a, b = edge
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)
            result += cost
            cnt += 1
            if cnt == m - 1:
                return total - result
    return total - result

while True:
    m, n = map(int, input().split())
    if (m, n) == (0, 0):
        break
    print(cal_cost(m, n))