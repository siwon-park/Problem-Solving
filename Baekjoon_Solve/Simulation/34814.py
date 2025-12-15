import sys

input = sys.stdin.readline

# SCSC 동아리방 방문 (34814번)
n, m = map(int, input().rstrip().split())
A = list(map(int, input().rstrip().split()))
for i in range(m):
    l, h = map(lambda x: int(x) - 1, input().rstrip().split())
    if A[h] == max(A):
        continue
    else:
        A[l] -= 1

print(*A)

