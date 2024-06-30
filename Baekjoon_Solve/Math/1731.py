# 추론 (1731번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = []
for i in range(N):
    lst.append(int(input().rstrip()))

if lst[1] - lst[0] == lst[2] - lst[1]:
    print(lst[-1] + lst[1] - lst[0])
else:
    print(lst[-1] * (lst[1] // lst[0]))

