import sys

input = sys.stdin.readline

# Tasma (8717번)
N = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
for i in range(1, N):
    lst[i] += lst[i - 1]


ans = int(1e9)
for i in range(N - 1):
    ans = min(ans, abs(lst[i] - (lst[N - 1] - lst[i])))
print(ans)

