import sys

input = sys.stdin.readline

# Judging Moose (15025번)
l, r = map(int, input().rstrip().split())
if l == 0 and r == 0:
    print("Not a moose")
elif l == r:
    print("Even", l + r)
else:
    print("Odd", max(l, r) * 2)

