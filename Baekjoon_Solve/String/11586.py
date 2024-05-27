# 지영 공주님의 마법 거울 (11586번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = []
for _ in range(N):
    lst.append(input().rstrip())

K = int(input().rstrip())
if K == 1:
    for line in lst:
        print(line)
elif K == 2:
    for line in lst:
        print(line[::-1])
else:
    for i in range(N - 1, -1, -1):
        print(lst[i])

