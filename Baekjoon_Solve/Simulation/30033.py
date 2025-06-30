import sys

input = sys.stdin.readline

# Rust Study (30033번)
n = int(input().rstrip())
A = list(map(int, input().rstrip().split()))
B = list(map(int, input().rstrip().split()))

cnt = 0
for i in range(n):
    if A[i] <= B[i]:
        cnt += 1

print(cnt)

