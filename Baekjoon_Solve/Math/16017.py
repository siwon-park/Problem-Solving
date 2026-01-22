import sys

input = sys.stdin.readline

# Telemarketer or not? (16017번)
a = int(input().rstrip())
b = int(input().rstrip())
c = int(input().rstrip())
d = int(input().rstrip())

if (a == 8 or a == 9) and (d == 8 or d == 9) and b == c:
    print("ignore")
else:
    print("answer")

