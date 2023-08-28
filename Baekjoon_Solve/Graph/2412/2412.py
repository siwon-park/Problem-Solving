# 암벽 등반 (2412번)
################################################################################
    # 문제: https://www.acmicpc.net/problem/2412
    # BFS
    # 문제 유형에 이분탐색이 쓰여있길래 무지성으로 mid값에 대해 이분탐색하여 bfs를 하였는데 5%에서 시간초과가 났다.
    # 다음부터 이런 짓은 절대 하지 말아야겠다. 실력 상승에 전혀 도움이 안 된다.
    # 절대값이 2 차이가 나면 이동할 수 있으므로, dy, dx의 범위를 -2 ~ 2까지로 잡고 해당 좌표가 홈으로 주어진 좌표들 중 있으면 방문한다.
    # 그리고 한번 사용한 홈은 제거하여 더 이상 방문하지 못하게 한다.
################################################################################
import sys
from collections import deque
input = sys.stdin.readline


def bfs():
    q = deque([(0, 0, 0)])  # 이동횟수, x, y
    while q:
        cnt, x, y = q.popleft()
        if y == T:
            return cnt
        for dx in range(-2, 3):
            for dy in range(-2, 3):
                nx, ny = x + dx, y + dy
                if (nx, ny) in rocks:
                    q.append((cnt + 1, nx, ny))
                    rocks.remove((nx, ny))  # 한번 사용된 홈은 제거
    return -1


n, T = map(int, input().split())
rocks = set()
for _ in range(n):
    x, y = map(int, input().split())
    rocks.add((x, y))

print(bfs())
