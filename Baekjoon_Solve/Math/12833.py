# XORXORXOR (12833번)
import sys
input = sys.stdin.readline

A, B, C = map(int, input().rstrip().split())

if C % 2 == 0:
    print(A)
else:
    print(A ^ B)

