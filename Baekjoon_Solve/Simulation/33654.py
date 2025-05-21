# 33654번
n = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
ans = []
last = -222222
for a in lst:
    if last <= a:
        ans.append(a)
        last = a

print(*ans)
