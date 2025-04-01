import sys

input = sys.stdin.readline

# From 1987 to 2013 (6751번)

Y = int(input().rstrip())
flag = False
ans = 0
while not flag:
    _dict = dict()
    ny = Y + 1
    unique_cnt = 0
    while ny > 0:
        r = ny % 10
        _dict[r] = _dict.get(r, 0) + 1
        unique_cnt = max(unique_cnt, _dict[r])
        ny //= 10
    if unique_cnt < 2:
        flag = True
        ans = Y + 1
    Y += 1

print(ans)

