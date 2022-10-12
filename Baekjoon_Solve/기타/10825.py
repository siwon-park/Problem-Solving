# 국영수(10825번)
###################################################################
    # 문제: https://www.acmicpc.net/problem/10825
    # 정렬
    # 조건에 맞게 정렬하면 된다.
###################################################################
import sys
input = sys.stdin.readline

N = int(input())
lst = []
for _ in range(N):
    n, k, e, m = list(input().rstrip().split())
    lst.append((int(k), int(e), int(m), n))

lst.sort(key=lambda x: (-x[0], x[1], -x[2], x[3]))

for i in range(N):
    print(lst[i][3])
