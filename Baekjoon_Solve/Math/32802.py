# Mouse Pursuit (32802번)
import sys
input = sys.stdin.readline

n = int(input().rstrip())
cheese, glory = 0, 0
lst = []
for i in range(n):
    op, s, c, g = input().rstrip().split()
    lst.append((op, int(s), int(c), int(g)))

k = int(input().rstrip())

for (op, s, c, g) in lst:
    if s > k:
        continue
    if op == "MISS":
        cheese -= c
        glory -= g
    else:
        cheese += c
        glory += g

print(cheese, glory)

