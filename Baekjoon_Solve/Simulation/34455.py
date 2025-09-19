import sys

input = sys.stdin.readline

# Donut Shop (34455번)
D = int(input().rstrip())
E = int(input().rstrip())
R = D
for _ in range(E):
    op = input().rstrip()
    Q = int(input().rstrip())
    if op == '+':
        R += Q
    elif op == '-':
        R -= Q

print(R)

