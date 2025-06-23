import sys

input = sys.stdin.readline

# Matched Letters (31616번)
N = int(input().rstrip())
S = input().rstrip()

_set = set(list(S))
if len(_set) == 1:
    print("Yes")
else:
    print("No")

