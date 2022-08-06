# 주유소(13305번)
#############################################################
    # 문제: https://www.acmicpc.net/problem/13305
    # 그리디 알고리즘
    # 일단, 각 주유소의 단위 가격이 모두 1이라면 그냥 cost 값의 합을 리턴하면 됨
    # 아니라면, 현재까지의 최소 가격을 기준으로 cost값을 곱한 값을 total_price에 더해가면서,
    # 현재 최솟값보다 더 작은 값이 나온다면 해당 값을 갱신해주면서 같은 과정을 반복하면 된다. 
#############################################################
import sys
input=sys.stdin.readline
N=int(input())
cost=list(map(int,input().split()))
oil_price=list(map(int,input().split()))

def oil_station():
    if set(oil_price)=={1}:
        return sum(cost)
    min_price=oil_price[0]
    total_price=0
    for i in range(len(oil_price)-1):
        if oil_price[i]<min_price:
            min_price=oil_price[i]
        total_price+=min_price*cost[i]
    return total_price
    
print(oil_station())
