import sys

input = sys.stdin.readline

# Mines Football (34366번)
M = int(input().rstrip())
a1, a2, a3, a4 = 0, int(1e9), 0, int(1e9)
for _ in range(M):
    lst = list(map(int, input().rstrip().split()))
    a1 = max(a1, max(lst[1:]))
    a2 = min(a2, min(lst[1:]))
    a3 = max(a3, sum(lst[1:]))
    a4 = min(a4, sum(lst[1:]))

print(a1)
print(a2)
print(a3)
print(a4)

