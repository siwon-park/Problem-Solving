import sys

input = sys.stdin.readline

# 31617번
k = int(input().rstrip())
n = int(input().rstrip())
a_lst = list(map(int, input().rstrip().split()))
m = int(input().rstrip())
b_lst = list(map(int, input().rstrip().split()))

_set = set()
for i in range(n):
    for j in range(m):
        if a_lst[i] + k == b_lst[j]:
            _set.add((i, j))

print(len(_set))

