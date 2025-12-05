import sys

input = sys.stdin.readline

# 수열 정렬 (1015번)
N = int(input().rstrip())
lst = list(map(int, input().rstrip().split()))

sorted_lst = []
for (i, e) in enumerate(lst):
    sorted_lst.append((e, i))

sorted_lst.sort(key=lambda x: x[0])

ret = [0] * N
for i in range(N):
    ret[sorted_lst[i][1]] = i

print(*ret)

