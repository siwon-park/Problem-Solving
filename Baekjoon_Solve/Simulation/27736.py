import sys
input = sys.stdin.readline

# 찬반투표 (27736번)
N = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))
cnt = 0
_sum = 0
for i in range(N):
    if lst[i] == 0:
        cnt += 1
    _sum += lst[i]

if cnt >= N / 2:
    print("INVALID")
elif _sum > 0:
    print("APPROVED")
else:
    print("REJECTED")

