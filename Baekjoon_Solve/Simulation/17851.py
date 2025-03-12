import sys

input = sys.stdin.readline

# This Problem’s a Slam Dunk (17851번)
su = list(map(int, input().rstrip().split()))
us = list(map(int, input().rstrip().split()))

su.sort()
us.sort()
ans = 0
for i in range(len(su)):
    if su[i] > us[i]:
        ans += 1

print(ans)

