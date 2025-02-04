import sys
input = sys.stdin.readline

# Railway Trip 3 (33166번)
P, Q = map(int, input().rstrip().split())
A, B = map(int, input().rstrip().split())

if P >= Q:
    print(A * Q)
else:
    print(A * P + B * (Q - P))

