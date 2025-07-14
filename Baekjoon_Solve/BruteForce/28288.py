import sys

input = sys.stdin.readline

# Special Event (28288번)
n = int(input().rstrip())
attnd = [0 for _ in range(5)]
for i in range(n):
    s = input().rstrip()
    for j in range(5):
        if s[j] == 'Y':
            attnd[j] += 1

_max = max(attnd)
ret = []
for i in range(5):
    if attnd[i] == _max:
        ret.append(i + 1)

print(*ret, sep=",")

