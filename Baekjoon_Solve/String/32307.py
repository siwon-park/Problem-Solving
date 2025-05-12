import sys

input = sys.stdin.readline

# Injured Shoulder (32307번)
n = int(input().rstrip())
_set1, _set2 = set(), set()
lst = [input().rstrip() for i in range(n)]
for i in range(n):
    _set1.add(lst[i])
    for j in range(n):
        _set2.add(lst[i] + lst[j])

m = int(input().rstrip())
for i in range(m):
    w = input().rstrip()
    if w in _set1:
        print(1)
    elif w in _set2:
        print(2)
    else:
        print(0)

