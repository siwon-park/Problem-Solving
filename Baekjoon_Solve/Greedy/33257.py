import sys

input = sys.stdin.readline

# 상현이의 물리학및실험1 실험 대작전 (34456번)
N, E = map(int, input().rstrip().split())
lst = list(map(int, input().rstrip().split()))
lst.sort()

ans = 1
for i in range(1, N):
    if lst[i] - lst[i - 1] >= E:
        ans += 1

print(ans)
