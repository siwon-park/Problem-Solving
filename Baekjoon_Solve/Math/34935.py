import sys

input = sys.stdin.readline

# 오름차순과 비내림차순 (34935번)
n = int(input().rstrip())
arr = list(map(int, input().rstrip().split()))
_last = arr[0]
isAscending = True
for i in range(1, n):
    if _last < arr[i]:
        _last = arr[i]
    else:
        isAscending = False
        break

print(1 if isAscending else 0)

