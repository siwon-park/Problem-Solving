# Pole(8716번)
###################################################################
    # 문제: https://www.acmicpc.net/problem/8716
    # 기하학
    # 쉬운 브론즈 문제였는데, 문제를 처음에 잘못 접근해서 30분 이상 소비하였다 ㅠㅜ...
    # 두 직사각형이 서로 공유하는 부분이 있을 때와, 그렇지 않을 때를 고려해서 풀면 된다.
    # 점의 위치(범위)에 따라 공통된 부분의 기준점이 되는 값(위치)이 달라지므로 그것을 토대로 문제를 풀면 된다.
###################################################################
import sys
input = sys.stdin.readline

x1, y1, x2, y2 = map(int, input().split())
x3, y3, x4, y4 = map(int, input().split())
min_x = max_x = min_y = max_y = 0

if x1 <= x3 <= x2:
    min_x = x3
elif x3 <= x1 <= x4:
    min_x = x1

if x1 <= x4 <= x2:
    max_x = x4
elif x3 <= x2 <= x4:
    max_x = x2

if y4 <= y1 <= y3:
    max_y = y1
elif y2 <= y3 <= y1:
    max_y = y3

if y2 <= y4 <= y1:
    min_y = y4
elif y4 <= y2 <= y3:
    min_y = y2

print(abs(max_x - min_x)*abs(max_y - min_y))
