# Doubles (4641번)
import sys
input = sys.stdin.readline

while True:
    lst = list(map(int, input().rstrip().split()))
    if lst[0] == -1:
        break
    lst = lst[:-1]
    _set = set(lst)
    n = len(lst)
    ans = 0
    for i in range(n):
        if lst[i] * 2 in _set:
            ans += 1
    print(ans)

