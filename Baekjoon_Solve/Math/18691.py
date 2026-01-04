import sys

input = sys.stdin.readline

# Pokemon Buddy (18691번)
t = int(input().rstrip())
for _ in range(t):
    g, c, e = map(int, input().rstrip().split())
    if g == 1:
        print(max(e - c, 0))
    elif g == 2:
        print(max(3 * (e - c), 0))
    else:
        print(max(5 * (e - c), 0))

