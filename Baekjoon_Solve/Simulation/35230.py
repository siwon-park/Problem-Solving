import sys

input = sys.stdin.readline

# Dungeon Equilibrium (35230번)
n = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
cnt_lst = [0] * (n + 1)
ans = 0
for i in range(n):
    cnt_lst[lst[i]] += 1

for i in range(0, n + 1):
    if cnt_lst[i] > i:
        ans += cnt_lst[i] - i
    elif cnt_lst[i] < i:
        ans += cnt_lst[i]

print(ans)
