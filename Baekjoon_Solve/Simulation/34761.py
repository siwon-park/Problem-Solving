import sys

input = sys.stdin.readline

# 같은 배열 (34761번)
N = int(input().rstrip())
A = list(map(int, input().rstrip().split()))
B = list(map(int, input().rstrip().split()))
flag = True
_set = set()
for i in range(N):
    if A[i] != B[i]:
        flag = False
        break
    _set.add(A[i])

for i in range(N, 2 * N):
    if B[i] not in _set:
        flag = False
        break

if not flag:
    print("NO")
else:
    print("YES")

