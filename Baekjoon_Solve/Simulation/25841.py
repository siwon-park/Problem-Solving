import sys
input = sys.stdin.readline

# Digit Count (25841번)
n1, n2, k = map(int, input().rstrip().split())
ans = 0
k = str(k)
for i in range(n1, n2 + 1):
    ans += str(i).count(k)

print(ans)

