# 주식(11501번)
#############################################################################################
    # 문제: https://www.acmicpc.net/problem/11501
    # 그리디
    # 처음에는 주식의 배열 맨 뒤에 0을 추가해주고 앞에서 부터 순차적으로 주식 가격을 체크하여 이익을 계산하려 하였으나,
    # 생각해보니 뒤에서부터 체크해서 현재 최대 주식가격보다 낮으면 그 차이만큼 이익에 더하고, 현재 최대 주식과 가격이 같거나 높으면
    # 현재 최대 주식 가격을 갱신하는 방법으로 해결할 수 있었다.
#############################################################################################
import sys
input = sys.stdin.readline

T = int(input())
for tc in range(T):
    N = int(input())
    stocks = list(map(int, input().split()))
    profit = 0
    cur_price = stocks[-1]
    for i in range(N - 1, -1, -1):
        if stocks[i] < cur_price:
            profit += cur_price - stocks[i]
        else:
            cur_price = stocks[i]
    print(profit)
