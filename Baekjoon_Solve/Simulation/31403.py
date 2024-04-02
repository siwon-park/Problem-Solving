import sys
input = sys.stdin.readline

A = int(input().rstrip())
B = int(input().rstrip())
C = int(input().rstrip())
print(A + B - C)
print(int(str(A) + str(B)) - C)


