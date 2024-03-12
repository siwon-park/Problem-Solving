# 체육은 코딩과목 입니다 (28295번)
import sys
input = sys.stdin.readline

k = 0
for _ in range(10):
    t = int(input().rstrip())
    if t == 1:  # 오른쪽으로 90도
        k += 1
    elif t == 2:  # 180도
        k += 2
    elif t == 3:  # 왼쪽으로 90도
        k -= 1
    k %= 4

if k == 0:
    print("N")
elif k == 1:
    print("E")
elif k == 2:
    print("S")
else:
    print("W")

