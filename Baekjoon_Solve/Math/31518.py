import sys

input = sys.stdin.readline

# Triple Sevens (31518번)
n = int(input().rstrip())
ans = 0
for _ in range(3):
    lst = list(map(int, input().rstrip().split()))
    for i in range(n):
        if lst[i] == 7:
            ans += 1

if ans == 3:
    print(777)
else:
    print(0)
