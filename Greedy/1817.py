# 짐 챙기는 숌(1817번)
###########################################################################
    # 문제: https://www.acmicpc.net/problem/1817
    # 그리디, 구현
    # 그리디 문제집에 있어서 풀었는데, 그리디라기 보다는 구현 문제라고 본다.
    # 문제의 조건을 잘 읽으면 틀릴 일이 없다
###########################################################################
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
if N:
    lst = list(map(int, input().split()))
cnt = 0
cur = 0 # 현재 박스에 담을 수 있는 잔여량
for i in range(N):
    if cur - lst[i] >= 0:
       cur -= lst[i]
    else: # 현재 잔여량만큼 담을 수 없으니 새 박스에 담음
        cnt += 1
        cur = M - lst[i]

print(cnt)
