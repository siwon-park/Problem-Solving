# 패션왕 신혜빈(9375번)
######################################################################
    # 문제: https://www.acmicpc.net/problem/9375
    # 조합
    # 딕셔너리에 해당 종류에 해당하는 옷들을 담은 다음에
    # 종류별 옷의 개수 + 1씩 곱해준다. +1은 0(공집합)의 경우를 추가한 것임
    # 그리고 최종적으로 나온 연산한 값에 -1을 해준다. 모두 공집합인 경우를 제외
######################################################################
import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n = int(input())
    clothes_dic = dict()

    for _ in range(n):
        lst = input().split()

        clothes_dic[lst[1]] = clothes_dic.get(lst[1], []) + [lst[0]]

    ans = 1
    for v in list(clothes_dic.values()):
        N = len(v)
        ans *= (N + 1)

    print(ans - 1)
