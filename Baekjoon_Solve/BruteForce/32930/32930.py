# 슈팅 연습 (32930번)
import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
lst, used = [], [False for i in range(N + M)]
for i in range(N):
    tx, ty = map(int, input().rstrip().split())
    lst.append((tx, ty))

ans = 0
idx = 0
x, y = 0, 0
for i in range(M):
    n = len(lst)
    score = 0
    cur_x, cur_y = x, y
    for j in range(n):
        if not used[j]:
            tx, ty = lst[j]
            cur = (cur_x - tx) ** 2 + (cur_y - ty) ** 2
            if cur > score:
                score = cur
                idx = j
                x, y = tx, ty
    used[idx] = True
    ans += score
    # 새로 나타날 과녁
    nx, ny = map(int, input().rstrip().split())
    lst.append((nx, ny))

print(ans)

