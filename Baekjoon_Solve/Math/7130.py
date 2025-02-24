# 7130번
m, h = map(int, input().rstrip().split())
n = int(input().rstrip())
ans = 0
for i in range(n):
    c, b = map(int, input().rstrip().split())
    ans += max(c * m, b * h)
    
print(ans)
