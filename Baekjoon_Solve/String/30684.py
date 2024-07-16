# 모르고리즘 회장 정하기 (30684번)
import sys
input = sys.stdin.readline

N = int(input().rstrip())
lst = []
for i in range(N):
    name = input().rstrip()
    if len(name) == 3:
        lst.append(name)

lst.sort()
print(lst[0])

