# 스트릿 코딩 파이터 (23348번)
import sys
input = sys.stdin.readline

A, B, C = map(int, input().rstrip().split())
N = int(input().rstrip())
ans = 0
for i in range(N):
    ta, tb, tc = 0, 0, 0
    for j in range(3):
        a, b, c = map(int, input().rstrip().split())
        ta += a
        tb += b
        tc += c
    ans = max(ans, ta * A + tb * B + tc * C)

print(ans)

