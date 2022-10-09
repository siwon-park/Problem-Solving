# 헤라클레스와 히드라(10205번)
##############################################################################
    # 문제: https://www.acmicpc.net/problem/10205
    # 구현
    # 단순 구현 문제, 주어진 로직대로 문제를 해결하면 된다.
##############################################################################
import sys
input = sys.stdin.readline

K = int(input())
for k in range(K):
    h = int(input())
    cb = input().rstrip()
    for act in cb:
        if h == 0:
            break
        if act == "c":
            h += 1
        else:
            h -= 1
    print(f'Data Set {k + 1}:')
    print(f'{h}' + "\n")
