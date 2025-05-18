import sys

input = sys.stdin.readline

# 현대모비스 특별상의 주인공은? 2 (31924번)
n = int(input().rstrip())
MOBIS = "MOBIS"
dy = [-1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, 1, 1, 1, 0, -1, -1, -1]
graph = []
for i in range(n):
    graph.append(input().rstrip())


def is_mobis(r: int, c: int, k: int) -> bool:
    global n, dy, dx
    idx = 0
    nr = r
    nc = c
    ret = "M"
    for _ in range(4):
        nr += dy[k]
        nc += dx[k]
        idx += 1
        if nr < 0 or nr >= n or nc < 0 or nc >= n:
            return False
        ret += graph[nr][nc]
    if ret != MOBIS:
        return False
    return True

ans = 0
for i in range(n):
    for j in range(n):
        if graph[i][j] == "M":
            for k in range(8):
                flag = is_mobis(i, j, k)
                if flag:
                    ans += 1

print(ans)

