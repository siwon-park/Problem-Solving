# Two Dots(16929번)
###########################################################################
    # 문제: https://www.acmicpc.net/problem/16929
    # DFS
    # 그렇게 어려운 문제는 아니었는데, 실수 하나 때문에 너무 많은 시간을 헤맸다.
    # 아예 못푸는 것 같았으면 깔끔하게 포기했을 텐데 실수했던 부분을 찾아서 맞히려고해서 오래 걸렸다.
    # 헤맸던 부분은 방문체크를 어떻게 할 것인가와 방향 설정이었는데, 처음 함수 설계할 때는 방향을 고르는 정수 한개를 준 다음
    # 해당 정수 방향의 반대 방향은 지나가지 않게끔하였는데, 그 값으로 -1을 초깃값으로 주었다. 그런데 생각해보면 파이썬은 음수 인덱스가 존재하므로
    # 이렇게 풀 경우 잘 못하면 틀린 케이스가 분명히 나오는 상태였다.
    # 또한 거의 다 풀어놓고 입력을 잘못주고 있어서 왜 답이 안 나오나 고민했었다. 입력으로 주어지는 알파벳에 공백이 없는데 자꾸 한칸씩 띄어넣어서 답이 나오지 않던 것이었다.
###########################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def dfs(y, x, vt, i, j, k):
    vt[y][x] = True
    for dy, dx in dydx:
        ny, nx = y + dy, x + dx
        if 0 <= ny < N and 0 <= nx < M:
            if not vt[ny][nx] and board[ny][nx] == board[y][x]:
                if dfs(ny, nx, vt, i, j, k+1):
                    return True
            if (ny, nx) == (i, j) and k >= 4:
                return True
    return False


def check():
    for i in range(N):
        for j in range(M):
            visited = [[False] * M for _ in range(N)]
            flag = dfs(i, j, visited, i, j, 1)
            if flag:
                return "Yes"
    return "No"


print(check())
