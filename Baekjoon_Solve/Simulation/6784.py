import sys

input = sys.stdin.readline

# Multiple Choice (6784번)
n = int(input().rstrip())
students = [input().rstrip() for _ in range(n)]

cnt = 0
for i in range(n):
    ans = input().rstrip()
    if students[i] == ans:
        cnt += 1

print(cnt)

