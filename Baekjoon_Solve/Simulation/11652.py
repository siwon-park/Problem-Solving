# 카드 (11652번)
##########################################################################
    # 문제: https://www.acmicpc.net/problem/11652
    # 정렬, 딕셔너리
##########################################################################
import sys
input = sys.stdin.readline

N = int(input().rstrip())
count = dict()
for _ in range(N):
    num = int(input().rstrip())
    count[num] = count.get(num, 0) + 1

lst = list(count.items())
lst.sort(key=lambda x: (-x[1], x[0]))
print(lst[0][0])
