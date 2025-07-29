import sys

input = sys.stdin.readline

# Which Team Should Receive the Sponsor Prize? (29684번)
while True:
    n = int(input().rstrip())
    if n == 0:
        break
    lst = list(map(int, input().rstrip().split()))
    ans = 0
    diff = int(1e9)
    for i in range(n):
        _abs = abs(2023 - lst[i])
        if _abs < diff:
            diff = _abs
            ans = i + 1
    print(ans)

