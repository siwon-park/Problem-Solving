# 점프 점프(14248번)
###############################################################
    # 문제: https://www.acmicpc.net/problem/14248
    # BFS
    # 인덱스 예외만 조심하면 쉽게 풀 수 있는 문제
    # 돌 번호는 그대로 넣되, 점핑 하는 거리(jump)를 구할 때는 인덱스 -1을 하여 계산하였고, 방문 체크 등은 N+1개를 선언하여 번호 그대로 접근할 수 있게 구현하였음
###############################################################
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
stones = list(map(int, input().split()))
s = int(input())
visited = [False]*(N+1)
cnt = 0
q = deque([s])
while q:
    cur = q.popleft()
    cnt += 1
    visited[cur] = True
    jump = stones[cur-1]
    if cur - jump > 0:
        if not visited[cur-jump]:
            visited[cur-jump] = True
            q.append(cur-jump)
    if cur + jump <= N:
        if not visited[cur+jump]:
            visited[cur+jump] = True
            q.append(cur+jump)
print(cnt)
