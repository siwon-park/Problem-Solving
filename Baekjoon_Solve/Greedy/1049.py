# 기타줄(1049번)
##############################################################################################
    # 문제: https://www.acmicpc.net/problem/1049
    # 그리디
    # 입력 받은 값을 각 각 x[0], x[1] 기준으로 정렬한 뒤에
    # 올림하여 세트로 산 가격과 세트로 사고 나머지는 낱개로 산 가격과 전부 낱개로 산 가격을 비교해서
    # 최솟값을 출력하면 된다.
##############################################################################################
import sys, math
input = sys.stdin.readline

N, M = map(int, input().split())

lst = []
for _ in range(M):
    _set, _each = map(int, input().split())
    lst.append((_set, _each))

lst1 = sorted(lst, key=lambda x: x[0])
lst2 = sorted(lst, key=lambda x: x[1])

# 세트로 살 때의 최저와 개별로 살 때의 최저값
set_price = lst1[0][0]
each_price = lst2[0][1]

# 1) 세트로 최대한 산 가격, 2) 세트로 사고 남은 개수는 낱개로 산 가격, 3) 전부 낱개로 산 가격
print(min(math.ceil(N/6) * set_price, (N // 6) * set_price + (N % 6) * each_price, N * each_price))
