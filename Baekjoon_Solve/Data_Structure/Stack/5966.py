import sys

input = sys.stdin.readline

# Cow Cotillion (5966번)
T = int(input().rstrip())
for tc in range(T):
    n, k = input().rstrip().split()
    n = int(n)
    stack = []
    for i in range(n):
        if not stack:
            stack.append(k[i])
        else:
            if stack[-1] == ">" and k[i] == "<":
                stack.pop()
            else:
                stack.append(k[i])
    if not stack:
        print("legal")
    else:
        print("illegal")

