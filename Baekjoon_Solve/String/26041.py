import sys

input = sys.stdin.readline

# 비슷한 전화번호 표시 (26041번)
lst = input().rstrip().split()
B = input().rstrip()
ans = 0
for A in lst:
    if A != B and A.startswith(B):
        ans += 1

print(ans)

