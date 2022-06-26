# 점프왕 젤리(large) (16174번)
##################################################################################
    # 문제: https://www.acmicpc.net/problem/16174
    # DFS
    # 오랜만에 풀어보는 DFS 그래프 문제였다.
    # 딱히 난이도 상으로 어려울 것은 없는 문제이다.
    # 예전에는 이런 문제를 마주쳤을 때, 그냥 BFS로 무조건 풀었는데 이제는 DFS도 예전보다는 능숙해진 듯하다.
    # DFS에 대해 배울 때 return값에 따른 함수 호출 종료의 개념이 이해가 안 됐는데, 그 방식을 사용해서 문제를 풀었다. 조금은 성장했다고 생각한다.
##################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]

def dfs(r, c):
    if visited[r][c]:
        return False
    visited[r][c] = True
    if (r, c) == (N - 1, N - 1):
        return True
    if 0 <= r + board[r][c] < N and dfs(r + board[r][c], c):
        return True
    if 0 <= c + board[r][c] < N and dfs(r, c + board[r][c]):
        return True
    return False

if dfs(0, 0):
    print("HaruHaru")
else:
    print("Hing")
