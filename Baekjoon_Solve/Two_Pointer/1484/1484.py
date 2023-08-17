# 다이어트 (1484번)
import sys
input = sys.stdin.readline

G = int(input())
s, e = 1, 1  # 기억하고 있는 몸무게, 현재 몸무게
_set = set()

while True:
    diff = e ** 2 - s ** 2
    if e - s == 1 and diff > G:
        break
    if diff == G:
        _set.add(e)
    if diff <= G:
        e += 1
    else:
        s += 1

lst = sorted(list(_set))

if not lst:
    print(-1)
else:
    for num in lst:
        print(num)
