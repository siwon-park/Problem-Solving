import sys

input = sys.stdin.readline


# Kinder Surprise (23544번)
_set = set()
n = int(input().rstrip())
for i in range(n):
    s = input().rstrip()
    _set.add(s)

print(n - len(_set))

