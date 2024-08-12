# 요다 (5363번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
for i in range(N):
    lst = input().rstrip().split()
    m = len(lst)
    for j in range(2, m):
        print(lst[j], end=" ")
    print(lst[0] + " " + lst[1])

