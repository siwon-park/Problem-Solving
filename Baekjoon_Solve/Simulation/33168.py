import sys

input = sys.stdin.readline

# Triangle Addition (33168번)
n = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
while len(lst) > 1:
    m = len(lst)
    tmp = []
    for i in range(m - 1):
        tmp.append(lst[i] + lst[i + 1])
    print(*tmp, sep=" ")
    lst = tmp

