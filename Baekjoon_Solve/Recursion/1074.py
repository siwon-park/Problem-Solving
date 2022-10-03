# Z (1074번)
#####################################################################################################
    # 문제: https://www.acmicpc.net/problem/1074
    # 분할정복
    # 시간초과 때문에 답을 찾고야 말았다.
    # 역시 재귀는 아직도 많이 약한 것 같다.
    # 계속 연습해야지
    # 재귀 + 규칙성을 활용해야만 제한 시간안에 통과할 수 있는 문제이다.
#####################################################################################################
import sys
sys.setrecursionlimit(int(1e5))
input = sys.stdin.readline

N, r, c = map(int, input().split())

order = 0

def recur(y, x, w):
    global order

    if (y, x) == (r, c):
        print(order)
        exit()

    if w == 1:
        order += 1
        return

    elif (y > r or  r >= y + w or x > c  or c >= x + w): # (r, c)가 y <= r < y + w와 x <= c < x + w에 속하지 않으면 남은 분면의 개수를 다 더 해줌
        order += w ** 2
        return

    recur(y, x, w // 2)
    recur(y, x + w // 2, w // 2)
    recur(y + w // 2, x, w // 2)
    recur(y + w // 2, x + w // 2, w // 2)

recur(0, 0, 2 ** N)
