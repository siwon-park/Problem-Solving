# 공(1547번)
################################################################
    # 문제: https://www.acmicpc.net/problem/1547
    # 구현, 시뮬레이션
    # if 조건문을 많이 사용하기 싫어서 배열을 선언하고 스왑해주는 방식으로 구현하였다.
################################################################
import sys
input = sys.stdin.readline

N = int(input())
ball = [0, 1, 0, 0]
for _ in range(N):
    X, Y = map(int, input().split())
    ball[X], ball[Y] = ball[Y], ball[X]

ans = -1
for i in range(1, 4):
    if ball[i]:
        ans = i

print(ans)
