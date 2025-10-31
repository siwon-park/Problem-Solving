import sys

input = sys.stdin.readline

# 수도요금 (10707번)
A = int(input().rstrip())
B = int(input().rstrip())
C = int(input().rstrip())
D = int(input().rstrip())
P = int(input().rstrip())

cost_y = B
if P > C:
    cost_y += (P - C) * D

print(min(A * P, cost_y))

