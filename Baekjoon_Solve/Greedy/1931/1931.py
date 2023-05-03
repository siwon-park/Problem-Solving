import sys
input = sys.stdin.readline
N = int(input())
lst = []

for i in range(N):
    lst.append(list(map(int, input().split())))
lst.sort(key=lambda x: (x[1], x[0]))

count = 1
last = lst[0][1]
for i in range(1, N):
    if lst[i][0] >= last:
        last = lst[i][1]
        count += 1

print(count)