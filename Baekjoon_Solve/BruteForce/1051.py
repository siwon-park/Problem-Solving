# 숫자 정사각형(1051번)
#####################################################################################
    # 문제: https://www.acmicpc.net/problem/1051
    # 브루트포스
    # 기준이 되는 (r, c)에서 (r + w, c), (r, c + w), (r + w, c + w)에 있는 값이 같은지만 확인해서
    # 최대 너비를 구하면 된다.
#####################################################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, input().rstrip())))

max_w = min(N, M) # 정사각형의 최대 너비
max_width = -int(1e9)
for r in range(N):
    for c in range(M):
        for w in range(max_w):
            if r + w < N and c + w < M:
                dot1 = graph[r][c]
                dot2 = graph[r + w][c]
                dot3 = graph[r][c + w]
                dot4 = graph[r + w][c + w]
                if dot1 == dot2 == dot3 == dot4:
                    max_width = max(max_width, (w + 1) ** 2)

print(max_width)
