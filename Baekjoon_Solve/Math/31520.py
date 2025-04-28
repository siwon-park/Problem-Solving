import sys

input = sys.stdin.readline

# Champernowne Verification (31520번)
n = input().rstrip()
kth_num = ""
ans = -1
for i in range(1, 10):
    kth_num += str(i)
    if n == kth_num:
        ans = i
        break

print(ans)

