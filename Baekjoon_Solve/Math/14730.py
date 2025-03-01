import sys
input = sys.stdin.readline

# 謎紛芥索紀 (Small) (14730번)
n = int(input().rstrip())
ans = 0
for i in range(n):
    c, k = map(int, input().rstrip().split())
    ans += c * k

print(ans)
