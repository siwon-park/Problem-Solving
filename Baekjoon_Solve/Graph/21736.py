# 헌내기는 친구가 필요해(21736번)
##################################################################################
    # 문제: https://www.acmicpc.net/problem/21736
    # BFS, DFS
    # DFS로 먼저 풀고 BFS로 풀었다. 처음에 sys.setrecursionlimit을 int(1e5)까지 선언하니 RecursionError가 발생해서 int(1e8)까지 늘렸더니 통과할 수 있었다.
    # 평범한 그래프 탐색 문제인데, BFS가 DFS보다 메모리와 시간적으로 훨씬 효율적이었다.
    # 크게 딱히 막히는 부분은 없어서 해설은 생략하겠다.
##################################################################################
import sys
sys.setrecursionlimit(int(1e8))
input = sys.stdin.readline

def dfs(y, x):
    global cnt
    if visited[y][x]:
        return
    if board[y][x] == "P":
        cnt += 1
    visited[y][x] = True
    for dy, dx in dydx:
        ny, nx = y + dy, x + dx
        if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx]:
            if board[ny][nx] != "X":
                dfs(ny, nx)

N, M = map(int, input().split())
board = []
for i in range(N):
    board.append(list(input().rstrip()))
    for j in range(M):
        if board[i][j] == "I":
            sy, sx = i, j

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

cnt = 0

visited = [[False] * M for _ in range(N)]

dfs(sy, sx)

if not cnt:
    print("TT")
else:
    print(cnt)
    
#################### BFS 풀이 ####################

def bfs(q):
    cnt = 0
    while q:
        y, x = q.popleft()
        if board[y][x] == "P":
            cnt += 1
        for dy, dx in dydx:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx]:
                if board[ny][nx] != "X":
                    visited[ny][nx] = True
                    q.append((ny, nx))
    if cnt:
        return cnt
    return "TT"

N, M = map(int, input().split())
q = deque()
visited = [[False] * M for _ in range(N)]
board = []
for i in range(N):
    board.append(list(input().rstrip()))
    for j in range(M):
        if board[i][j] == "I":
            q.append((i, j))
            visited[i][j] = True

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

print(bfs(q))
