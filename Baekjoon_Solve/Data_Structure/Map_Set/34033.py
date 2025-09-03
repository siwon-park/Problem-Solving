import sys

input = sys.stdin.readline

# 공금 횡령 (34033번)
n, m = map(int, input().rstrip().split())
_dict = {}
for _ in range(n):
    a, b = input().rstrip().split()
    _dict[a] = int(b)

cnt = 0
for _ in range(m):
    c, d = input().rstrip().split()
    d = int(d)
    if d > _dict[c] * 1.05:
        cnt += 1

print(cnt)

