# 가희의 고구마 먹방 (21772번)
"""
    문제: https://www.acmicpc.net/problem/21772
    백트랙킹, 브루트포스
    고구마("S") 위치이면 "."으로 바꿔서 탐색하다가 return하면 다시 "S"로 바꿔준다.
    R과 C가 각각 최대 100 이하이고 T가 10 이하이므로 굳이 방문 배열을 따로 만들어줄 필요가 없다.
    멍청한 실수 때문에 맞왜틀을 하고 있었다.
    ans를 0으로 초기화했어야 했는데 -1로 초기화하는 바람에 93%에서 계속 틀리고 있었다. 어디서 틀렸는지 찾기까지 정말 많은 시간이 걸렸다.
    2 2 3
    G#
    #S
    와 같은 케이스에서 ans가 -1이면 -1을 출력한다. 먹을 수 있는 고구마의 개수는 최소 0개이다. -1개는 존재하지 않는다.
    추가적으로, 현재 결과에서 남은 시간을 전부 더했을 때, 현재 최대 먹은 고구마 수보다 작으면 return하게 하여 최적화를 할 수도 있다.
"""
import sys
sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline


def dfs(t: int, y: int, x: int, ret: int) -> None:
    global ans
    # if ret + T - t <= ans:  # 최적화 코드
    #     return
    if t == T:
        ans = max(ans, ret)
        return
    for dy, dx in dydx:
        ny, nx = y + dy, x + dx
        if 0 <= ny < R and 0 <= nx < C and graph[ny][nx] != "#":
            if graph[ny][nx] == "S":
                graph[ny][nx] = "."
                dfs(t + 1, ny, nx, ret + 1)
                graph[ny][nx] = "S"
            else:
                dfs(t + 1, ny, nx, ret)


dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

R, C, T = map(int, input().split())

graph = []
ans = 0  # -1로 하면 틀린다.
for i in range(R):
    lst = list(input().rstrip())
    graph.append(lst)
    for j in range(C):
        if lst[j] == "G":
            gy, gx = i, j


dfs(0, gy, gx, 0)

print(ans)
