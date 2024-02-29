# 오타맨 고창영 (2711번)
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for _ in range(T):
    line = input().rstrip().split()
    n = int(line[0]) - 1
    word = line[1]
    print(word[:n] + word[n + 1:])

