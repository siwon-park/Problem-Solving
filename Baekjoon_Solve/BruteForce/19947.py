# 투자의 귀재 배주형(19947번)
####################################################################################
    # 문제: https://www.acmicpc.net/problem/19947
    # 브루트포스
    # 5년, 3년, 1년 순으로 그리디하게 풀었는데 잘못된 풀이었다.
    # 왜냐하면 실질적으로 그리디로 했을 때, 10000 6이라면 10000 * 1.35 * 1.05 = 14175이고
    # 올바른 답은 10000 * 1.2 * 1.2 = 14400이기 때문이다.
    # 복리 투자에서는 무조건 그리디하게 하는 것이 답이 아닐 수 있음을 알게되었다.
####################################################################################
import sys
input = sys.stdin.readline

H, Y = map(int, input().split())
rate = {5: 1.35, 3: 1.20, 1: 1.05}

max_profit = 0

def dfs(cur, left):
    global max_profit
    if not left:
        max_profit = max(max_profit, cur)
        return

    for y in [5, 3, 1]:
        if (left - y) >= 0:
            dfs(int(cur * rate[y]), left - y)

dfs(H, Y)

print(max_profit)
