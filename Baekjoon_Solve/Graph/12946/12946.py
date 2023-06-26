# 육각 보드 (12946번)
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline

N = int(input().rstrip())
dy = [-1, -1, 0, 1, 1, 0]
dx = [0, 1, 1, 0, -1, -1]
board = []
for i in range(N):
    board.append(list(input().rstrip()))


def dfs(y: int, x: int, c: int, d: int) -> bool:
    check[y][x] = c  # c를 색칠함
    for k in range(6):
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < N and 0 <= nx < N and board[ny][nx] == "X":
            # 만약 색칠하지 않은 곳인데, 다른 색(d)를 색칠했을 때 불가능하면 False 반환
            if check[ny][nx] == -1 and not dfs(ny, nx, d, c):
                return False
            # 색칠되어 있는 곳이 c로 같으면 False 반환
            if check[ny][nx] == check[y][x]:
                return False
    return True


min_color = 0
for k in range(2):
    check = [[-1 for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if board[i][j] != "-": # X가 최소 1개 이상이면 min_color도 1개 이상임
                min_color = max(min_color, 1)
                if check[i][j] == -1 and not dfs(i, j, k, 0):
                    min_color = max(min_color, k + 2)
print(min_color)