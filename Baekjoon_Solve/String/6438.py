# Reverse Text (6438번)
import sys
input = sys.stdin.readline

N= int(input().rstrip())
for i in range(N):
    print(input().rstrip()[::-1])

