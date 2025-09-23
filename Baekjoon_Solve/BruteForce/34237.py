import sys

input = sys.stdin.readline

# 호참전 (34237번)
N, M = map(int, input().rstrip().split())
tigers = [tuple(map(int, input().rstrip().split())) for _ in range(N)]
matches = [tuple(map(int, input().rstrip().split())) for _ in range(M)]

for i in range(M):
    g, x, y = matches[i]
    cnt = 0
    for j in range(N):
        a, b = tigers[j]
        if x <= a and y <= b and a + b <= g:
            cnt += 1
    print(cnt)

