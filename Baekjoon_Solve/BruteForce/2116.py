# 주사위 쌓기(2116번)
########################################################
    # 문제: https://www.acmicpc.net/problem/2116
    # 브루트포스, 구현
    # 로직은 조금 고민하니까 해결됬는데, 구현을 하다보니 꼬여서 고생을 좀 했었다.
    # 문제의 그림에 의하면, A가 위 또는 밑이면 F가 밑 또는 위이고, B가 위 또는 밑이면 D가 밑 또는 위이고, C가 위 또는 밑이면 E가 밑 또는 위이다.
    # 따라서 각 6개의 모든 주사위 면에 대해서 각 각 윗면 아랫면 연결을 하여, 위 또는 밑이라 고를 수 없는 숫자를 제외하고
    # 나머지 4개의 수 중에 가장 큰 수를 골라 합산해서 합의 최댓값을 찾으면 된다.
    # N개의 주사위 정보를 담은 2차원의 배열 마지막에 0을 6개 담은 배열을 추가하였다.
    # 그 이유는 현재 주사위의 윗면을 가지고 다음 주사위의 아랫면과 윗면을 찾기 위해서 k+1에 접근하는데, 인덱스 오류를 방지하기 위해서임
########################################################
import sys
input = sys.stdin.readline

N = int(input())
dice = [list(map(int, input().split())) for _ in range(N)]
dice.append([0, 0, 0, 0, 0, 0])
max_total = -1
# 밑면이 0이라면 윗면은 5, 밑면이 1이라면 윗면은 3, 밑면이 2라면 윗면은 4(반대도 성립)
for i in range(6):
    total = 0
    up = dice[0][i] # 현재 주사위의 윗면
    if i == 0:
        ai = 5
    elif i == 5:
        ai = 0
    elif i == 2:
        ai = 4
    elif i == 4:
        ai = 2
    elif i == 3:
        ai = 1
    else:
        ai = 3
    opp = dice[0][ai] # 현재 주사위의 아랫면(opp 갱신을 위해 변수를 먼저 선언한 것임. 0일 때 아랫면은 사실 중요하지 않다.)
    for k in range(N):
        cur_max = 0 # 윗면과 아랫면을 제외한 나머지 4개 숫자 중 최댓값
        for j in range(6):
            if dice[k][j] == up or dice[k][j] == opp: # 윗면 또는 아랫면일 경우 continue하고,
                continue
            if dice[k][j] > cur_max: # cur_max의 최댓값을 갱신해줌
                cur_max = dice[k][j]
        # 다음층 주사위의 아랫면, 윗면을 결정
        for j in range(6):
            if dice[k+1][j] == up: # 다음층에 주사위 번호가 현재의 윗면과 같다면, 윗면-아랫면 로직에 근거하여 반댓면을 구해준다
                if j == 0:
                    aj = 5
                elif j == 5:
                    aj = 0
                elif j == 2:
                    aj = 4
                elif j == 4:
                    aj = 2
                elif j == 1:
                    aj = 3
                else:
                    aj = 1
        opp = up # opp는 다음 주사위의 아랫면이고 이는 현재의 윗면이다.
        up = dice[k+1][aj] # 다음 주사위의 윗면 정보를 up에 
        total += cur_max
    max_total = max(total, max_total)
print(max_total)
