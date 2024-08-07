# 유니대전 퀴즈쇼 (20362번)
import sys
input = sys.stdin.readline

N, S = input().rstrip().split()
N = int(N)
idx = 0
lst = []
for i in range(N):
    name, chat = input().rstrip().split()
    lst.append((name, chat))
    if name == S:
        idx = i

cnt = 0
for i in range(idx):
    if lst[i][1] == lst[idx][1]:
        cnt += 1

print(cnt)

