# 흙길 보수하기 (1911번)
import sys, math
input = sys.stdin.readline
N, L = map(int, input().split())
arr = []
for i in range(N):
    s, e = map(int, input().split())
    arr.append([s, e])
arr.sort()
answer = 0
s = arr[0][0]
for i in range(N):
    if s >= arr[i][1]:
        continue
    if s < arr[i][0]:
        s = arr[i][0]
    length = arr[i][1] - s
    count = math.ceil(length / L)
    answer += count
    s += L * count

print(answer)