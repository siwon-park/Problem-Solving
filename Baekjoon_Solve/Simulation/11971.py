# 속도 위반 (11971번)
import sys
input = sys.stdin.readline

lst1, lst2 = [], []
N, M = map(int, input().rstrip().split())
for i in range(N):
    l, s = map(int, input().rstrip().split())
    for _ in range(l):
        lst1.append(s)

for i in range(M):
    l, s = map(int, input().rstrip().split())
    for _ in range(l):
        lst2.append(s)

max_over_speed = 0
for i in range(min(len(lst1), len(lst2))):
    max_over_speed = max(max_over_speed, lst2[i] - lst1[i])

print(max_over_speed)

