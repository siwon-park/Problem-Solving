import sys
input = sys.stdin.readline

# Either, but Not Both (33171번)

N = int(input().rstrip())
A = int(input().rstrip())
B = int(input().rstrip())


cnt = 0
for i in range(1, N + 1):
    if i % A == 0 and i % B == 0:
        continue
    if i % A == 0:
        cnt += 1
    elif i % B == 0:
        cnt += 1

print(cnt)

