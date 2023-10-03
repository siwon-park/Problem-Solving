# 피자 (3213번)
import sys, math
input = sys.stdin.readline

N = int(input().rstrip())
one_fourth = 0  # 1/4
half = 0  # 1/2
three_forth = 0  # 3/4

for i in range(N):
    p = input().rstrip()
    if p == "1/4":
        one_fourth += 1
    elif p == "1/2":
        half += 1
    elif p == "3/4":
        three_forth += 1

pizza = 0
left = 0
# 1/2 조각 피자 주문 개수를 구함
if half % 2 == 0:
    pizza += half // 2
else:
    pizza += (half // 2) + 1
    left = 1  # 1/2 조각이 남음

# 1/2 조각이 한 개 남았고, 1/4조각을 원하는 친구가 2명 이상이면 남은 1/2을 2명에게 나눠줌
if left == 1 and one_fourth >= 2:
    left = 0
    one_fourth -= 2
# 1/4 + 3/4의 개수 중 최솟값으로 피자 한 판씩 주문함
_min = min(one_fourth, three_forth)
pizza += _min
one_fourth -= _min
three_forth -= _min
if one_fourth > 0:
    if one_fourth % 4 == 0:
        pizza += one_fourth // 4
    else:
        pizza += (one_fourth // 4) + 1
elif three_forth > 0:
    pizza += three_forth

print(pizza)
