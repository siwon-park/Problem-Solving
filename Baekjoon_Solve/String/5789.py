# 한다 안한다 (5789번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
for _ in range(N):
    line = input().rstrip()
    m = len(line)
    if line[m // 2 - 1] == line[m // 2]:
        print("Do-it")
    else:
        print("Do-it-Not")

