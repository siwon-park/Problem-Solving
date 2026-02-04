import sys
from collections import deque

input = sys.stdin.readline

# 공룡 게임 (34926번)
N, K = map(int, input().rstrip().split())
S = input().rstrip()
queue = deque([0])
visited = [False] * N
visited[0] = True
flag = False
while queue:
    idx = queue.popleft()
    if idx == N - 1:
        flag = True
        break
    nxt_idx1 = idx + 1
    if nxt_idx1 < N and S[nxt_idx1] != "#" and not visited[nxt_idx1]:
        visited[nxt_idx1] = True
        queue.append(nxt_idx1)
    nxt_idx2 = idx + K
    if nxt_idx2 < N and S[nxt_idx2] != "#" and not visited[nxt_idx2]:
        visited[nxt_idx2] = True
        queue.append(nxt_idx2)

print("YES" if flag else "NO")
