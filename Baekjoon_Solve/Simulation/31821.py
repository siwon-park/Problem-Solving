# 학식 사주기 (31821번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = [0]
for i in range(N):
    lst.append(int(input().rstrip()))

ans = 0
M = int(input().rstrip())
for i in range(M):
    ans += lst[int(input().rstrip())]

print(ans)

