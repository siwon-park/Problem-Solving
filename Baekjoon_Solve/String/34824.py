import sys

input = sys.stdin.readline

# 연대 다음 고대 (34824번)
n = int(input().rstrip())
flag = 0
for i in range(n):
    s = input().rstrip()
    if s == "korea" and flag == 0:
        flag = 1
    elif s == "yonsei" and flag == 0:
        flag = 2

if flag == 1:
    print("Yonsei Lost...")
else:
    print("Yonsei Won!")

