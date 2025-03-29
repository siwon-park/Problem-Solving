import sys

input = sys.stdin.readline

# Numbers (5489번)
N = int(input().rstrip())
_dict = dict()
appear = 0
_min = int(1e9)
for _ in range(N):
    x = int(input().rstrip())
    _dict[x] = _dict.get(x, 0) + 1
    if _dict[x] > appear:
        _min = x
        appear = _dict[x]
    elif _dict[x] == appear:
        _min = min(x, _min)

print(_min)

