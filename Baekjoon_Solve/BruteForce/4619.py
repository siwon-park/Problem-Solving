import sys

input = sys.stdin.readline

# 루트 (4619번)
while True:
    B, N = map(int, input().rstrip().split())
    if B == 0 and N == 0:
        break
    A = 1
    while A ** N < B:
        A += 1
    diff1 = abs(B - (A ** N))
    diff2 = abs(B - ((A - 1) ** N))
    if diff1 <= diff2:
        print(A)
    else:
        print(A - 1)

