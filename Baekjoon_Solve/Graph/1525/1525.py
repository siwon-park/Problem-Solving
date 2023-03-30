import sys
from collections import deque
input = sys.stdin.readline


def bfs(s: str) -> int:
    q = deque([(s, 0)])
    while q:
        cur_s, cnt = q.popleft()
        if cur_s == target:
            return cnt
        cur = cur_s.index("0") # 0의 위치를 찾음
        lst = list(cur_s)
        y, x = cur // 3, cur % 3
        for k in range(4):
            ny = y + dydx[k][0]
            nx = x + dydx[k][1]
            if 0 <= ny < 3 and 0 <= nx < 3:
                nxt = ny * 3 + nx # 스왑할 인덱스
                lst[nxt], lst[cur] = lst[cur], lst[nxt] # 스왑
                nxt_s = "".join(lst)
                if visited.get(nxt_s) is None:
                    q.append((nxt_s, cnt + 1))
                    visited[nxt_s] = cnt + 1
                lst[nxt], lst[cur] = lst[cur], lst[nxt] # 원위치
    return -1


s = "".join("".join(input().rstrip().split()) for _ in range(3))
target = "123456780"
dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

visited = dict()
visited[s] = 0

print(bfs(s))