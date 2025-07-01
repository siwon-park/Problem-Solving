import sys, math

input = sys.stdin.readline

# 단원 평가 (31798번)
a, b, c = map(int, input().rstrip().split())
if a == 0 or b == 0:
    print(c ** 2 - max(a, b))
else:
    print(int(math.sqrt(a + b)))

