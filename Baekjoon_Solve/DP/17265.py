# 나의 인생에는 수학과 함께(17265번)
############################################################################################################
    # 문제: https://www.acmicpc.net/problem/17265
    # DP, DFS
    # 간만에 메모이제이션으로 풀었다.
    # 사실 며칠 전 주말에 도전했으나, 두 시간을 잡았는데도 풀리지 않아서 끙끙됐는데 오늘 30분도 안돼서 바로 풀었다.
    # 그리고 내가 어디서 실수를 했는지 알았다. 처음 도전했을 때, board[r][c]가 연산자일 경우 해당 연산자를 dfs 함수의 인자로 전달했고
    # board[r][c]가 연산자가 아닐 경우, 인자로 전달받은 연산자를 토대로 계산하는 로직을 짰다.
    # 허나 이 로직에는 큰 문제가 있었는데, 바로 (N-1, N-1)에서 출발하니까 제일 처음 함수를 호출할 때는 숫자여서
    # 연산자에 대한 정보를 위쪽 연산자로 해야할지, 왼쪽 연산자로 해야할지 모르는 상태이기 때문에 ""(공백)을 넣어줬다.
    # 그러니까 결과적으로 연산자가 아닐 경우에 대해서 계산을 할 수 없으니(더하기, 빼기, 곱하기가 아니니까)
    # 메모에 제대로 계산되어 기록이 되지 않는 문제가 발생했던 것이었다.
    # 오늘 풀 때는 해당 연산자를 함수의 인자로 전달하지 않고, 직접 board[r-1][c] 또는 board[r][c-1]의 상태를 보고 계산하게끔 하니까
    # 원하는 대로 결과가 나와서 풀 수 있었다.
    # 테스트를 위해 max값만 먼저 계산하게 끔 해봤고, 그 다음 min값에도 적용시켜보니 제대로 나와서 k값에 따라 min, max를 계산하게끔 함수를 수정하였다.
    # N의 범위도 작고, 그리 어려운 문제가 아니었는데 지난 주말에 많은 시간을 썼음에도 풀지 못해 아직도 실력이 모자라다고 느꼈었다.
    # 실수 때문이었지만, 그래도 단순 실수라기 보다는 내가 설계를 완벽하게 하지 못해서 발생한 일이었다고 생각한다.
    # 문제를 잘 읽고, 이해해서 설계를 잘하는 게 중요하다는 것을 다시금 느꼈다.
############################################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
board = [list(input().rstrip().split()) for _ in range(N)]

memo = [[[0, 0] for _ in range(N)] for _ in range(N)]
memo[0][0] = [int(board[0][0]), int(board[0][0])]

INF = sys.maxsize

def dfs(r, c, k):
    if r == 0 and c == 0:
        return memo[0][0][k]
    if memo[r][c][k]:
        return memo[r][c][k]
    if k == 0:
        up, left = -INF, -INF
    elif k == 1:
        up, left = INF, INF
    # 위쪽 탐색
    if r - 1 >= 0:
        # 연산자일 경우
        if board[r][c] == "+" or board[r][c] == "-" or board[r][c] == "*":
            up = dfs(r - 1, c, k)
        else:
            board[r][c] = int(board[r][c])
            if board[r - 1][c] == "+":
                up = dfs(r - 1, c, k) + board[r][c]
            elif board[r - 1][c] == "-":
                up = dfs(r - 1, c, k) - board[r][c]
            elif board[r - 1][c] == "*":
                up = dfs(r - 1, c, k) * board[r][c]
    # 왼쪽 탐색
    if c - 1 >= 0:
        if board[r][c] == "+" or board[r][c] == "-" or board[r][c] == "*":
            left = dfs(r, c - 1, k)
        else:
            board[r][c] = int(board[r][c])
            if board[r][c-1] == "+":
                left = dfs(r, c - 1, k) + board[r][c]
            elif board[r][c-1] == "-":
                left = dfs(r, c - 1, k) - board[r][c]
            elif board[r][c-1] == "*":
                left = dfs(r, c - 1, k) * board[r][c]

    if k == 0:
        memo[r][c][k] = max(up, left)
    elif k == 1:
        memo[r][c][k] = min(up, left)
    return memo[r][c][k]

dfs(N-1, N-1, 0)
dfs(N-1, N-1, 1)

print(*memo[N-1][N-1])
