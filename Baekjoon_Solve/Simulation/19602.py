import sys

input = sys.stdin.readline

# Dog Treats (19602번)
s = int(input().rstrip())
m = int(input().rstrip())
l = int(input().rstrip())

_sum = s * 1 + m * 2 + l * 3
if _sum >= 10:
    print("happy")
else:
    print("sad")

