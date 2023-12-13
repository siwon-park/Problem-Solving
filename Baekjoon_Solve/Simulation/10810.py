# 공 넣기 (10810번)
import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
lst = [0 for _ in range(N)]

for _ in range(M):
    s, e, k = map(int, input().rstrip().split())
    for i in range(s - 1, e):
        lst[i] = k

print(" ".join(list(map(str, lst))))
