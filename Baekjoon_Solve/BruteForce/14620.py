# 꽃길(14620번)
###############################################################################
    # 문제: https://www.acmicpc.net/problem/14620
    # 완전탐색, 브루트포스
    # 꽃이 4방으로 1칸씩 피고 서로 겹치면 안 되므로, 가운데 좌표를 기준으로 y, x의 절댓값 차이의 합이 2 이하이면 겹치게 되므로
    # 3개 모두 2보다 클 경우에 대해서만 좌표의 상, 하, 좌, 우, 가운데 합을 계산하면 된다
    # 1 ~ N-2의 범위의 모든 좌표를 담아서, 3중 for 구문으로 절댓값의 차이의 합을 계산해서 2 이하이면 continue를 하였다.
###############################################################################
import sys
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

dydx = [(-1, 0), (0, 1), (1, 0), (0, -1)]

lst = []
for i in range(1, N-1):
    for j in range(1, N-1):
        lst.append((i, j))

min_sum = int(1e9)
n = len(lst)
for i in range(n):
    for j in range(i+1, n):
        if abs(lst[i][0] - lst[j][0]) + abs(lst[i][1] - lst[j][1]) <= 2:
            continue
        for k in range(j+1, n):
            if abs(lst[i][0] - lst[k][0]) + abs(lst[i][1] - lst[k][1]) <= 2:
                continue
            if abs(lst[j][0] - lst[k][0]) + abs(lst[j][1] - lst[k][1]) <= 2:
                continue
            y1, x1 = lst[i]
            y2, x2 = lst[j]
            y3, x3 = lst[k]
            sum1, sum2, sum3 = board[y1][x1], board[y2][x2], board[y3][x3]
            for dy, dx in dydx:
                sum1 += board[y1+dy][x1+dx]
                sum2 += board[y2+dy][x2+dx]
                sum3 += board[y3+dy][x3+dx]
            min_sum = min(min_sum, sum1 + sum2 + sum3)

print(min_sum)
