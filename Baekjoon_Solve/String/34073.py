import sys

input = sys.stdin.readline

# DORO (34073번)
n = int(input().rstrip())
lst = list(input().rstrip().split())
ret = []
for i in range(n):
    ret.append(lst[i] + "DORO")

print(*ret, end= " ")

