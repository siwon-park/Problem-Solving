import sys

input = sys.stdin.readline

# João João (34778번)
lst = list(map(int, input().rstrip().split()))
ans = 0
cnt_lst = [0] * 5
for n in lst:
    cnt_lst[n] += 1

for i in range(1, 5):
    if cnt_lst[i] == 0:
        ans += 1

print(ans)

