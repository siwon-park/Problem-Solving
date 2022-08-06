# 알래스카(4159번)
####################################################################################################
    # 문제: https://www.acmicpc.net/problem/4159
    # 그리디
    # 얼핏 보면 정렬 한 뒤에 인접한 두 요소간 차이가 그냥 200이하면 POSSIBLE이고 그렇지 않으면 IMPOSSIBLE 같지만
    # 1422인 지점까지 갔다가 돌아와야하므로
    # 마지막 요소에서 1422까지의 왕복거리가 200이하인지 확인한 다음에 POSSIBLE인지 IMPOSSIBLE인지를 파악하여 출력해야한다
####################################################################################################
import sys
input = sys.stdin.readline

while True:
    N = int(input())
    if not N:
        break
    else:
        lst = []
        for _ in range(N):
            lst.append(int(input()))
        lst.sort()
        last = 0
        possible = True
        for i in range(1, N):
            if lst[i] - last <= 200: # 각 충전소 간 거리가 200이하면 갈 수 있음
                last = lst[i]
            else:
                possible = False # 아니면 못 감
        # 그런데 1422까지 갔다가 돌아와야하는데 왕복 거리가 200보다 크면 못 감
        if 2*(1422 - last) > 200:
            possible = False
        if not possible:
            print("IMPOSSIBLE")
        else:
            print("POSSIBLE")
