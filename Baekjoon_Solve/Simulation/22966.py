import sys

input = sys.stdin.readline

# 가장 쉬운 문제를 찾는 문제 (22966번)
N = int(input().rstrip())
lst = []
for _ in range(N):
    t, d = input().rstrip().split()
    d = int(d)
    lst.append((t, d))

lst.sort(key=lambda x: (x[1], x[0]))

print(lst[0][0])

