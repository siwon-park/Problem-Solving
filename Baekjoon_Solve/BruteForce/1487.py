# 물건 팔기 (1813번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = []
for i in range(N):
    p, d = map(int, input().rstrip().split())
    lst.append((p, d))

ans = 0
min_p = 0
for i in range(N):
    cur = lst[i][0]
    tmp = 0
    for j in range(N):
        if cur <= lst[j][0] and cur - lst[j][1] >= 0:
            tmp += cur - lst[j][1]
    if ans < tmp:
        ans = tmp
        min_p = cur
    elif ans == tmp:
        min_p = min(min_p, cur)

print(min_p)

