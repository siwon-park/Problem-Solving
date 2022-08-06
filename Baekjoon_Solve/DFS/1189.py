# 컴백홈(1189번)
##################################################################################
    # 문제: https://www.acmicpc.net/problem/1189
    # 백트랙킹, 브루트 포스
    # 어렵지 않은 문제였지만, 실수를 하여 2번 틀렸습니다를 받았다.
    # 했던 실수는 1. 좌측 최하단에서 출발하고 출발 좌표도 카운트하므로 cnt = 1에서 출발하고 visited[R-1][0] = True로 시작해야 했다.
    # 2. k == K일 경우에 카운트를 하게하는 조건을 넣었어야 했어야 했는데, 해당 조건을 넣지 않아서 K보다 작을 때도 cnt += 1을 하고 있었음
    # 자바로 풀어야하는데 시간이 없어서 파이썬으로 풀었다 ㅠㅜ...
##################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

def dfs(y, x, k):
    global cnt
    # 거리가 K보다 크면 return
    if k > K:
        return
    # 우측 최상단 좌표일 경우, k == K이면 cnt += 1을 한 뒤에 return
    if (y, x) == (0, C - 1) and k == K:
        cnt += 1
        return
    for dy, dx in dydx:
        ny, nx = y + dy, x + dx
        if 0 <= ny < R and 0 <= nx < C and not visited[ny][nx] and board[ny][nx] != "T":
            visited[ny][nx] = True
            k += 1
            dfs(ny, nx, k)
            k -= 1
            visited[ny][nx] = False

R, C, K = map(int, input().split())
board = [list(input().rstrip()) for _ in range(R)]
visited = [[False]*C for _ in range(R)]
cnt = 0
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

# 좌측 최하단에서 출발함
visited[R-1][0] = True
dfs(R-1, 0, 1)
print(cnt)
