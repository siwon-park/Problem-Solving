# Call for Problems (32498번)
import sys
input = sys.stdin.readline

n = int(input().rstrip())
cnt = 0
for i in range(n):
    d = int(input().rstrip())
    if d % 2:
        cnt += 1

print(cnt)

