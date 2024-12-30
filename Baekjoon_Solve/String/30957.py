# 빅데이터 vs 정보보호 vs 인공지능 (30957번)
import sys
input = sys.stdin.readline

sba = ['B', 'S', 'A']
cnt = [0, 0, 0]
n = int(input().rstrip())
line = input().rstrip()
for i in range(n):
    w = line[i]
    if w == 'S':
        cnt[1] += 1
    elif w == 'B':
        cnt[0] += 1
    elif w == 'A':
        cnt[2] += 1

_max = max(cnt)
ans = ""
for i in range(3):
    if cnt[i] == _max:
        ans += sba[i]

if ans == 'BSA':
    ans = 'SCU'

print(ans)

