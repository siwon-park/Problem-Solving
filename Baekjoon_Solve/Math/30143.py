import sys

input = sys.stdin.readline

# Cookie Piles (30143번)
t = int(input().rstrip())
for _ in range(t):
    n, a, d = map(int, input().rstrip().split())
    ans = 0
    for i in range(n):
        ans += a + d * i
    print(ans)
