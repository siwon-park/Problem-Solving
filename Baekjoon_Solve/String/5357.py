import sys

input = sys.stdin.readline

# Dedupe (5357번)
n = int(input().rstrip())
for _ in range(n):
    line = input().rstrip()
    lst = []
    last = ""
    for c in line:
        if c != last:
            lst.append(c)
            last = c

    print("".join(lst))

