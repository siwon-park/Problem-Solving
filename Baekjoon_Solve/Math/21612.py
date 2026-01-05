import sys

input = sys.stdin.readline

# Boiling Water (21612번)
b = int(input().rstrip())
p = 5 * b - 400
print(p)
if p < 100:
    print(1)
elif p == 100:
    print(0)
else:
    print(-1)
