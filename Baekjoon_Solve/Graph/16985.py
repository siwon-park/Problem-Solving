# Maaaaaaaaaze(16985번)
###################################################################################
    # 문제: https://www.acmicpc.net/problem/16985
    # BFS, 브루트포스
    # 순열과 중복조합의 개념을 활용해서 구성할 수 있는 3차원의 5X5X5 큐브 모양의 경우를 브루트포스로 접근하였다
    # 또한, 이전에 정리해뒀던 행렬 90도, 180도, 270도 회전 함수를 활용하였다.
    # 경우의 수를 고려했을 때, 격자판 5개를 순열로 구성하는 경우의 수 5! = 120
    # 격자판을 회전 시킨다고 했을 때, 4^5 = 1024
    # 5X5 격자판을 BFS로 탐색한다 했을 때(층 이동까지 포함), 5 * 5 * 6 = 150
    # 굵직한 경우의 수만 고려했을 때, 120 x 1024 X 150 = 1843만이다
    # 또한 어떻게 가든, 만약 입구에서 출구까지의 최단거리가 12가 나왔다면 해당 거리보다 최소인 경우는 나올 수가 없으므로
    # 그대로 return하여 최적화를 시켜주었다.
###################################################################################
import sys
from collections import deque
input = sys.stdin.readline

# 행렬 90도 회전
def rotate_90(arr):
    res = [[0] * 5 for _ in range(5)]
    for r in range(5):
        for c in range(5):
            res[c][r] = arr[4 - r][c]
    return res

# 행렬 180도 회전
def rotate_180(arr):
    res = [[0] * 5 for _ in range(5)]
    for r in range(5):
        for c in range(5):
            res[r][c] = arr[4 - r][4 - c]
    return res

# 행렬 270도 회전
def rotate_270(arr):
    res = [[0] * 5 for _ in range(5)]
    for r in range(5):
        for c in range(5):
            res[c][r] = arr[r][4 - c]
    return res

# 순열 구현 => 층의 순서 결정
used = [False] * 5
ret = []
def permute(k, lst):
    if k == 5:
        ret.append(lst[:])
        return
    for i in range(5):
        if not used[i]:
            used[i] = True
            lst.append(i)
            permute(k + 1, lst)
            lst.pop()
            used[i] = False

permute(0, [])

# 중복 조합 구현 => 층별 회전 결정
ret2 = []
def product(k, lst):
    if k == 5:
        ret2.append(lst[:])
        return
    for i in range(4):
        lst.append(i)
        product(k + 1, lst)
        lst.pop()

product(0, [])

# 격자판 입력 받기
arr1 = [list(map(int, input().split())) for _ in range(5)]
arr2 = [list(map(int, input().split())) for _ in range(5)]
arr3 = [list(map(int, input().split())) for _ in range(5)]
arr4 = [list(map(int, input().split())) for _ in range(5)]
arr5 = [list(map(int, input().split())) for _ in range(5)]

# 격자판 회전한 결과
graph1 = [arr1, rotate_90(arr1), rotate_180(arr1), rotate_270(arr1)]
graph2 = [arr2, rotate_90(arr2), rotate_180(arr2), rotate_270(arr2)]
graph3 = [arr3, rotate_90(arr3), rotate_180(arr3), rotate_270(arr3)]
graph4 = [arr4, rotate_90(arr4), rotate_180(arr4), rotate_270(arr4)]
graph5 = [arr5, rotate_90(arr5), rotate_180(arr5), rotate_270(arr5)]
graph = [graph1, graph2, graph3, graph4, graph5]

# 델타
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]
_dk = [-1, 1]

# BFS
def BFS(_p, _c):
    g1 = graph[_p[0]][_c[0]]
    g2 = graph[_p[1]][_c[1]]
    g3 = graph[_p[2]][_c[2]]
    g4 = graph[_p[3]][_c[3]]
    g5 = graph[_p[4]][_c[4]]
    grid = [g1, g2, g3, g4, g5]
    visited = [[[0 for _ in range(5)] for _ in range(5)] for _ in range(5)] # visited[k][y][x] # k는 층(0이 5층)
    q = deque([(0, 0, 0)]) # k, y, x
    visited[0][0][0] = 1
    if not grid[0][0][0]:
        return -1
    while q:
        k, y, x = q.popleft()
        if (k, y, x) == (4, 4, 4):
            return visited[k][y][x] - 1
        for dy, dx in dydx: # 같은 층 내에서 이동
            ny, nx = y + dy, x + dx
            if 0 <= ny < 5 and 0 <= nx < 5 and not visited[k][ny][nx] and grid[k][ny][nx]:
                visited[k][ny][nx] = visited[k][y][x] + 1
                q.append((k, ny, nx))

        for dk in _dk:
            nk = k + dk
            if 0 <= nk < 5 and not visited[nk][y][x] and grid[nk][y][x]:
                visited[nk][y][x] = visited[k][y][x] + 1
                q.append((nk, y, x))
    return visited[4][4][4] - 1

INF = int(1e9)

def find_min_dist():
    min_d = INF
    for _p in ret:
        for _c in ret2:
            d = BFS(_p, _c)
            if d > 0:
                min_d = min(min_d, d)
                if min_d == 12:
                    return min_d

    if min_d == INF:
        return -1
    return min_d

print(find_min_dist())
