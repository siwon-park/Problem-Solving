import sys

input = sys.stdin.readline

# 디딤돌 장학금 (34552번)
M = list(map(int, input().rstrip().split()))
N = int(input().rstrip())
ans = 0
for i in range(N):
    b, l, s = input().rstrip().split()
    b = int(b)
    l = float(l)
    s = int(s)
    if l >= 2.0 and s >= 17:
        ans += M[b]

print(ans)

