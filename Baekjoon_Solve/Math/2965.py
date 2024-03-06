# 캥거루 세마리 (2965번)
import sys
input = sys.stdin.readline

A, B, C = map(int, input().rstrip().split())
print(max(B - A, C - B) - 1)

