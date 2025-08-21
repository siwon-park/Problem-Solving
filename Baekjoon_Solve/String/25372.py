import sys

input = sys.stdin.readline

# 성택이의 은밀한 비밀번호 (25372번)
N = int(input().rstrip())
for i in range(N):
    pwd = input().rstrip()
    if len(pwd) < 6 or len(pwd) > 9:
        print("no")
    else:
        print("yes")
