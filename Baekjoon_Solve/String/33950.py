import sys

input = sys.stdin.readline

# 어게인 포닉스 (33950번)
n = int(input().rstrip())
for i in range(n):
    s = input().rstrip()
    s = s.replace("PO", "PHO")
    print(s)

