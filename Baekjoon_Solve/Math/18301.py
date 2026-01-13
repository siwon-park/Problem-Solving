import sys, math

input = sys.stdin.readline

# Rats (18301번)
n1, n2, n12 = map(int, input().rstrip().split())
result = math.floor((n1 + 1) * (n2 + 1) / (n12 + 1) - 1)
print(result)
