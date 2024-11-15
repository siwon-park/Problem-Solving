# 인간은 무엇인가 (32651번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
if N > 100000:
    print("No")
else:
    if N % 2024 == 0:
        print("Yes")
    else:
        print("No")

