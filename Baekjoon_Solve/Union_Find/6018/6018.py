import sys
input = sys.stdin.readline

# Tea Time (6018번)
N, M, Q = map(int, input().rstrip().split())
parent = [i for i in range(N + 1)]


def find(x: int) -> int:
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a: int, b: int) -> None:
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


for i in range(M):
    a, b = map(int, input().rstrip().split())
    union(a, b)

for i in range(Q):
    x, y = map(int, input().rstrip().split())
    if find(x) == find(y):
        print("Y")
    else:
        print("N")

