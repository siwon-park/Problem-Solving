import sys

input = sys.stdin.readline

# 비밀번호 (33702번)

K = int(input().rstrip())
if K % 2:
    print(8)
else:
    print(0)

