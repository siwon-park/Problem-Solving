import sys, math

input = sys.stdin.readline

# 아깝게 놓친 COSS 장학금 (33896번)
n = int(input().rstrip())
lst = []
for i in range(n):
    name, score, risk, cost = input().rstrip().split()
    score, risk, cost = int(score), int(risk), int(cost)
    lst.append((math.floor((score ** 3) / (cost * (risk + 1))), cost, name))

lst.sort(key=lambda x: (-x[0], x[1], x[2]))

print(lst[1][2])

