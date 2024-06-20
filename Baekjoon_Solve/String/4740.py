# 거울, 오! 거울 (4740번)
import sys
input = sys.stdin.readline

while True:
    line = input().rstrip('\n')
    if line == "***":
        break
    print(line[::-1])

