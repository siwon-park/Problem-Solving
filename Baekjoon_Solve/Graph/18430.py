# 무기 공학(18430번)
#############################################################################################
    # 문제: https://www.acmicpc.net/problem/18430
    # 백트랙킹
    # 5%에서 시간초과가 나서 다른 사람의 풀이를 참고해서 풀었다.
    # 현재를 기준으로 4개의 모양을 탐색하는 것과, 그 다음 칸으로 옮겨가는 것, 그리고 c가 M이 되었을 때는 아랫칸으로
    # r이 N이 되었을 때는 0을 반환하고 탐색을 종료하는 것이 포인트였다.
#############################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
visited = [[False for _ in range(M)] for _ in range(N)]

def backtrack(r, c):
    if r == N:
        return 0
    if c == M:
        return backtrack(r + 1, 0)
    ret = 0
    if not visited[r][c]:
        visited[r][c] = True
        if r + 1 < N and c - 1 >= 0 and not visited[r + 1][c] and not visited[r][c - 1]:
            visited[r + 1][c], visited[r][c - 1] = True, True
            ret = max(ret, backtrack(r, c + 1) + 2 * graph[r][c] + graph[r + 1][c] + graph[r][c - 1])
            visited[r + 1][c], visited[r][c - 1] = False, False

        if r + 1 < N and c + 1 < M and not visited[r + 1][c] and not visited[r][c + 1]:
            visited[r + 1][c], visited[r][c + 1] = True, True
            ret = max(ret, backtrack(r, c + 1) + 2 * graph[r][c] + graph[r + 1][c] + graph[r][c + 1])
            visited[r + 1][c], visited[r][c + 1] = False, False

        if r - 1 >= 0 and c - 1 >= 0 and not visited[r - 1][c] and not visited[r][c - 1]:
            visited[r - 1][c], visited[r][c - 1] = True, True
            ret = max(ret, backtrack(r, c + 1) + 2 * graph[r][c] + graph[r - 1][c] + graph[r][c - 1])
            visited[r - 1][c], visited[r][c - 1] = False, False

        if r - 1 >= 0 and c + 1 < M and not visited[r - 1][c] and not visited[r][c + 1]:
            visited[r - 1][c], visited[r][c + 1] = True, True
            ret = max(ret, backtrack(r, c + 1) + 2 * graph[r][c] + graph[r - 1][c] + graph[r][c + 1])
            visited[r - 1][c], visited[r][c + 1] = False, False

        visited[r][c] = False
    ret = max(ret, backtrack(r, c + 1))
    return ret

print(backtrack(0, 0))
