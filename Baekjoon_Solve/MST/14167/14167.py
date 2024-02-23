# Moocast (14167번)
import sys
input = sys.stdin.readline


def cal_dist(a: tuple, b: tuple) -> int:
    return (a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2


def find(x: int) -> int:
    global parent
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a: int, b: int) -> None:
    global parent
    a, b = find(a), find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


N = int(input().rstrip())
lst1 = []
parent = [0]
for i in range(N):
    t = tuple(map(int, input().rstrip().split()))
    lst1.append(t)
    parent.append(i + 1)

lst2 = []
for i in range(N):
    A = lst1[i]
    for j in range(i + 1, N):
        B = lst1[j]
        lst2.append((i, j, cal_dist(A, B)))

lst2.sort(key=lambda x: x[2])
X = 0
m = 0
for u, v, c in lst2:
    if find(u) != find(v):
        X = max(X, c)
        union(u, v)
        m += 1
        if m == N - 1:
            break

print(X)
