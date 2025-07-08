# 28519번
n, m = map(int, input().split())
if n <= m:
    total = 2 * n
else:
    total = 2 * m
if n != m:
    total += 1
print(total)

