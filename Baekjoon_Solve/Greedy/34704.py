import sys

input = sys.stdin.readline

# 크기가 4인 박스 (34704번)
N = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))

count = [0] * 5
for num in lst:
    count[num] += 1

ans = count[4]
ans += count[3]
count[1] = max(0, count[1] - count[3])
ans += count[2] // 2
if count[2] % 2:
    ans += 1
    count[1] = max(0, count[1] - 2)

ans += count[1] // 4
if count[1] % 4:
    ans += 1

print(ans)

