# 미친 로봇 (1405번)
import sys
sys.setrecursionlimit(int(1e7))
input = sys.stdin.readline

lst = list(map(int, input().rstrip().split()))  # N, 동, 서, 남, 북
N = lst[0]
dydx = [(0, 0), (0, 1), (0, -1), (1, 0), (-1, 0)]
ewsn = [0, 0, 0, 0]
for i in range(1, 5):
    if lst[i] > 0:
        ewsn[i - 1] += 1


def backtrack(k: int, y: int, x: int, p: float) -> None:
    global ans, visited
    if visited[y][x]:
        return
    visited[y][x] = True
    if k == 0:
        ans += p
        visited[y][x] = False
        return
    for i in range(1, 5):
        if ewsn[i - 1] == 0:
            continue
        ny = y + dydx[i][0]
        nx = x + dydx[i][1]
        backtrack(k - 1, ny, nx, p * (lst[i] / 100))
    visited[y][x] = False


ans = 0  # 확률
visited = [[False] * 15 for _ in range(15)]
backtrack(N, 0, 0, 1)
print(ans)