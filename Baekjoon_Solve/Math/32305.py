import sys, math
input = sys.stdin.readline

# Farmers’ Market (32305번)
a, b = map(int, input().rstrip().split())
d = int(input().rstrip())

print(d * math.ceil((a * b) / 12))

