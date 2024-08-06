# 이제는 더 이상 물러날 곳이 없다 (30455번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
if N % 2 == 0:
    print("Duck")
else:
    print("Goose")

