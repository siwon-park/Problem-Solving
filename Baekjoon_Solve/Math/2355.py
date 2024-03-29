# 시그마 (2355번)
import sys
input = sys.stdin.readline

A, B = map(int, input().rstrip().split())
print(((abs(B - A) + 1) * (A + B)) // 2)

